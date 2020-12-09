package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: TwoJianPan650
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 两个键的键盘问题
 * @date 2020/12/5/17:43
 */
public class TwoJianPan650 {

    /*
    * 问题：
    最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
    Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
    Paste (粘贴) : 你可以粘贴你上一次复制的字符。
    给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
    * */

    public static void main(String[] args) {
        TwoJianPan650 pan650 = new TwoJianPan650();
        int steps = pan650.minSteps(5);
        System.out.println(steps);
    }

    /*public int minSteps(int n) {
        int[] dp = new int[n + 1];
        int i=0;//次数
        while (true) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k < j; k++) {

                }
                dp[i]=dp[j]
            }
        }
    }*/

    /**
     *  别人答案
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int[] dp = new int[1001];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = (int) Math.sqrt(i); j >= 2; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
