package org.buptdavid.datastructure.zj.design_mode.singleton;

/**
 * @author jiezhou
 * @CalssName: Test
 * @Package org.buptdavid.datastructure.zj.design_mode.singleton
 * @Description:
 * @date 2020/7/21/15:42
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton4 instance = Singleton4.getInstance();
                    System.out.println(instance);
                }
            });
            thread.start();
        }


    }
}
