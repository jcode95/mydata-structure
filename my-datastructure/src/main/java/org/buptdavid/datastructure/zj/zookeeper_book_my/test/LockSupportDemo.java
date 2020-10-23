package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程阻塞工具
 */
public class LockSupportDemo {

    public static Object u=new Object();
    static ChangObjectThread t1=new ChangObjectThread("t1");
    static ChangObjectThread t2=new ChangObjectThread("t2");

    private static class ChangObjectThread extends Thread{
        public ChangObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
           synchronized (u){
               System.out.println("in ："+super.getName());
               LockSupport.park();
           }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();

    }
}
