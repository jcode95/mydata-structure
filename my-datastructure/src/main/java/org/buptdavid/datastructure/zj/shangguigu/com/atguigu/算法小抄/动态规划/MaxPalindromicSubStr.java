package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划;

/**
 * @author jiezhou
 * @CalssName: MaxPalindromicSubStr
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划
 * @Description: 求最长回文子序列
 * @date 2020/11/30/17:29
 * <p>
 * 一个字符串有许多子序列，比如字符串abcfgbda，它的子序列有a、bfg、bfgbd，在这些子序列中肯定有回文字符串。现在要对任意字符串求其最长的回文子序列。
 * 注意，本文不是解决最长回文子串，回文子串是连续的，回文子序列是不连续的。
 * 字符串abcfgbda的最长回文子序列为abcba，长度为5。
 * 输入：包含若干行，每行有一个字符串，字符串由大小写字母构成，长度不超过100。
 * 输出：对每个输入，输出一行，该行有一个整数，表示最长回文子序列的长度。
 * Example
 * Input:
 * a
 * abcfgbda
 * Output:
 * 1
 * 5
 */
public class MaxPalindromicSubStr {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("abcfabda"));
    }

    /**
     * @param string abcfgbda
     * @return 5
     */
    public static int longestPalindromeSubseq(String string) {
        /**abcfabda
         * abcba
         * 5
         */
        char[] chars = string.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][chars.length - 1];
    }
}
