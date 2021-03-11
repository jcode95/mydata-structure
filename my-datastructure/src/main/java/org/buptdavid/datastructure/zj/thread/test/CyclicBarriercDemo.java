package org.buptdavid.datastructure.zj.thread.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏和CountDownLatch类似，但是比CountDownLatch更加复杂强大
 */
public class CyclicBarriercDemo {
    static  CyclicBarrier cyclicBarrier=new CyclicBarrier(5,new A());

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new B(i));

            thread.interrupt();//设置中断标识
            thread.start();

        }
//        System.out.println("总汇报工作");
    }

    public static class A implements Runnable{

        @Override
        public void run() {
            System.out.println("到达了门阀");
        }
    }
    public static class B implements Runnable{
        int value;

        public B(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            try {
//                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+":等待其他线程就绪。。。");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+":开始工作"+value);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+":正在工作中..."+value);
                Thread.sleep(1000);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+":执行完毕"+value);
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


/*
*
* @PostConstruct与@PreConstruct注解
，Servlet增加了两个影响Servlet生命周期的注解（Annotation）：@PostConstruct和@PreConstruct。这两个注解被用来修饰一个非静态的void()方法.而且这个方法不能有抛出异常声明。
1.@PostConstruct说明
被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的init()方法。被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。
2.@PreConstruct说明
被@PreConstruct修饰的方法会在服务器卸载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的destroy()方法。被@PreConstruct修饰的方法会在destroy()方法之后运行，在Servlet被彻底卸载之前。（详见下面的程序实践）
*
* */


}
