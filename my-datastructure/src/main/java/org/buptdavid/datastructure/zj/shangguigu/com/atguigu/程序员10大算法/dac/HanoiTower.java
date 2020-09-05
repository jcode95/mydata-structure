package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.dac;

/**
 * @author jiezhou
 * @CalssName: Hanoi
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.dac
 * @Description: 分治算法-汉诺塔
 * @date 2020/8/31/17:01
 */
public class HanoiTower {

    public static void main(String[] args) {
        move(13, 'a', 'b', 'c');

    }


    /**
     * @param num 汉诺塔的盘的数量
     * @param a   柱子a
     * @param b   柱子b
     * @param c   柱子c
     */
    public static void move(int num, char a, char b, char c) {

        if (num == 1) {
            System.out.println("第 " + num + " 个盘从 " + a + " 移动到 " + c);
        } else {
            /*如果我们有n>=2情况，我们总是可以看成两个盘，最下边的一个和上边的所有盘*/
            /*1、先把最上面的所有盘从a->b ,中间使用c辅助*/
            move(num - 1, a, c, b);//a-->b
            /*2、把最下面的盘从a移动到c*/
            System.out.println("第 " + num + " 个盘从 " + a + " 移动到 " + c);
            /*3、把b的所有盘从b移动到c*/
            move(num - 1, b, a, c);
        }


    }
}
