package org.buptdavid.datastructure.zj.thread.test;

import java.util.ArrayList;
import java.util.List;

public class JoinDemo extends Thread{
    int i;
    Thread previousThread; //上一个线程
    public JoinDemo(Thread previousThread,int i){
        this.previousThread=previousThread;
        this.i=i;
    }
    @Override
    public void run() {
        try {
//          //调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            //调用join方法，阻塞当前线程，让调用此方法的线程运行完才运行当前线程
            previousThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("num:"+i);
    }
    public static void main(String[] args) {
        Thread previousThread=Thread.currentThread();
        List<Thread> ls=new ArrayList<Thread>();
        for(int i=0;i<10;i++) {
            //第一种
            JoinDemo joinDemo = new JoinDemo(previousThread, i);//第一个参数传的是上一个线程
            joinDemo.start();
            previousThread=joinDemo;

            //第二种
//            JoinDemo joinDemos = new JoinDemo(ls.size()>0?ls.get(i-1):previousThread, i);//第一个参数传的是上一个线程
//            ls.add(joinDemos);
//            ls.add(joinDemos);
//            joinDemos.start();
        }
        System.out.println("开始运行");

        /*
        * join(long) 底层使用 wait(long)来实现，具有释放锁的特点
        *
        * */
    }
}
