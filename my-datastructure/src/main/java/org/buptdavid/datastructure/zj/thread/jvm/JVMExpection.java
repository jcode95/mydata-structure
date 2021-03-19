package org.buptdavid.datastructure.zj.thread.jvm;

import sun.misc.VM;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author jiezhou
 * @CalssName: GCExpection
 * @Package org.buptdavid.datastructure.zj.thread.jvm
 * @Description: jvm异常
 * @date 2021/2/24/14:23
 */
public class JVMExpection {

    public static void main(String[] args) {

        /**
         * Java.lang.StackOverflowError
         *Java.lang.OutOfMemoryError:Java heap space
         * Java.lang.OutOfMemeoryError:GC overhead limit exceeded
         * Java.lang.OutOfMemeoryError:Direct buffer memory
         * Java.lang.OutOfMemeoryError:unable to create new native thread
         * Java.lang.OutOfMemeoryError:Metaspace
         */

        JVMExpection test = new JVMExpection();
//        test.GC_overhead_limit_exceeded();
//        test.Direct_buffer_memory();
        test.unable_to_create_new_native_thread();

    }

    /**
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     *
     * linux 系统下允许创建的线程数为1024个，超过这个数就会报Java.lang.OutOfMemeoryError:unable to create new native thread 异常
     */
    private void unable_to_create_new_native_thread() {
        for (int j = 0; ; j++) {
            System.out.println("j = " + j);
            MyThread thread = new MyThread();
            Thread thread1 = new Thread(thread);
            thread1.start();
        }

    }

    class MyThread extends Thread {
        CountDownLatch cdl = new CountDownLatch(1);

        public MyThread() {
            this.setDaemon(true);
        }
        @Override
        public void run() {
            try {
                cdl.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public void GC_overhead_limit_exceeded() {
        int i = 0;
        ArrayList<Object> list = new ArrayList<>();
        while (true) {
            Random random = new Random();
            int anInt = random.nextInt();
            i++;
            String s = new String(i + "") + anInt + "".intern();
            list.add(s);
        }


        /*
        * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
	at org.buptdavid.datastructure.zj.thread.jvm.JVMExpection.GC_overhead_limit_exceeded(JVMExpection.java:39)
	at org.buptdavid.datastructure.zj.thread.jvm.JVMExpection.main(JVMExpection.java:27)
        * */
    }

    /**
     * 直接内存不足
     * -Xms5m -Xmx5m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
     */
    public void Direct_buffer_memory() {
        int i = 0;
        ArrayList<Object> list = new ArrayList<>();
        System.out.println("VM.maxDirectMemory()/(double)(1024*1024)+\"M\" = " + VM.maxDirectMemory() / (double) (1024 * 1024) + "M");
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(7 * 1024 * 1024);//在直接内存里面创建一个7m大小（使用java nio）

        /*
        [Full GC (System.gc()) [PSYoungGen: 504K->0K(1536K)] [ParOldGen: 454K->907K(4096K)] 958K->907K(5632K), [Metaspace: 3187K->3187K(1056768K)], 0.0159996 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
        Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
        * */
    }


}
