package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划;

/**
 * @author jiezhou
 * @CalssName: CouLingQian
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划
 * @Description: 凑零钱问题
 * @date 2020/11/26/19:26
 */
public class CouLingQian {
    /*
    * 先看下题⽬：给你 k 种⾯值的硬币，⾯值分别为 c1, c2 ... ck ，每种硬 币的数量⽆限，再给⼀个总⾦额 amount、
    * 问你最少需要⼏枚硬币凑出这个⾦额，如果不可能凑出，算法返回 -1 。
    * 算法的函数签名如下：
    * // coins 中是可选硬币⾯值，amount 是⽬标⾦额
    *   int coinChange(int[] coins, int amount);
    *
    * */
    public static void main(String[] args) {
        int count = new CouLingQian().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(count);
    }

    private int coinChange(int[] coins, int amount) {
        int MAX = 9999;
        int[] dp = new int[amount + 1];
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        for (int i = 1; i <= amount; i++) { //dp[i]表示达到i用的最少硬币数  默认=初始化全为0
            dp[i] = MAX;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == MAX ? -1 : dp[amount];
    }
}
