package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: UniqiePaths62
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 机器人走网格
 * @date 2020/12/8/15:31
 */
public class UniqiePaths62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));

    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //base case
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        /**
         *   状态转移方程
         *   dp[i][j]=dp[i-1][j]+dp[i][j-1]
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }


}
