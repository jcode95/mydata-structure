package org.buptdavid.datastructure.zj.thread.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author jiezhou
 * @CalssName: ReferenceTest
 * @Package org.buptdavid.datastructure.zj.thread.reference
 * @Description: 强引用，软引用，弱引用，虚引用 的测试
 * @date 2021/2/23/17:36
 */
public class ReferenceTest {


    /*
    * java.lang.Object
        java.lang.ref.Reference<T>
            java.lang.ref.PhantomReference<T>
            java.lang.ref.SoftReference<T>
            java.lang.ref.WeakReference<T>
        java.lang.ref.ReferenceQueue<T>
    *
    * */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("***************强引用********** = ");
        Object o1 = new Object();
        /*强引用*/
        //永远不会被回收,当JVM的内存空间不足时，宁愿抛出OutOfMemoryError使得程序异常终止也不会回收具有强引用的存活着的对象！
        Object o2 = o1;
        o1 = null;
        System.out.println("o2 = " + o2);
        System.out.println("***************软引用********** = ");
        /*软引用*/
        //内存不足就回收,足就不回收
        ReferenceTest test = new ReferenceTest();
//        test.softReferenceNotMemory();
        test.softReferenceMemory();
        System.out.println("***************弱引用********** = ");
        /*弱引用*/
        test.weakReference();
        System.out.println("***************虚引用********** = ");
        /*虚引用*/
        test.phantomReference();
    }

    /**
     * 内存不足时的软引用测试方法
     * -Xms10m -Xmx10m
     * 软引用一般用来实现内存敏感的缓存，如果有空闲内存就可以保留缓存，当内存不足时就清理掉，这样就保证使用缓存的同时不会耗尽内存
     */
    public void softReferenceNotMemory() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        o = null; //去除强引用,强引用不去除，软引用是不生效的
        System.out.println("softReference.get() = " + softReference.get());
        try {
            byte[] bytes = new byte[12 * 1024 * 1024];//定义一个12m 大小的数组，会出现内存不足
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("softReference.get() = " + softReference.get());
        }
    }

    /**
     * 内存足时的软引用测试方法
     */
    public void softReferenceMemory() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);
        System.out.println("softReference.get() = " + softReference.get());
    }

    /**
     * 弱引用，每次触发gc都会回收对象
     */
    public void weakReference() {
        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<Object>(o);
        System.out.println("gc之前的弱引用 = " + weakReference.get());
        o = null;//清除强引用
        System.gc();
        System.out.println("gc之后的弱引用 = " + weakReference.get());
    }
    /**
     * 虚引用，任何时候可能被GC回收，就像没有引用一样。无法通过虚引用访问对象的任何属性或者函数。那就要问了要它有什么用？虚引用仅仅只是提供了一种确保对象被finalize以后来做某些事情的机制。
     * 比如说这个对象被回收之后发一个系统通知啊啥的(也就是在对象回收之前吧对象存入引用队列里面)。虚引用是必须配合ReferenceQueue 使用的
     *
     */
    public void phantomReference() throws InterruptedException {
        Object o = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference= new PhantomReference<Object>(o, queue);
        System.out.println("o = " + o);
        System.out.println("phantomReference.get() = " + phantomReference.get());//phantomReference.get() 任何时候永远返回null
        System.out.println("queue.poll() = " + queue.poll());
        /*执行gc*/
        o=null;
        System.gc();
        Thread.sleep(500);

        System.out.println("=============执行gc之后============ = ");
        System.out.println("o = " + o);
        System.out.println("phantomReference.get() = " + phantomReference.get());
        System.out.println("queue.poll() = " + queue.poll());
    }
}
