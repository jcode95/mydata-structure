package org.buptdavid.datastructure.zj.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;

/**
 * @author jiezhou
 * @CalssName: SemaphoreTest
 * @Package org.buptdavid.datastructure.zj.thread
 * @Description: 信号量测试
 * @date 2020/6/12/10:32
 */
public class SemaphoreTest implements Runnable{
    final static Semaphore s=new Semaphore(5);//意味着同时最多可以有5个线程执行这段代码
    @Override
    public void run() {
        try {

            s.acquire();//获取一个准入的许可（相当于都阻塞到这）

//            Thread.sleep(3000);
            System.out.println("线程id："+Thread.currentThread().getId());
            s.release();//释放许可

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService exe = Executors.newScheduledThreadPool(20);
        final SemaphoreTest semaphoreTest = new SemaphoreTest();
        for (int i = 0; i < 6; i++) {
            exe.execute(semaphoreTest);
        }
        exe.shutdown();

    }
}
