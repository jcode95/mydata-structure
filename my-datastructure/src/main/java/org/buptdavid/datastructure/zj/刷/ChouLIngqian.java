package org.buptdavid.datastructure.zj.刷;

/**
 * @author jiezhou
 * @CalssName: ChouLIngqian
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 动态规划-凑零钱问题
 * 先看下题⽬：
 * 给你 k 种⾯值的硬币，⾯值分别为 c1, c2 ... ck ，
 * 每种硬 币的数量⽆限，再给⼀个总⾦额 amount ，问你最少需要⼏枚硬币凑出这个 ⾦额，如果不可能凑出，算法返回 -1 。
 * @date 2021/6/4/3:08
 */
public class ChouLIngqian {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 6;
        int min = coinChange(coins, amount);
        System.out.println("min = " + min);

    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        //当前目标金额 是 n  至少需要dp[n] 个银币
        //base case
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i]=i;
        }

        for (int n = 1; n <= amount; n++) {
            for (int coin : coins) {
                if (n - coin >= 0) {
                    dp[n] = Math.min(dp[n], dp[n - coin] + 1);
                }
            }
        }

        return dp[amount];
    }


    /*







    斜着遍历二维数组
    *
    * for(int l=2;l<=n;l++){
    *   for(int i==0;i<=n-1;i++){
    *       int j=l+i-1;
    *       //计算dp[i][j]
    *   }
    *
    * }
    *
    *
    *
    *
    *我们反向遍历
    * for (int i = m - 1; i >= 0; i--)
    *   for (int j = n - 1; j >= 0; j--)
    *       // 计算 dp[i][j]
    *
    *
    *
    *
    *
    * 正向遍历
    *
    *   int[][] dp = new int[m][n];
    *   for (int i = 0; i < m; i++)
    *       for (int j = 0; j < n; j++)
    *           // 计算 dp[i][j]
    *
    *
    *
    * */


}
