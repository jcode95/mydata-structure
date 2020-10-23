package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {

    static AtomicIntegerArray array=new AtomicIntegerArray(10);


    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                array.getAndIncrement(i%array.length());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads=new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new AddThread());
        }
        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(array);
    }
}
