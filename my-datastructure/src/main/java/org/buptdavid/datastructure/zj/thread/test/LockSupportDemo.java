package org.buptdavid.datastructure.zj.thread.test;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程阻塞工具
 *
 * LockSupport 底层是调用 UNSAFE类的native方法，只有一个许可证，当遇到park(),回去校验是否有许可证（许可证最大只有一个），有许可证就放行，并且消耗许可证
 * unpark();为线程产生一个许可证（许可证最大只有一个）
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
               System.out.println("in ："+super.getName()+"进入阻塞...");
               LockSupport.park();//park（阻塞线程）和unpark（启动唤醒线程）
               System.out.println("in ："+super.getName()+"唤醒线程...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
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
