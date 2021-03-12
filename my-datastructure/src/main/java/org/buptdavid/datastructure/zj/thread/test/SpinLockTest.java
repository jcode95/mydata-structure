package org.buptdavid.datastructure.zj.thread.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author jiezhou
 * @CalssName: SpinLock
 * @Package org.buptdavid.datastructure.zj.thread.test
 * @Description: 自旋锁(CAS+while)
 * @date 2021/2/20/15:16
 */
public class SpinLockTest {

    volatile AtomicReference<Thread> spin = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        /*自旋核心代码*/
        while (!spin.compareAndSet(null, thread)) {
        }
        System.out.println("myLock   thread name :" + thread.getName());
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
         if (spin.compareAndSet(thread, null)){
             System.out.println("myUnLock   thread name :" + thread.getName());
         }
    }

    public static void main(String[] args) {
        SpinLockTest spinLockTest = new SpinLockTest();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                spinLockTest.myLock();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spinLockTest.myUnLock();

            }
        };
        t1.setName("t1");
        t1.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread t2 = new Thread() {
            @Override
            public void run() {
                spinLockTest.myLock();
                spinLockTest.myUnLock();
            }
        };
        t2.setName("t2");
        t2.start();



    }


}
