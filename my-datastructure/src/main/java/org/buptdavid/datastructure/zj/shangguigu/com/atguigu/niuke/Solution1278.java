package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.niuke;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: Solution1278
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.niuke
 * @Description:
 * @date 2021/7/23/11:23
 */
public class Solution1278 {

    public int palindromePartition(String s, int k) {
        int length = s.length();
        int[][] dp = new int[length + 1][k + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], length);
        }
        for (int i = 1; i <= length; i++) {
            int min = Math.min(i, k);
            for (int j = 1; j <= min; j++) {
                if (j == 1) {
                    //如果j等于1，则表示没有分割，我们直接计算
                    dp[i][j] = chenge(s, j - 1, i - 1);
                } else {
                    //如果j不等于1，我们计算分割所需要修改的最小字符数，因为m的值要
                    //大于等于j-1，我们就从最小的开始枚举
                    for (int m = j - 1; m < i; m++) {
                        dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + chenge(s, m, i - 1));
                    }

                }
            }

        }
        return dp[length][k];


    }

    private int chenge(String s, int left, int right) {
        int count = 0;
        while (left < right) {
            if (s.charAt(left++) == s.charAt(right--)) {
                count++;
            }
        }
        return count;
    }
}
