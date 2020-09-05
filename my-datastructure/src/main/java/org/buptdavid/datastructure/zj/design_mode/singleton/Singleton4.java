package org.buptdavid.datastructure.zj.design_mode.singleton;

/**
 * @author jiezhou
 * @CalssName: Singleton4
 * @Package org.buptdavid.datastructure.zj.design_mode.singleton
 * @Description:
 * @date 2020/7/21/15:32
 */
public class Singleton4 {

    private static Singleton4 singleton4;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
