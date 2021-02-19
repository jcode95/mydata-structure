package org.buptdavid.datastructure.zj.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiezhou
 * @CalssName: ReentrantLockTest
 * @Package org.buptdavid.datastructure.zj.thread
 * @Description:
 * @date 2021/2/19/14:32
 */
public class ReentrantLockTest {

    /**
     * // 创建一个 ReentrantLock ，默认是“非公平锁”。
     ReentrantLock()
     // 创建策略是fair的 ReentrantLock。fair为true表示是公平锁，fair为false表示是非公平锁。
     ReentrantLock(boolean fair)
     // 查询当前线程保持此锁的次数。
     int getHoldCount()
     // 返回目前拥有此锁的线程，如果此锁不被任何线程拥有，则返回 null。
     protected Thread getOwner()
     // 返回一个 collection，它包含可能正等待获取此锁的线程。
     protected Collection<Thread> getQueuedThreads()
     // 返回正等待获取此锁的线程估计数。
     int getQueueLength()
     // 返回一个 collection，它包含可能正在等待与此锁相关给定条件的那些线程。
     protected Collection<Thread> getWaitingThreads(Condition condition)
     // 返回等待与此锁相关的给定条件的线程估计数。
     int getWaitQueueLength(Condition condition)
     // 查询给定线程是否正在等待获取此锁。
     boolean hasQueuedThread(Thread thread)
     // 查询是否有些线程正在等待获取此锁。
     boolean hasQueuedThreads()
     // 查询是否有些线程正在等待与此锁有关的给定条件。
     boolean hasWaiters(Condition condition)
     // 如果是“公平锁”返回true，否则返回false。
     boolean isFair()
     // 查询当前线程是否保持此锁。
     boolean isHeldByCurrentThread()
     // 查询此锁是否由任意线程保持。
     boolean isLocked()
     // 获取锁。
     void lock()
     // 如果当前线程未被中断，则获取锁。
     void lockInterruptibly()
     // 返回用来与此 Lock 实例一起使用的 Condition 实例。
     Condition newCondition()
     // 仅在调用时锁未被另一个线程保持的情况下，才获取该锁。
     boolean tryLock()
     // 如果锁在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁。
     boolean tryLock(long timeout, TimeUnit unit)
     // 试图释放此锁。
     void unlock()
     * @param args
     */
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("await start ...");
                    condition.await();//await：释放当前锁持有的锁，生成线程等待node，存储到condition中的单链表中，等被唤醒的时候，在加入到锁的等待队列
                    System.out.println("await end ...");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(lock.isHeldByCurrentThread()){
                        lock.unlock();
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("signal start ...");
                    condition.signal();
                    System.out.println("signal end ...");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(lock.isHeldByCurrentThread()){
                        lock.unlock();
                    }
                }
            }
        };
        thread1.start();
        try {
            Thread.sleep(5000);//不会释放对象锁资源以及监控的状态，当指定的时间到了之后又会自动恢复运行状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
