package org.buptdavid.datastructure.zj.thread.test.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author jiezhou
 * @CalssName: SynchronousQueueTest
 * @Package org.buptdavid.datastructure.zj.thread.test.queue
 * @Description:只存一个元素，一个元素的入队必定有一个元素的出队
 * @date 2021/2/27/10:37
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();


        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true){
                        synchronousQueue.put(1);//里面有个for(;;),会等待出队操作，否则会阻塞在这
                        System.out.println("put = " + 1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true){
                        Thread.sleep(2000);
                        //synchronousQueue.take() 里面有个for(;;),等待一个入队操作，否则会阻塞在这
                        System.out.println(" synchronousQueue.take() = " +  synchronousQueue.take());
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.setName("t2");
        t2.start();

    }
}
