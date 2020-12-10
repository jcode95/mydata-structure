package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: MinDistance72
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 编辑距离
 * @date 2020/12/10/10:19
 */
public class MinDistance72 {


    public static int minDistance(String word1, String word2) {
        int n = word1.length() + 1;
        int m = word2.length() + 1;
        int[][] dp = new int[n][m];
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;//想象为一个二维数组，取左上三角的最小值+1
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
//        String word1 = "horse", word2 = "ros";
        String word1 = "intention", word2 = "execution";
        System.out.println(minDistance(word1, word2));

    }
}
