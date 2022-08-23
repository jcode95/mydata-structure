package org.buptdavid.datastructure.zj.zuo_shen.位运算;

/**
 * @author root
 * @CalssName: 剑指offer65
 * @Package org.buptdavid.datastructure.zj.zuo_shen.位运算
 * @Description: 不用加减乘除做加法
 * @date 2022/8/23/19:51
 */
public class 剑指offer65 {

    public static void main(String[] args) {
        int a = 10, b = 10;
        int add = add(a, b);
        System.out.println("add = " + add);

        int substract = substract(a, b);
        System.out.println("substract = " + substract);
    }

    /**
     * 1）位运算加法：
     *
     *
     * 对于两数二进制相加，不进位相加相当于异或num，指考虑进位计算为与，
     * 并左移一位carry;当carry不为0时表示有进位，将进位的数carry不进位“加”到num中，得到新的num和carry；
     */
    public static int add(int num1, int num2) {
        if(num2 == 0)
            return num1;
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return add(sum, carry);
    }

    /**
     * num1: 减数
     * num2: 被减数
     *
     *
     * 通过加法器来实现减法器，即首先实现一个加法器，设为add(int a,int b)；
     *
     * 然后对两个数num1，num2，num1-num2=num1+(-num2)；
     * 对于一个数的负数在计算机中时取反再加1，即m_num2=add(~num2,1)；然后add(num1,m_num2);
     */
    public static int substract(int num1, int num2) {
        int subtractor = add(~num2, 1);// 先求减数的补码（取反加一）
        int result = add(num1, subtractor); // add()即上述加法运算　　
        return result;
    }
}
