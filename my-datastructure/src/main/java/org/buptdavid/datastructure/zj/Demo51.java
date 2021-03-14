package org.buptdavid.datastructure.zj;

/**
 * @author jiezhou
 * @CalssName: Demo51
 * @Package org.buptdavid.datastructure.zj
 * @Description:
 * @date 2021/3/14/3:34
 */
public class Demo51 {

    public static void main(String[] args) {
        Object o=new Object();

        Thread a = new Thread() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        Thread.sleep(6000);
                        o.wait();//一直阻塞，不会执行下面的代码，除非其他线程调用到notify/notifyAll,才会执行下面的方法
                        o.notifyAll();//所以在这里执行这个方法没有用
                        System.out.println("cccccccccc");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread b = new Thread() {
            @Override
            public void run() {
                synchronized (o) {
                    System.out.println("==============");
                    try {
                        o.notifyAll();
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        a.setName("tA");
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.setName("tB");
        b.start();

    }


}
