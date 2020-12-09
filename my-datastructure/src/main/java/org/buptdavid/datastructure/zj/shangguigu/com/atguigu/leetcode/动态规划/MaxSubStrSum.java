package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: MaxSubStrSum
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 最大子序列和
 * @date 2020/12/9/20:27
 */
public class MaxSubStrSum {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        //去dp数组里面最大值
        int max = dp[0];
        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < n && i > j; j++) {//循环找到dp数组里面存在的最大子序列和加上本下标的值，再与本下标值做比较取最大的
//                dp[i] = Math.max(dp[j] + nums[i], nums[i]);
//            }
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);//这是上面的for循环改良的，效率比for循环高
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
