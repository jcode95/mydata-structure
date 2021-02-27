package org.buptdavid.datastructure.zj.thread.test.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @author jiezhou
 * @CalssName: BlockingQueueTest
 * @Package org.buptdavid.datastructure.zj.thread.test.queue
 * @Description: 阻塞队列测试（有界/无界）
 * @date 2021/2/25/21:15
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        /**
         * add() //如果放入的元素个数大于临界值，抛出异常 java.lang.IllegalStateException: Queue full
         * put() //如果放入的元素个数大于临界值，后面添加的阻塞等着，有空位置的时候就插入
         * offer() //如果放入的元素成功，返回true，否则返回false
         */
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);//基于数组的有界阻塞队列，
        for (int i = 0; i < 3; i++) {
            arrayBlockingQueue.add(i);
        }
        //打印
        arrayBlockingQueue.forEach(e -> System.out.println("e = " + e));


        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(3);//基于链表的有界阻塞队列，如果不指定临界值，默认是 Integer.MAX_VALUE,如果元素个数超过临界值，抛出异常java.lang.IllegalStateException: Queue full
        for (int i = 0; i < 3; i++) {
            linkedBlockingQueue.add(i);
        }
        //打印
        linkedBlockingQueue.forEach(e -> System.out.println("e = " + e));

        LinkedTransferQueue<Integer> linkedTransferQueue = new LinkedTransferQueue<Integer>();//基于链表的无界阻塞队列
        for (int i = 0; i < 4; i++) {
            linkedTransferQueue.add(i);
        }
        linkedTransferQueue.forEach(e -> System.out.println("e = " + e));
    }


}

