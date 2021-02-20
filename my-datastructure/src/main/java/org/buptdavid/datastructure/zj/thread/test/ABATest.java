package org.buptdavid.datastructure.zj.thread.test;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author jiezhou
 * @CalssName: ABATest
 * @Package org.buptdavid.datastructure.zj.thread.test
 * @Description: Cas 的ABA问题演示及其解决方案
 * <p>
 * CAS 缺点：
 * 1、ABA问题
 * 2、可能会出现占用cpu过大，消耗资源
 * 3、每次只能对一个变量进行处理
 * * @date 2021/2/20/10:53
 */
public class ABATest {
    //    static AtomicReference<Integer> var = new AtomicReference(100);
    static AtomicStampedReference<Integer> var = new AtomicStampedReference(100, 0);

    //    static AtomicInteger var = new AtomicInteger(100);
//     AtomicReference atomicReference = new AtomicReference();//普通原子引用
//   AtomicStampedReference  版本号（时间戳）的原子引用，这个更加强大
    public static void main(String[] args) {
        /*Thread t1 = new Thread() {
            @Override
            public void run() {
                var.compareAndSet(100, 101);
                var.compareAndSet(101, 100);
                System.out.println("t1   "+var.get());
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                var.compareAndSet(100,2019);
                System.out.println("t2   "+var.get());
            }
        };
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();*/
        Thread t1 = new Thread() {
            @Override
            public void run() {
                var.compareAndSet(100, 101, var.getStamp(), var.getStamp() + 1);
                var.compareAndSet(101, 100, var.getStamp(), var.getStamp() + 1);
                System.out.println("t1   " + var.getReference() + "版本号：" + var.getStamp());
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int stamp = var.getStamp();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                var.compareAndSet(100, 2019, stamp, stamp + 1);
                System.out.println("t2   " + var.getReference() + "版本号：" + stamp);
            }
        };
        t1.start();
        t2.start();


        /**
         * 出现：ConcurrentModificationException  并发修改异常，（常见的异常）
         *
         * ArrayList 线程不安全
         *
         * 解决方案：
         * 1、new Vector<>();
         * 2、Collections.synchronizedList(new ArrayList<>());
         * 3、JUC 里面的  CopyOnWriteArrayList    （写时复制）
         * */

        /**
         *
         *
         * 自旋锁（spinLock，也就是CAS +while）是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式尝试获取锁，
         *  优点：减少线程上下文切换的消耗
         *  缺点：长时间获取不到锁，一直执行while,会消耗大量cpu，从而导致性能下降
        *
        * */
    }
}
