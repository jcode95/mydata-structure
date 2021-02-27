package org.buptdavid.datastructure.zj.thread.test;

import java.util.concurrent.*;

/**
 * 在使用有界队列 ArrayBlockingQueue来实现任务队列时：
 * 当当前线程数小于corePoolSize 时，就会创建新线程来执行任务，
 * 如果当前线程数大于corePoolSize并且小于maximumPoolSize时，就会将任务加入到有界队列里面
 * 若队列已经满了，并且当前线程数小于maximumPoolSize时，就会创建新的进程来执行任务。
 * 当当前线程数大于maximumPoolSize，就会执行拒绝策略
 * 可以使用LinkedBlockingQueue队列来实现(默认是 Integer.MAX_VALUE,可设置边界)。
 */
public class ThreadPoolExcecutorTest {

    final static int corePoolSize = 10;
    final static int maximumPoolSize = 10;
    final static long keepAliveTime = 1000;//1s
    final static TimeUnit unit = TimeUnit.SECONDS;


    /**
     * public ThreadPoolExecutor(int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue) {
     */
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue());

    public static void main(String[] args) {
        executor.execute(new Action());
        int activeCount = executor.getActiveCount();
        boolean shutdown = executor.isShutdown();
//        executor.shutdown();
        System.out.println("22222222");
    }


    static class Action implements Runnable {

        @Override
        public void run() {
            System.out.println("1111111");
        }
    }

    /**
     * 线程池的工具类，类似于Arrays,Collections
     */
    static class ExecutorsTest {
        public static void main(String[] args) {

            /**
             *  public ThreadPoolExecutor(int corePoolSize,
             int maximumPoolSize,
             long keepAliveTime,
             TimeUnit unit,
             BlockingQueue<Runnable> workQueue,
             ThreadFactory threadFactory,
             RejectedExecutionHandler handler)
             */
            ExecutorService executorService = Executors.newCachedThreadPool();
        }


    }


}
