package org.buptdavid.datastructure.zj.thread.test;

/**
 * @author jiezhou
 * @CalssName: InterruptExpetionTest
 * @Package org.buptdavid.datastructure.zj
 * @Description: 线程中断异常测试
 * @date 2021/2/19/19:40
 */
public class InterruptExpetionTest {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        thread.interrupt();//为thread线程设置中断标识，上面因为线程设置阻塞了，不允许再设置中断标识，故会报错
        /**
         *
         * java.lang.InterruptedException: sleep interrupted
         at java.lang.Thread.sleep(Native Method)
         at org.buptdavid.datastructure.zj.thread.test.InterruptExpetionTest$1.run(InterruptExpetionTest.java:17)
         */


    }
}
