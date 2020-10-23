package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWritLockDemo {
  private static ReentrantLock reentrantLock= new ReentrantLock();
  private static ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();
  private static Lock readLock=reentrantReadWriteLock.readLock();
  private static Lock writLock= reentrantReadWriteLock.writeLock();

  private int value=10000;

  public Object handeRead(Lock lock) throws InterruptedException {
      try {
          lock.lock();
          Thread.sleep(1000);
          return value;
      }finally {
          lock.unlock();
      }
  }

  public void handWrit(Lock lock,int value) throws InterruptedException {
      try {
          lock.lock();
          Thread.sleep(1000);
          this.value=value;
      }finally {
          lock.unlock();
      }
  }


    public static void main(String[] args) throws InterruptedException {
        final ReadWritLockDemo readWritLockDemo=new ReadWritLockDemo();

        long millis1 = System.currentTimeMillis();
        Runnable runnableRead = new Runnable() {
            @Override
            public void run() {
                try {
                    readWritLockDemo.handeRead(readLock);
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
                    readWritLockDemo.handWrit(writLock,new Random().nextInt());
//                    readWritLockDemo.handWrit(reentrantLock,new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        for (int i = 0; i < 18; i++) {
            new Thread(runnableRead).start();
        }

        for (int i = 18; i < 20; i++) {
            new Thread(runnableWrit).start();
        }

        long millis3 = System.currentTimeMillis();
//        Thread.sleep(6000);
        System.out.println("读readLock：需要的时间："+String.valueOf(millis3-millis1));
        //System.out.println("读reentrantLock：需要的时间："+String.valueOf(millis2-millis1));
    }




}
