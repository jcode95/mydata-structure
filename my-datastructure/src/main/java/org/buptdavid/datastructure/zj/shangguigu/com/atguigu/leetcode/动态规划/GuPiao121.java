package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: GuPiao1
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划
 * @Description: 买卖股票 ,这个问题就是k==1
 * @date 2020/12/3/15:32
 */
public class GuPiao121 {
    /**
     * 状态转移方程 模板
     * <p>
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])              第三维 0 是没有持有，1 是持有、第二维 k 代表今天还可以交易的次数、 第一维 i 表示第几天，对应的是股票数组的下标
     * max( 选择 rest , 选择 sell )
     * 解释：今天我没有持有股票，有两种可能： 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
     * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * max( 选择 rest , 选择 buy )
     * 解释：今天我持有着股票，有两种可能： 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
     * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
     * <p>
     * base case 模板
     * dp[-1][k][0]=0
     * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
     * dp[-1][k][1]=Integer.MAXVALUE;
     * 解释：还没开始的时候，是不可能持有股票的，用Integer.MAXVALUE表示这种不可能。
     * dp[i][0][0]=0;
     * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
     * dp[i][0][1] = Integer.MAXVALUE;
     * 解释：不允许交易的情况下，是不可能持有股票的，⽤负⽆穷表⽰这种不可能。
     * <p>
     * <p>
     * <p>
     * 本题状态转移方程
     * <p>
     * <p>
     * dp[i][0]=max(dp[i-1][0]，dp[i-1][1]+prices[i]);  //dp[i][0] 的值代表第i天没有持有股票的利润
     * dp[i][1]=max(dp[i-1][1],-prices[i]);  //dp[i][1] 的值代表第i天持有股票的利润
     * <p>
     * 本题 base case
     * dp[0][0] = 0;
     * dp[0][1] = -prices[0];//第一天持有，所以利润是负的第一天是股票价格
     */

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];//第一天持有，所以利润是负的第一天是股票价格
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        int i = new GuPiao121().maxProfit(arr);
        System.out.println(i);
    }
}
