package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jiezhou
 * @CalssName: XinFoQianTao
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 俄罗斯信封嵌套
 * @date 2020/12/3/17:23
 */
public class XinFoQianTao354 {

    /**
     * 题目:
     * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * 输出: 3
     * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
     */
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        /*1、按照 长 从小到大排列*/
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i = o1[0] - o2[0];
                if (i == 0) {
                    i = o1[1] - o2[1];
                }
                return i;
            }
        });
        showList(envelopes);
        /*2、取 宽 的递增子序列个数就是本题答案*/
        int n = envelopes.length;
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int d = 0; d < dp.length; d++) {
                if (i > d && envelopes[i][0] > envelopes[d][0] && envelopes[i][1] > envelopes[d][1]) {
                    dp[i] = Math.max(dp[d] + 1, dp[i]);
                }
            }
        }
        //找出dp里面最大的就是当前最长递增子序列长度了
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] arr = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
//        int[][] arr = {{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}};
        int[][] arr = {{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}};
        int i = new XinFoQianTao354().maxEnvelopes(arr);
        System.out.println(i);
    }

    private static void showList(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j : arr[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
