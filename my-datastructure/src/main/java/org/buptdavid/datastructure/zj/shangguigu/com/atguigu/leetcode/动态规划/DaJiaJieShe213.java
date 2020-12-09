package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: DaJiaJieShe
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 打家劫舍问题II 环形数组,在198 基础上稍加修改，
 *
 * ⾸先，⾸尾房间不能同时被抢，那么只可能有三种不同情况：
 * 要么都不被 抢；要么第⼀间房⼦被抢最后⼀间不抢；要么最后⼀间房⼦被抢第⼀间不 抢。
 * 也就是  去掉首个数据的剩余数组  和  去掉末尾的数据的剩余数组  的两个的最大值就是本题的答案
 * @date 2020/12/3/19:01
 */
public class DaJiaJieShe213 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        DaJiaJieShe213 she213 = new DaJiaJieShe213();
        int rob = she213.rob(nums);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dest1 = new int[nums.length - 1];
        int[] dest2 = new int[nums.length - 1];
        System.arraycopy(nums, 1, dest1, 0, nums.length - 1);
        System.arraycopy(nums, 0, dest2, 0, nums.length - 1);
        return Math.max(process(dest1), process(dest2));
    }

    private int process(int[] nums) {
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
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][1], dp[n - 1][0]);
    }
}
