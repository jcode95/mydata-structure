package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jiezhou
 * @CalssName: ThreadLocalRandomTest1
 * @Package book.test
 * @Description:
 * @date 2020/6/29/12:24
 */
public class ThreadLocalRandomTest1 {
     static ThreadLocalRandom random = ThreadLocalRandom.current();
    public static void main(String[] args) {


        float aFloat = random.nextFloat();
        for (int i = 0; i < 1999; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                }
            };
            thread.start();
        }



    }
}
