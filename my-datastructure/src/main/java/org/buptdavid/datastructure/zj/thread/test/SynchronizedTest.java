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

    /*
    * 每个对象有一个监视器锁（monitor）。当monitor被占用时就会处于锁定状态，线程执行monitorenter指令时尝试获取monitor的所有权，过程如下：

        1、如果monitor的进入数为0，则该线程进入monitor，然后将进入数设置为1，该线程即为monitor的所有者。

        2、如果线程已经占有该monitor，只是重新进入，则进入monitor的进入数加1.

        3.如果其他线程已经占用了monitor，则该线程进入阻塞状态，直到monitor的进入数为0，再重新尝试获取monitor的所有权。


        ，Synchronized的语义底层是通过一个monitor的对象来完成，其实wait/notify等方法也依赖于monitor对象，这就是为什么只有在同步的块或者方法中才能调用wait/notify等方法，否则会抛出java.lang.IllegalMonitorStateException的异常的原因。
    *
    * */
}
