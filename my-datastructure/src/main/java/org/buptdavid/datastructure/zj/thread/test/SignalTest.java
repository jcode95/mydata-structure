package org.buptdavid.datastructure.zj.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *signal与await的使用
 */
public class SignalTest {

    public static void main(String[] args) {
        final ReentrantLock lock=new ReentrantLock();
        final Condition condition = lock.newCondition();
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();//加锁
                try {
                    System.out.println("condition  awaiting  ....");
                    condition.await();//await：释放当前锁持有的锁，生成线程等待node，存储到condition中的单链表中，等被唤醒的时候，在加入到锁的等待队列
                    System.out.println("condition  awaitend ");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                   if(lock.isLocked()){
                       lock.unlock();
                   }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            /*@Override
            public void run() {
                lock.lock();//获取锁
                try {
                    System.out.println("condition  signaling  ....");
                    condition.signal();//相当于notify
                    System.out.println("condition  signalend ");
                }finally {
                    if(lock.isLocked()){
                        lock.unlock();
                    }
                }
            }*/
            @Override
            public void run() {
                try {
                    if(lock.tryLock()){
                        System.out.println("condition  signaling  ....");
                        condition.signal();//相当于notify,signal：唤醒condition等待队列里的一个线程（firstWaiter）、signalAll： 循环唤醒condition等待队列里的所有线程
                        System.out.println("condition  signalend ");
                    }
                }finally {
                    if(lock.isLocked()){
                        lock.unlock();
                    }
                }
            }
        });


        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();


    }

}
