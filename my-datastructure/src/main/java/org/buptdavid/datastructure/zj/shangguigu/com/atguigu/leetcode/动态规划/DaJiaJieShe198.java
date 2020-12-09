package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: DaJiaJieShe
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 打家劫舍问题、
 * @date 2020/12/3/19:01
 */
public class DaJiaJieShe198 {
    public static void main(String[] args) {
        int rob = new DaJiaJieShe198().rob(new int[]{1,2,3,1});
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        /**
         * 状态转移方程：
         * dp[i][0]=max(dp[i-1][0],dp[i-1][1]);
         * dp[i][1]=dp[i-1][0]+nums[i];
         *
         * base case
         *
         * dp[0][0]=0;
         * dp[0][1]=nums[0];
         *
         * return
         *
         * max(dp[n-1][0],dp[n-1][1])
         */

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][2];
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //处理特殊情况
        if (n == 1) {
            return nums[0];
        }
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return Math.max(dp[n - 1][1],dp[n-1][0]);
    }
}
