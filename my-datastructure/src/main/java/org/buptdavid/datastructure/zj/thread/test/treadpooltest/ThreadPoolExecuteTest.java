package org.buptdavid.datastructure.zj.thread.test.treadpooltest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecuteTest {
    static final ThreadPoolExecutor executor= new ThreadPoolExecutor(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(6), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            return thread;
        }
    },new AbortPolicyTest());
    ;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("executor.getPoolSize()"+executor.getPoolSize());
        /**
         (int corePoolSize,
         int maximumPoolSize,
         long keepAliveTime,
         TimeUnit unit,
         BlockingQueue<Runnable> workQueue,
         ThreadFactory threadFactory
         */
        AtomicInteger  count=new AtomicInteger(0);
        for (int i = 0; i <50 ; i++) {
            if(i%2==0){
                Future future = executor.submit(new TaskTest1());
                count.incrementAndGet();
//                Thread.sleep(50000000);
                try {
                    Object o = future.get();
                    System.out.println(o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                TaskTest2 command = new TaskTest2();
                executor.execute(command);
                count.incrementAndGet();
            }

        }
//        Thread.sleep(5000);
        boolean interrupted = Thread.interrupted();
        System.out.println(interrupted);
        int ss = executor.getActiveCount();
        System.out.println("count"+count);
        int corePoolSize = executor.getCorePoolSize();
        System.out.println("corePoolSize:"+corePoolSize);
//        future.
        int poolSize = executor.getPoolSize();
        System.out.println("poolSize:"+poolSize);
    }

    static class TaskTest1 implements Callable{

        @Override
        public Object call() throws Exception {
//            Thread.sleep(5000);
            return "wo shi 001";
        }
    }
    static class TaskTest2 implements Runnable{

        @Override
        public void run() {
            try {
//                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("TaskTest2...");
        }
    }

    static  class AbortPolicyTest implements RejectedExecutionHandler {

        /*@Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            throw new RejectedExecutionException("Task " + r.toString() +
                    " rejected from " +
                    e.toString());
        }*/
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            System.out.println("e.......");

        }
    }


}
