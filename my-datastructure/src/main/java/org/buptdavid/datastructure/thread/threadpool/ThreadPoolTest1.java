package org.buptdavid.datastructure.thread.threadpool;

import java.util.concurrent.*;

public class ThreadPoolTest1 {

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        Future<String> submit = ses.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "111";
            }
        });
        try {
            String s = submit.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ses!=null){
                ses.shutdown();
            }
        }
    }
}
