package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: ClimbStairs70
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 爬楼梯  这种就是一个斐波那契数列
 * @date 2020/12/8/19:16
 */
public class ClimbStairs70 {

    public static void main(String[] args) {
        int n=9;
        System.out.println(climbStairs(n));
        System.out.println(climbStairs1(n));
    }

    /**
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * <p>
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs1(int n) {
        //本题就是斐波那契数列
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n == 1) {
            return 1;
        }
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
