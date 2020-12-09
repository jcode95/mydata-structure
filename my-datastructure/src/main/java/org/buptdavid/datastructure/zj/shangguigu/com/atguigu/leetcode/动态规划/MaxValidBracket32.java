package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: MaxValidBracket32
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 最长有效括号
 * @date 2020/12/9/16:38
 */
public class MaxValidBracket32 {

    public static void main(String[] args) {
        System.out.println(new MaxValidBracket32().longestValidParentheses("()"));
    }

    /**
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        s=" "+s;//让s的最前面填充一个空字符串，做i-2用，才不会报数组越界
        int n = s.length();
        int[] dp = new int[n+1];
        int max = 0;  //获取dp里面最大值就其值
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else {
                    if (i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean chat(String s, int i, int k) {
        if (s.charAt(i) == '(') {
            if (s.charAt(k) == ')') {
                return true;
            }
        }
        return false;
    }
}

