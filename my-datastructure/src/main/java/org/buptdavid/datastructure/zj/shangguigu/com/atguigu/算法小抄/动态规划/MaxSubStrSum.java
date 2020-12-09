package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划;

/**
 * @author jiezhou
 * @CalssName: MaxSubStrSum
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划
 * @Description: 最大子序列和
 * <p>
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素） 返回其最大的和
 * 示例：
 * 输入{-2,1,-3,4,-1,2,1,-5,4}
 * 输出 6
 * 解释：连续子数组[4,-1,2,1] 的和最大 为6
 * @date 2020/11/30/16:16
 */
public class MaxSubStrSum {


    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(process(arr));
    }

    public static int process(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < arr.length; i++) {
//            for (int k = 0; k < dp.length && i > k; k++) {
//                dp[i] = Math.max(dp[k] + arr[i], arr[i]);
//            }
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
