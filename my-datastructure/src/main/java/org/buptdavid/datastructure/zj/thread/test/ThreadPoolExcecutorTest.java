package org.buptdavid.datastructure.zj.thread.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcecutorTest {

    final static int corePoolSize=10;
    final static int maximumPoolSize=10;
    final static long keepAliveTime=1000;//1s
    final static TimeUnit unit=TimeUnit.SECONDS;


    /**
     public ThreadPoolExecutor(int corePoolSize,
     int maximumPoolSize,
     long keepAliveTime,
     TimeUnit unit,
     BlockingQueue<Runnable> workQueue) {
     */
    static ThreadPoolExecutor executor=new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,new LinkedBlockingQueue());

    public static void main(String[] args) {
        executor.execute(new Action());
        int activeCount = executor.getActiveCount();
        boolean shutdown = executor.isShutdown();
//        executor.shutdown();
        System.out.println("22222222");
    }



    static class Action implements Runnable{

        @Override
        public void run() {
            System.out.println("1111111");
        }
    }


}
