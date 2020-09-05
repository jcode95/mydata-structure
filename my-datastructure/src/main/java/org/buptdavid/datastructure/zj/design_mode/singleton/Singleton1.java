package org.buptdavid.datastructure.zj.design_mode.singleton;


/**
 * @author jiezhou
 * @CalssName: Singleton1
 * @Package org.buptdavid.datastructure.zj.design_mode.singleton
 * @Description: 线程安全的饿汉式静态变量
 * @date 2020/7/21/15:22
 */
public class Singleton1 {

    //私有构造方法
    private Singleton1() {
    }

    private static Singleton1 singleton1 = new Singleton1();

    public static Singleton1 getInstance() {
        return singleton1;
    }
}
