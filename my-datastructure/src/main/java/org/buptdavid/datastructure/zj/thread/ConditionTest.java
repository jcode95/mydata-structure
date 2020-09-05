package org.buptdavid.datastructure.zj.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiezhou
 * @CalssName: condition
 * @Package org.buptdavid.datastructure.zj.thread
 * @Description: 重入锁的Condition测试
 * @date 2020/6/12/10:14
 */
public class ConditionTest implements Runnable{
    private  static ReentrantLock lock=new ReentrantLock();
    public static Condition condition=lock.newCondition();



    @Override
    public void run() {
        lock.lock();//加锁
        try {
            System.out.println("lock 等待中。。");
            condition.await();//等待，并且释放锁
            System.out.println("lock 等待完成。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest conditionTest=new ConditionTest();
        Thread thread = new Thread(conditionTest);
        thread.start();

        Thread.sleep(2000);
        lock.lock();
        condition.signal();//激活线程等待
        lock.unlock();

    }
}
