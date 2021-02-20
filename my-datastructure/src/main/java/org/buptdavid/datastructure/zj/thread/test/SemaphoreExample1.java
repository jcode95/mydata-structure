package org.buptdavid.datastructure.zj.thread.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 
 * @author Snailclimb
 * @date 2018年9月30日
 * @Description: 需要一次性拿一个许可的情况
 */
public class SemaphoreExample1 {
  // 请求的数量
  private static final int threadCount = 550;

  private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  public static String getFormatTimeStr() {
    return sf.format(new Date());
  }
  public static void main(String[] args) throws InterruptedException {
    // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
    ExecutorService threadPool = Executors.newFixedThreadPool(300);
    // 一次只能允许执行的线程数量。
    final Semaphore semaphore = new Semaphore(5);

    for (int i = 0; i < threadCount; i++) {
      final int threadnum = i;
//      threadPool.execute(() -> {// Lambda 表达式的运用
//        try {
//          semaphore.acquire();// 获取一个许可，所以可运行线程数量为20/1=20
//          test(threadnum);
//          semaphore.release();// 释放一个许可
//        } catch (InterruptedException e) {
//          // TODO Auto-generated catch block
//          e.printStackTrace();
//        }
//
//      });
//    }
      threadPool.execute(new Runnable() {
        @Override
        public void run() {
          try {
            semaphore.acquire();// 获取一个许可
//            test(threadnum);
            System.out.println(Thread.currentThread().getName() + ":doSomething start-" + getFormatTimeStr());
            Thread.sleep(5000);
            semaphore.release();// 释放一个许可
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      });
    }
    threadPool.shutdown();
    System.out.println("finish");


  }

  public static void test(int threadnum) throws InterruptedException {
    Thread.sleep(1000);// 模拟请求的耗时操作
    System.out.println("threadnum:" + threadnum);
    Thread.sleep(1000);// 模拟请求的耗时操作
  }
}