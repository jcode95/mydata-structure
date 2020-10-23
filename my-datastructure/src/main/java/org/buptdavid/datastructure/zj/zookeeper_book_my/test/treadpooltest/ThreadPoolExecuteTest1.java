package org.buptdavid.datastructure.zj.zookeeper_book_my.test.treadpooltest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiezhou
 * @CalssName: ThreadPoolExecuteTest1
 * @Package book.test.treadpooltest
 * @Description: 线程池测试
 * @date 2020/6/13/10:27
 */
public class ThreadPoolExecuteTest1 {

    /*
    * int corePoolSize,
      int maximumPoolSize,
      long keepAliveTime,
      TimeUnit unit,
      BlockingQueue<Runnable> workQueue,
      ThreadFactory threadFactory,
      RejectedExecutionHandler handler
    *
    * */

    static ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(3, 3, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("执行了拒绝策略，"+"任务："+r.toString());
        }
    });
    static AtomicInteger a=new AtomicInteger(0);
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    int i1 = a.incrementAndGet();
                    System.out.println("我是第"+i1+"号");
                }
            });
        }

        poolExecutor.shutdown();


    }




}
