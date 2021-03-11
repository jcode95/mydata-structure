package org.buptdavid.datastructure.zj.thread.test;

/**
 * volatile 禁止指令重排序，可见性，不保证原子性，保证可见性的原因（在写操作后加入一条store内存屏障，将工作内存中的变量的值刷回主内存，
 * 在读操作前加入一条load内存屏障，读取变量在主内存中的值）也就是在内存屏障的前后禁止指令重排序
 *
 * 每个处理器通过嗅探机制在总线上传播的数据来检查自己缓存的值是不是过期了，当处理器发现自己缓存行对应的内存地址被修改，就会将当前处理器的缓存行设置成无效状态，当处理器要对这个数据进行修改操作的时候，会强制重新从系统内存里把数据读到处理器缓存里。
 所以，如果一个变量被volatile所修饰的话，在每次数据变化之后，其值都会被强制刷入主存。而其他处理器的缓存由于遵守了缓存一致性协议，也会把这个变量的值从主存加载到自己的缓存中。这就保证了一个volatile在并发编程中，其值在多个缓存中是可见的。
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
