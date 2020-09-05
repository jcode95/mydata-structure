package org.buptdavid.datastructure.zj.design_mode.singleton;


/**
 * @author jiezhou
 * @CalssName: Singleton3
 * @Package org.buptdavid.datastructure.zj.design_mode.singleton
 * @Description: 静态内部类的线程安全的单利
 * @date 2020/7/21/15:28
 */
public class Singleton3 {


    private Singleton3() {
    }

    static class help {
        static Singleton3 singleton3 = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return help.singleton3;
    }
}
