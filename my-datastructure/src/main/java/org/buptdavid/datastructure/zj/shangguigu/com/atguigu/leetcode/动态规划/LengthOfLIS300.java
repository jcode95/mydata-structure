package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: MaxAddSubStr
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 最长递增子序列问题
 * <p>
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * @date 2021/6/4/3:56
 */
public class LengthOfLIS300 {
    public static void main(String[] args) {
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        int maxLength = lengthOfLIS(nums);
        System.out.println("maxLength = " + maxLength);
    }

    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
//       dp[n] 就是 n 在 nums 数组下标时 的最长递增子序列
        //base case
//        for (int i = 0; i < dp.length; i++) {
//            dp[i]=1;
//        }
        Arrays.fill(dp,1);
        //tz zyfc
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i > j && nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < dp.length; i++) {
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }
}
