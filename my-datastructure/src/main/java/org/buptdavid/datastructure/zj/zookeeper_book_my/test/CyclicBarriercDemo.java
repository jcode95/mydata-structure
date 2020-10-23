package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarriercDemo {
    static  CyclicBarrier cyclicBarrier=new CyclicBarrier(5,new A());

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < 5; i++) {
            new Thread(new B(i)).start();
        }
//        System.out.println("总汇报工作");
    }

    public static class A implements Runnable{

        @Override
        public void run() {
            System.out.println("到达了门阀");
        }
    }
    public static class B implements Runnable{
        int value;

        public B(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            try {
//                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+":等待其他线程就绪。。。");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+":开始工作"+value);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+":正在工作中..."+value);
                Thread.sleep(1000);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+":执行完毕"+value);
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }





}
