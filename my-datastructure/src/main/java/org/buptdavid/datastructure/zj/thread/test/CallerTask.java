package org.buptdavid.datastructure.zj.thread.test;


import java.util.concurrent.*;

/**
 * 有返回值的线程
 */
public class CallerTask implements Callable<String>{


    @Override
    public String call() throws Exception {
        System.out.println("call run ..... ");
        return "hello callable....";
    }


    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        //创建异步任务
//        FutureTask futureTask=new FutureTask<String>(new CallerTask());
        //启动线程
//        new Thread(futureTask).start();
        Future<String> submit = scheduledExecutorService.submit(new CallerTask());

        //获取结果
        try {
//            String o = (String) futureTask.get();
            String o = submit.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            if(submit!=null){
                boolean done = submit.isDone();
                if(done){

                }
            }
        }
    }
}
