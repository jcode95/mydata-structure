package org.buptdavid.datastructure.zj.design_mode.singleton;


/**
 * @author jiezhou
 * @CalssName: Singleton2
 * @Package org.buptdavid.datastructure.zj.design_mode.singleton
 * @Description: 线程安全的（效率不高的）
 * @date 2020/7/21/15:25
 */
public class Singleton2 {
    private static Singleton2 singleton2 ;

    public Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }


}
