package org.buptdavid.datastructure.zj.thread.jvm;

import java.util.ArrayList;

/**
 * @author jiezhou
 * @CalssName: jvisualvm
 * @Package org.buptdavid.datastructure.zj.thread.jvm
 * @Description: jvisualvm jvm 调优工具
 * @date 2021/9/23/15:31
 */
public class jvisualvm {
    private String a = new String("sdddd");

    public static void main(String[] args) {
        ArrayList<Com> coms = new ArrayList<>();
        while (true) {
            coms.add(new Com());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Com {

    }
}
