package org.buptdavid.datastructure.zj.thread.test;

/**
 * @author jiezhou
 * @CalssName: SmipWaitNotify
 * @Package book.test
 * @Description:
 * @date 2020/11/17/15:02
 */
public class SmipWaitOrNotify {
    final static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis()+" T1 start!");
                try {
                    System.out.println(System.currentTimeMillis()+" T1 wait for Object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+" T1 end!");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis()+" T2 start!");
                object.notifyAll();
                System.out.println(System.currentTimeMillis()+" T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}
