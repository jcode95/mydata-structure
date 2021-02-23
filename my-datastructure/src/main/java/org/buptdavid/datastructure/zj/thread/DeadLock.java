package org.buptdavid.datastructure.zj.thread;

/**
 * @author jiezhou
 * @CalssName: DeadLock
 * @Package org.buptdavid.datastructure.zj.thread
 * @Description: 死锁演示
 * @date 2021/2/28/11:33
 */
public class DeadLock {

    static String lockA = "lockA";
    static String lockB = "lockB";
//    static Object lockB = new Object();


    public static void main(String[] args) {
        Thread ta = new Thread() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName() + "获得锁 " + lockA + " 想获取锁" + lockB);
                    try {
                        Thread.sleep(3000);//为的是让tb线程获取锁lockB
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB) {
                        System.out.println(Thread.currentThread().getName() + "获得锁 " + lockB + " 想获取锁" + lockA);
                    }
                }

            }
        };
        Thread tb = new Thread() {
            @Override
            public void run() {
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "获得锁 " + lockB + " 想获取锁" + lockA);
                    synchronized (lockA) {
                        System.out.println(Thread.currentThread().getName() + "获得锁 " + lockA + " 想获取锁" + lockB);
                    }
                }

            }
        };
        ta.setName("ta");
        ta.start();
        tb.setName("tb");
        tb.start();


        /**
         *
         * 查询死锁原因
         * 1、jps -l   命令
         *=================================\
         * F:\data_structure_java\datastructure-master\my-datastructure>jps  -l
         9744 org.jetbrains.jps.cmdline.Launcher
         10852 org.buptdavid.datastructure.zj.thread.DeadLock
         5620
         824 sun.tools.jps.Jps
         12140 org.jetbrains.jps.cmdline.Launcher


         *2、jstack 进程号
         *
         *Java stack information for the threads listed above:
         ===================================================
         "tb":
         at org.buptdavid.datastructure.zj.thread.DeadLock$2.run(DeadLock.java:41)
         - waiting to lock <0x00000000d5804500> (a java.lang.String)
         - locked <0x00000000d5804538> (a java.lang.String)
         "ta":
         at org.buptdavid.datastructure.zj.thread.DeadLock$1.run(DeadLock.java:29)
         - waiting to lock <0x00000000d5804538> (a java.lang.String)
         - locked <0x00000000d5804500> (a java.lang.String)

         Found 1 deadlock.
         *
         * */
    }
}
