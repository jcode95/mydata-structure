package org.buptdavid.datastructure.zj.thread.test;

/**
 * @author jiezhou
 * @CalssName: LockTest
 * @Package org.buptdavid.datastructure.zj.thread.test
 * @Description: 锁
 * @date 2021/3/1/19:13
 */
public class LockTest {

    public static void main(String[] args) {
        test1();
    }


    public static void test1() {
        /*通过 -XX:+DoEscapeAnalysis -XX:+EliminateLocks 开启或者关闭锁消除功能*/
        StringBuffer stringBuffer = new StringBuffer();
        long bf = System.currentTimeMillis();
        int i = 0;
        while (i < 10000000) {
            stringBuffer.append(1);//方法加了synchronized在方法上
            stringBuffer.append(12);
            stringBuffer.append(13);
            i++;
        }
        long af = System.currentTimeMillis();
        System.out.println("(af-bf) = " + (af - bf));

    }
}
