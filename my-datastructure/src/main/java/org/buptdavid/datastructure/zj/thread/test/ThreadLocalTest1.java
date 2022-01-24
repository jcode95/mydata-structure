package org.buptdavid.datastructure.zj.thread.test;

import java.lang.ref.WeakReference;
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
        /*
        * ThreadLocal 会导致内存泄露，面试常问，可以百度搜索相关看看
        *   大致：
        *   ThreadLocal 里面有个ThreadLocalMap,
        *       源码：
            *   static class ThreadLocalMap {
                    static class Entry extends WeakReference<ThreadLocal<?>> {
                        Object value;

                        Entry(ThreadLocal<?> k, Object v) {
                            super(k);
                            value = v;
                        }
                    }
        *       由于entry 的key是弱引用，这个Map的Entry继承了WeakReference,设值完成后map中是(WeakReference,value)这样的数据结构,当java中的弱引用在内存不足的时候会被回收掉，回收之后变成(null,value)的形式，key被收回掉了，因此entry就存在key为null的情况，无法通过一个Key为null去访问到该entry的value
        *       如果线程执行完之后销毁，value也会被回收,这样也没问题。但如果是在线程池中，线程执行完后不被回收，而是返回线程池中，Thread有个强引用指向ThreadLocalMap,ThreadLocalMap有强引用指向Entry,导致value无法被回收，一直存在内存中。
                通过分析源码，java也做了一定优化，即使出现了上诉的(null,value)情况，再调用一次ThreadLocal.set()也可以将这个废弃的替代调用
        * * */

    }
}
