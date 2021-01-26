package org.buptdavid.datastructure.zj;

/**
 * @author jiezhou
 * @CalssName: Main2
 * @Package org.buptdavid.datastructure.zj
 * @Description:
 * @date 2021/1/3/23:07
 */
public class Main2 {

    public static void main(String[] args) {
        String cdtime = "60";
        String carNum = "1";
        double speed = Double.parseDouble(carNum) / ( Double.parseDouble(cdtime) * 1000d);
        System.out.println(speed);
    }
}
