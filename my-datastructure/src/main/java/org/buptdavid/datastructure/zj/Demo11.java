package org.buptdavid.datastructure.zj;

/**
 * @author jiezhou
 * @CalssName: Demo11
 * @Package org.buptdavid.datastructure.zj
 * @Description:
 * @date 2022/3/9/10:49
 */
public class Demo11 {
    public static void main(String[] args) {
        for (Emm value : Emm.values()) {
            int rankSeviceType = value.getRankSeviceType();
            System.out.println("rankSeviceType = " + rankSeviceType);
        }
    }

}
