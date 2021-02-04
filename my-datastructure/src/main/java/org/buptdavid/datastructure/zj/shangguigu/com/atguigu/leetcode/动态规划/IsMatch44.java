package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: IsMatch44
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description:
 * @date 2020/12/17/10:09
 */
public class IsMatch44 {
    /*
    ab
    ab*


    abc
    ab*

    acb
    ab*
    *
    *
 Boolean[][] dp = new Boolean[n + 1][m + 1];
 base case
 dp[0][0]=true;
 dp[i][0]=false
 if(p.charAt(j)=='*'){
    dp[0][j]=true
 }else{
  dp[0][j]=false
 }

 状态转移方程
    s[i] == p[j]，或者 p[j] == ?    dp[i][j]=dp[i-1][j-1]
    当 p[j-1] == * 那么 dp[i][j] = dp[i][j - 1] || dp[i - 1][j]   //dp[i][j - 1] '*'代表空字符串， dp[i - 1][j]  '*' 代表不是空字符串

    *
    *
    * */


    public static boolean isMatch(String s, String p) {

        /*
    ab
    ab*


    abc
    ab*

    acb
    ab*
    *
    *
 Boolean[][] dp = new Boolean[n + 1][m + 1];
 base case
 dp[0][0]=true;
 dp[i][0]=false
 if(p.charAt(j)=='*'){
    dp[0][j]=true
 }else{
  dp[0][j]=false
 }

 状态转移方程
    s[i] == p[j]，或者 p[j] == ?    dp[i][j]=dp[i-1][j-1]
    当 p[j-1] == * 那么 dp[i][j] = dp[i][j - 1] || dp[i - 1][j]   //dp[i][j - 1] '*'代表空字符串， dp[i - 1][j]  '*' 代表不是空字符串

    *
    *
    * */
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1]; // 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配

        // base case
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        // 状态转移 abc
               //   ab*
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (sc[i - 1] == pc[j - 1] || pc[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        boolean b = isMatch("abcd", "*?");
        System.out.println(b);
    }
}
