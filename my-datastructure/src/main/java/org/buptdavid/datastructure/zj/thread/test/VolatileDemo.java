package org.buptdavid.datastructure.zj.thread.test;

/**
 * volatile 禁止指令重排序，可见性，不保证原子性，保证可见性的原因（在写操作后加入一条store内存屏障，将工作内存中的变量的值刷回主内存，
 * 在读操作前加入一条load内存屏障，读取变量在主内存中的值）也就是在内存屏障的前后禁止指令重排序
 */
public class VolatileDemo {

//    private static AtomicInteger _longVal = new AtomicInteger(0);
    private static volatile long _longVal = 0L;

    private static class LoopVolatile implements Runnable {
        public void run() {
            long val = 0;
            while (val < 10000000L) {
                _longVal++;
//                _longVal.incrementAndGet();
                val++;
            }
        }
    }

    private static class LoopVolatile2 implements Runnable {
        public void run() {
            long val = 0;
            while (val < 10000000L) {
                _longVal++;
//                _longVal.incrementAndGet();
                val++;
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new LoopVolatile());
        t1.start();

        Thread t2 = new Thread(new LoopVolatile2());
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {
        }

        System.out.println("final val is: " + _longVal);


        int s=2>>>32;
        System.out.println(s);
    }
}
