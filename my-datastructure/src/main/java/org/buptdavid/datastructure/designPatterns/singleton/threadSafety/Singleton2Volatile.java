package org.buptdavid.datastructure.designPatterns.singleton.threadSafety;

/**
 * @author jiezhou
 * @CalssName: Singleton2
 * @Package org.buptdavid.datastructure.designPatterns.singleton.threadSafety
 * @Description:
 * @date 2021/2/20/9:32
 */
public class Singleton2Volatile {
    private static volatile Singleton2Volatile instance = null;//volatile 禁止指令重排，线程安全必须要加这个关键字

    private Singleton2Volatile() {
        System.out.println(Thread.currentThread().getName());
    }

    public static Singleton2Volatile getInstance() {
          /*双层检查不是绝对的安全，因为还有指令重排，所以必须加上volatile关键字禁止指令重排*/
        if (instance == null) {
            synchronized (Singleton2Volatile.class) {
                if (instance == null) {
                    instance = new Singleton2Volatile();
                }
            }
        }
        return instance;
    }
}
