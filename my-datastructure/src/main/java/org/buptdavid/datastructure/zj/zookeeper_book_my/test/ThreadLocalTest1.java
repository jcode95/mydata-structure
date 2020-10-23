package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jiezhou
 * @CalssName: ThreadLocalTest1
 * @Package book.test
 * @Description: ThreadLocal测试
 * @date 2020/6/15/17:25
 */
public class ThreadLocalTest1 {
//    private static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        private static ThreadLocal<SimpleDateFormat> threadLocal=new ThreadLocal<SimpleDateFormat>();
    static class Thread1 implements Runnable{
        int i=0;
        Thread1(int i){
            this.i=i;
        }
        @Override
        public void run() {
            try {
//                Date date = sdf.parse("2020-6-15 17:30:" + i % 6);
//                System.out.println(i+":"+date);
                if(threadLocal.get()==null){
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") );
                }
                Date date = threadLocal.get().parse("2020-6-15 17:30:" + i % 6);
                System.out.println(i+":"+date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Thread1(i));
        }

    }
}
