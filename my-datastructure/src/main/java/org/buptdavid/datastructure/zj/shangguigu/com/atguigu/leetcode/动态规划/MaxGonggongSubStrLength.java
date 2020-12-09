package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: MaxGonggongASubStrLength
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 最长公共子序列长度
 * @date 2020/12/8/9:19
 */
public class MaxGonggongSubStrLength {

    public static void main(String[] args) {
        int res = longestCommonSubsequence("abdc", "adc");
        System.out.println(res);
    }


    public static int longestCommonSubsequence(String str, String str2) {
//        return process(str, str2, str.length() - 1, str2.length() - 1);//递归方式

        return process1(str, str2);//动态规划

    }

    private static int process1(String str, String str2) {
        if (str == null || str == "") {
            return 0;
        }
        if (str2 == null || str2 == "") {
            return 0;
        }
        int n = str.length();
        int m = str2.length();
        int[][] dp = new int[n][m];
        //初始化
        if (str.charAt(0) == str2.charAt(0)) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static int process(String str, String str2, int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (str.charAt(i) == str2.charAt(j)) {
            return process(str, str2, i - 1, j - 1) + 1;
        } else {
            return Math.max(process(str, str2, i - 1, j), process(str, str2, i, j - 1));
        }
    }
}
