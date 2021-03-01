package org.buptdavid.datastructure.zj.thread.test;

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
               LockSupport.park();//park（阻塞线程）和unpark（启动唤醒线程）
           }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);//park（阻塞线程）和unpark（启动唤醒线程）
        LockSupport.unpark(t2);//park（阻塞线程）和unpark（启动唤醒线程）
        //下面这两个join是为了让测试线程先执行完，在执行主线程
        t1.join();
        t2.join();

    }

    /*
    * Java锁消除和锁粗化
    *
    * */
}
