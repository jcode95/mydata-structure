package org.buptdavid.datastructure.zj.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiezhou
 * @CalssName: ConditionTest2
 * @Package org.buptdavid.datastructure.zj.thread
 * @Description:重入锁的Condition测试2
 * @date 2021/2/27/12:08
 */
public class ConditionTest2 {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        Thread A = new Thread() {
            @Override
            public void run() {
                shareResource.print();
            }
        };
        A.setName("A");
        A.start();
        Thread B = new Thread() {
            @Override
            public void run() {
                shareResource.print();
            }
        };
        B.setName("B");
        B.start();
        Thread C = new Thread() {
            @Override
            public void run() {
                shareResource.print();
            }
        };
        C.setName("C");
        C.start();


    }

    static class ShareResource {
        private ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        private int number = 0;
        int cs = 0;

        public void print() {
            try {
                lock.lock();//tryLock()方法申请锁，如果锁不可用则线程不会阻塞，转而可以去做其他工作
                String threadName = Thread.currentThread().getName();
                switch (threadName) {
                    case "A":
                        cs = 0;
                        break;
                    case "B":
                        cs = 1;
                        break;
                    case "C":
                        cs = 2;
                        break;
                }
                while (number != cs) {
                    try {
                        switch (threadName) {
                            case "A":
                                c1.await();
                                break;
                            case "B":
                                c2.await();
                                break;
                            case "C":
                                c3.await();
                                break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                number++;
                int end = 0;
                switch (threadName) {
                    case "A":
                        end = 5;
                        break;
                    case "B":
                        end = 10;
                        break;
                    case "C":
                        end = 15;
                        break;
                }
                for (int i = 0; i < end; i++) {
                    System.out.println("thread name：" + threadName + "  number :" + i);
                }
                switch (threadName) {
                    case "A":
                        c2.signal();
                        break;
                    case "B":
                        c3.signal();
                        break;
                    case "C":
                        c1.signal();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }
}
