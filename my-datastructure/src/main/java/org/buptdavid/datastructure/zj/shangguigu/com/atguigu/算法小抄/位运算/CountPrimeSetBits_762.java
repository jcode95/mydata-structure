package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.位运算;

/**
 * @author jiezhou
 * @CalssName: CountPrimeSetBits_762
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.位运算
 * @Description:
 * @date 2021/11/4/14:22
 *
 * 762. 二进制表示中质数个计算置位
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 *
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 *
 * 示例 1:
 *
 * 输入: L = 6, R = 10
 * 输出: 4
 * 解释:
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 示例 2:
 *
 * 输入: L = 10, R = 15
 * 输出: 5
 * 解释:
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 注意:
 *
 * L, R 是 L <= R 且在 [1, 10^6] 中的整数。
 * R - L 的最大值为 10000。
 * ————————————————
 * 版权声明：本文为CSDN博主「南     墙」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/a1439775520/article/details/105557047
 */
public class CountPrimeSetBits_762 {

    public static void main(String[] args) {
        int v = (int) Math.pow(10, 6);
//        System.out.println("v = " + v);
//        System.out.println("Integer.toBinaryString(v+\"\") = " + Integer.toBinaryString(v));
        int L=1,R=3;
        int i = countPrimeSetBits(L, R);
        System.out.println("i = " + i);
    }

    public static int countPrimeSetBits(int L, int R) {
        int[] primes = {0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1};//20 已内所有的质数
        int res=0;
        for(int i=L;i<=R;i++) {
//            int t = i;
            int t = Integer.bitCount(i);
           /* System.out.println("Integer.toBinaryString("+t+") :  " +  Integer.toBinaryString(t));
            t = t - ((t >>> 1) & 0x55555555);//0x55555555	01010101010101010101010101010101
            t = (t & 0x33333333) + ((t >>> 2) & 0x33333333);//0x33333333	00110011001100110011001100110011
            t = (t + (t >>> 4)) & 0x0f0f0f0f;//0x0f0f0f0f	00001111000011110000111100001111
            t = t + (t >>> 8);
            t = t + (t >>> 16);*/
            res = res + primes[t];
        }
        return res;
    }
}
