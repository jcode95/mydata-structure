package org.buptdavid.datastructure.zj.thread.test;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {


    public static void main(String[] args) {
        ConcurrentLinkedQueue queue=new ConcurrentLinkedQueue();
        queue.offer("t1");
        queue.offer("t2");
        queue.offer("t3");
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()){
            Object result = iterator.next();
            System.out.println(result);
        }

        Object peek = queue.peek();
        System.out.println("peek:"+peek);

        boolean t3 = queue.contains("t3");
        System.out.println("t3:"+t3);

        Iterator iterator1 = queue.iterator();
        while (iterator1.hasNext()){
            Object result = iterator1.next();
            System.out.println(result);
        }

    }
}
