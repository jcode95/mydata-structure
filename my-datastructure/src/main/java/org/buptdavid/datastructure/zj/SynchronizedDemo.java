package org.buptdavid.datastructure.zj;

/**
 * @author jiezhou
 * @CalssName: SynchronizedDemo
 * @Package org.buptdavid.datastructure.zj
 * @Description: 底层原理，使用javap -c 全类名的class文件来反编译
 * @date 2020/11/17/14:20
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        cess();
    }

    public void process() {
        synchronized (this) {
            System.out.println("process");
        }
    }

    public static synchronized void cess() {

    }


    /**
     *
     * 区别如下：
     来源：
     lock是一个接口，而synchronized是java的一个关键字，synchronized是内置的语言实现；
     异常是否释放锁：
     synchronized在发生异常时候会自动释放占有的锁，因此不会出现死锁；而lock发生异常时候，不会主动释放占有的锁，必须手动unlock来释放锁，可能引起死锁的发生。（所以最好将同步代码块用try catch包起来，finally中写入unlock，避免死锁的发生。）
     是否响应中断
     lock等待锁过程中可以用interrupt来中断等待，而synchronized只能等待锁的释放，不能响应中断；
     是否知道获取锁
     Lock可以通过trylock来知道有没有获取锁，而synchronized不能；
     Lock可以提高多个线程进行读操作的效率。（可以通过readwritelock实现读写分离）
     在性能上来说，如果竞争资源不激烈，两者的性能是差不多的，而当竞争资源非常激烈时（即有大量线程同时竞争），此时Lock的性能要远远优于synchronized。所以说，在具体使用时要根据适当情况选择。
     synchronized使用Object对象本身的wait 、notify、notifyAll调度机制，而Lock可以使用Condition进行线程之间的调度，
     * */


}
