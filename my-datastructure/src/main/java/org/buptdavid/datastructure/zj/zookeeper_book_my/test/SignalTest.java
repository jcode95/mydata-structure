package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

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
                    condition.await();//等待
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
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("condition  signaling  ....");
                    condition.signal();//相当于notify
                    System.out.println("condition  signalend ");
                }finally {
                    if(lock.isLocked()){
                        lock.unlock();
                    }
                }
            }
        });


        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();


    }

}
