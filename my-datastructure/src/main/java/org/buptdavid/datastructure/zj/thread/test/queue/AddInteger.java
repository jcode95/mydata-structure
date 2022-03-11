package org.buptdavid.datastructure.zj.thread.test.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiezhou
 * @CalssName: AddInteger
 * @Package org.buptdavid.datastructure.zj.thread.test.queue
 * @Description:
 * @date 2022/3/11/13:35
 */
public class AddInteger {


    static class Resource {
        private int number = 0;
        final private int numbers = 1000;
        private Lock lock = new ReentrantLock();
        private Condition tc = lock.newCondition();


        private Condition tc1 = lock.newCondition();
        private Condition tc2 = lock.newCondition();
        private Condition tc3 = lock.newCondition();


        public void addNumber() throws InterruptedException {
            try {
                lock.lock();
                while (number!=0){
                    tc.await();
                }
                number++;
                System.out.println(Thread.currentThread().getName()+"number = " + number);
                tc.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void jieNumber() throws InterruptedException {
            try {
                lock.lock();
                while (number==0){
                    tc.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName()+"number = " + number);
                tc.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }




        public void print1() {
            try {
                lock.lock();
                for (int i = 1; i < numbers; i++) {
                    if (i % 3 == 1) {
                        System.out.println(Thread.currentThread().getName() + "=" + i);
                    }
                    tc2.signal();
                    tc1.await();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void print2() {
            try {
                lock.lock();
                for (int i = 1; i < numbers; i++) {
                    if (i % 3 == 2) {
                        System.out.println(Thread.currentThread().getName() + "=" + i);
                    }
                    tc3.signal();
                    tc2.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void print3() {
            try {
                lock.lock();
                for (int i = 1; i < numbers; i++) {
                    if (i % 3 == 0) {
                        System.out.println(Thread.currentThread().getName() + "=" + i);
                    }
                    tc1.signal();
                    tc3.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource();

        System.out.println("一个初始值为0 的变量，一个线程+一个线程-,来5 轮");
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        resource.addNumber();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.setName("addt");


        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        resource.jieNumber();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.setName("jiet");

        thread.start();
        thread1.start();



        //三个线程交替打印 numbers =1000
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("三个线程交替打印 numbers =1000");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                resource.print1();
            }
        };
        t1.setName("t1");
        Thread t2 = new Thread() {
            @Override
            public void run() {
                resource.print2();
            }
        };
        t2.setName("t2");
        Thread t3 = new Thread() {
            @Override
            public void run() {
                resource.print3();
            }
        };
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();


    }

}
