package org.buptdavid.datastructure.zj.thread.test;

/**
 * @author jiezhou
 * @CalssName: SynchionzedTest
 * @Package org.buptdavid.datastructure.zj.thread.test
 * @Description:
 * @date 2021/3/3/9:55
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (o) {
                        o.wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        t1.start();

    }
}
