package org.buptdavid.datastructure.zj.thread.test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IsInterruptedDemo1 {
    public static class DaemonT extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("i="+(i+1));
                if(this.isInterrupted()){
                    System.out.println("通过this.isInterrupted()检测到中断");
                    System.out.println("线程名称="+Thread.currentThread().getName()+"第0个isInterrupted() "+Thread.currentThread().isInterrupted());
//                    System.out.println("第一个interrupted()"+this.interrupted());
//                    System.out.println("第二个interrupted()"+this.interrupted());
                    System.out.println("线程名称="+Thread.currentThread().getName()+"第1个isInterrupted() "+this.isInterrupted());
                    break;
                }
            }
            System.out.println("因为检测到中断，所以跳出循环，线程到这里结束，因为后面没有内容了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonT daemonT = new DaemonT();
//        daemonT.setDaemon(true);
        daemonT.start();
        Thread.currentThread().interrupt();//当前线程设置中断标识
        daemonT.interrupt();//直接为调用的线程对象设置中断标识
        System.out.println("线程名称="+Thread.currentThread().getName()+"是否被中断"+Thread.currentThread().isInterrupted());
        System.out.println("第一次调用："+daemonT.interrupted());//虽然是daemonT调用的，但是检测的是当前线程，（interrupted() 方法就是检测当前线程   return currentThread().isInterrupted(true);）
        System.out.println("在调用daemonT.interrupted()之后的状态"+"线程名称="+Thread.currentThread().getName()+"是否被中断"+Thread.currentThread().isInterrupted());
        System.out.println(" daemonT.interrupt()  第二次调用："+daemonT.isInterrupted());
        System.out.println(" daemonT.isAlive() ："+daemonT.isAlive());
        Thread.sleep(2000);
        /*System.out.println("==============================================");
        boolean interrupted1 = Thread.currentThread().isInterrupted();//获取当前线程（无论是谁调用都是获取获取的当前线程）的中断状态
        System.out.println(interrupted1);
        boolean interrupted = Thread.interrupted();//获取当前线程（无论是谁调用都是获取获取的当前线程）的中断状态,相比于isInterrupted()，interrupted()会清除中断标识
        System.out.println(interrupted);

        Thread.currentThread().interrupt();//为调用此方法的线程设置中断标识
        boolean interrupted3 = Thread.currentThread().isInterrupted();//获取当前线程（无论是谁调用都是获取获取的当前线程）的中断状态
        System.out.println(interrupted3);

        boolean interrupted4 = Thread.interrupted();//获取当前线程（无论是谁调用都是获取获取的当前线程）的中断状态,相比于isInterrupted()，interrupted()会清除中断标识
        System.out.println(interrupted4);
        boolean interrupted5 = Thread.currentThread().isInterrupted();//获取当前线程（无论是谁调用都是获取获取的当前线程）的中断状态
        System.out.println(interrupted5);*/
        try {
            byte[] bytes = input2byte(new FileInputStream("F:\\ideawork\\zookeeper_paxos\\zookeeper_book\\src\\main\\java\\book\\test\\velocity\\VelocityGenerate.java"));
            System.out.println(" bytes ："+bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 总结：
     * interrupt(),直接为调用的线程对象设置中断标识
     * interrupted(),不管是哪个对象调用，都是返回当前线程的中断标识，如果发现当前线程被中断，会清除中断标识
     * isInterrupted(),返回对象调用者的中断标识
     */















    private static final byte[] input2byte(InputStream inStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }
}
