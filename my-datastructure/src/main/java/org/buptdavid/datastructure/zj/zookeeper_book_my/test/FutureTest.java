package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

import java.util.concurrent.*;

/**
 * @author jiezhou
 * @CalssName: FutureTest
 * @Package book.test
 * @Description: Future测试
 * @date 2020/6/16/14:17
 */
public class FutureTest {

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new Callable1());
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(task);
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "333";
            }
        });

//        Thread thread = new Thread(task);
//        thread.start();
        System.out.println("请求完毕！");

        try {
            Thread.sleep(3000);//模拟其他操作耗时
            //获取上面提交的结果
            try {
                System.out.println("task 的数据结果："+task.get());
                System.out.println("future 的数据结果："+future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(!executorService.isShutdown()){//判断executorService是否已经关闭，没有关闭则关闭
                executorService.shutdown();
            }
        }
    }

    static class Callable1 implements Callable<String> {

        @Override
        public String call() throws Exception {

            return "aa";
        }
    }
}
