package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author jiezhou
 * @CalssName: LOckSupperDemo
 * @Package org.buptdavid.datastructure.zj.zookeeper_book_my.test
 * @Description: LockSupport 测试
 * @date 2020/11/20/9:22
 *
 *  LockSupport详解

    ①. 什么是LockSupport?
    通过park()和unpark(thread)方法来实现阻塞和唤醒线程的操作
    LockSupport是一个线程阻塞工具类，所有的方法都是静态方法，可以让线程在任意位置阻塞，阻塞之后也有对应的唤醒方法。归根结底，LockSupport调用的Unsafe中的native代码。
    官网解释：
    LockSupport是用来创建锁和其他同步类的基本线程阻塞原语
    LockSupport类使用了一种名为Permit(许可）的概念来做到阻塞和唤醒线程的功能，每个线程都有一个许可(permit),permit只有两个值1和零，默认是零
    可以把许可看成是一种(0,1)信号量(Semaphore），但与Semaphore不同的是，许可的累加上限是1
    ②. 阻塞方法
    permit默认是0，所以一开始调用park()方法，当前线程就会阻塞，直到别的线程将当前线程的permit设置为1时, park方法会被唤醒，然后会将permit再次设置为0并返回。
    static void park( )：底层是unsafe类native方法
    static void park(Object blocker)
    ③.唤醒方法(注意这个permit最多只能为1)
    调用unpark(thread)方法后，就会将thread线程的许可permit设置成1(注意多次调用unpark方法，不会累加，permit值还是1)会自动唤醒thread线程，即之前阻塞中的LockSupport.park()方法会立即返回
    static void unpark( )
    ④. LockSupport它的解决的痛点
    LockSupport不用持有锁块，不用加锁，程序性能好
    先后顺序，不容易导致卡死(因为unpark获得了一个凭证，之后再调用park方法，就可以名正言顺的凭证消费，故不会阻塞)
 */
public class LockSupportDemo {

    public static void m1() {
        final Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                System.out.println(currentThread().getName() + "等待通行证...");
                LockSupport.park();//等待通行证，相当于wait
                System.out.println(currentThread().getName() + "通行...");
            }
        };
        t1.start();
        new Thread("t2") {
            @Override
            public void run() {
                System.out.println("给线程 " + t1.getName() + "加通行证...");
                LockSupport.unpark(t1);
            }
        }.start();
    }

    public static void main(String[] args) {
        m1();
    }
}
