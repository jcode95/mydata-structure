package org.buptdavid.datastructure.zj.zookeeper_book_my.test;


import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 */
public class ThreadFactoryDemo {
    public static void main(String[] args) throws InterruptedException {
        MyTask myTask=new MyTask();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MICROSECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                System.out.println("create : " + thread);
                return thread;
            }
        });

        for (int i = 0; i < 5; i++) {
            executor.submit(myTask);
        }
        Thread.sleep(2000);
    }



    static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println("I am  MyTask .....");
        }
    }
}
