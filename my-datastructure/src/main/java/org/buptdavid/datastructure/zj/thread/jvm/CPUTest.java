package org.buptdavid.datastructure.zj.thread.jvm;

/**
 * @author jiezhou
 * @CalssName: CPUTest
 * @Package org.buptdavid.datastructure.zj.thread.jvm
 * @Description:
 * @date 2021/2/27/11:51
 */
public class CPUTest {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println();
                }
            }
        };
        thread.setName("t1");
        thread.start();
    }
}
