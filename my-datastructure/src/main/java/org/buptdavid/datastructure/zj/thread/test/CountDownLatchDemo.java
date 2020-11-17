package org.buptdavid.datastructure.zj.thread.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchDemo implements Runnable{

    static CountDownLatch countDownLatch=new CountDownLatch(10);//countDownLatch里面的总数
    static AtomicInteger i=new AtomicInteger(0);


    @Override
    public void run() {
        try {
            Thread.sleep(2000);//模拟任务
            i.incrementAndGet();
            System.out.println("执行完子任务");
            countDownLatch.countDown();//countDownLatch里面的数减一
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo countDownLatchDemo =new CountDownLatchDemo();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        for (int j = 0; j < 10; j++) {
            scheduledExecutorService.submit(countDownLatchDemo);
        }

        //等待所有任务都执行完（如果countDownLatch里面的数不等于0就继续等待）
        countDownLatch.await();
        if(i.intValue()==10){//检查是否都执行完（是否与预期的一样）
            //执行最终任务
            Thread.sleep(2000);//模拟最终任务执行
            System.out.println("执行最终任务~~~");
            //关闭(线程池)资源
            scheduledExecutorService.shutdown();
        }

    }
}
