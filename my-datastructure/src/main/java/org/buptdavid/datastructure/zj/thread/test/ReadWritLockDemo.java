package org.buptdavid.datastructure.zj.thread.test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 1.Java并发库中ReetrantReadWriteLock实现了ReadWriteLock接口并添加了可重入的特性
 * 2.ReetrantReadWriteLock读写锁的效率明显高于synchronized关键字
 * 3.ReetrantReadWriteLock读写锁的实现中，读锁使用共享模式；写锁使用独占模式，换句话说，也就是读锁可以在没有写锁的时候被多个线程同时持有，写锁是独占的
 * 4.ReetrantReadWriteLock读写锁的实现中，需要注意的，当有读锁时，写锁就不能获得；而当有写锁时，除了获得写锁的这个线程可以获得读锁外，其他线程不能获得读锁
 * <p>
 */
public class ReadWritLockDemo {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    //Java并发库中ReetrantReadWriteLock实现了ReadWriteLock接口并添加了可重入的特性。
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writLock = reentrantReadWriteLock.writeLock();

    private volatile int value = 10000;

    public int handeRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            System.out.println("正在读取...");
            Thread.sleep(1000);
            System.out.println("读取完成...");
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handWrit(Lock lock, int value) throws InterruptedException {
        try {
            lock.lock();
            System.out.println("正在写入...");
            Thread.sleep(1000);
            this.value = value;
            System.out.println("写入完成...");
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final ReadWritLockDemo readWritLockDemo = new ReadWritLockDemo();
        long millis1 = System.currentTimeMillis();
        Runnable runnableRead = new Runnable() {
            @Override
            public void run() {
                try {
                    int value = readWritLockDemo.handeRead(readLock);
                    System.out.println("value = " + value);
//                    readWritLockDemo.handeRead(reentrantLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        long millis2 = System.currentTimeMillis();
        Runnable runnableWrit = new Runnable() {
            @Override
            public void run() {
                try {
                    readWritLockDemo.handWrit(writLock, new Random().nextInt());
//                    readWritLockDemo.handWrit(reentrantLock,new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        for (int i = 0; i < 18; i++) {
            new Thread(runnableRead).start();
        }

        for (int i = 18; i < 30; i++) {
            new Thread(runnableWrit).start();
        }

        long millis3 = System.currentTimeMillis();
//        Thread.sleep(6000);
        System.out.println("读readLock：需要的时间：" + String.valueOf(millis3 - millis1));
        //System.out.println("读reentrantLock：需要的时间："+String.valueOf(millis2-millis1));
    }


}
