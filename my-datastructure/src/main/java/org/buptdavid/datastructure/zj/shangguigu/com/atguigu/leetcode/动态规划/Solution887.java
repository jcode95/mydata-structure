package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSeedValueMDP;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: Solution887
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description:
 * @date 2021/7/22/10:25
 */
public class Solution887 {

    public static void main(String[] args) {
        int k = 3, n = 4;
        int i1 = superEggDrop(k, n);
        System.out.println("i1 = " + i1);
        int i2 = dp1(k, n);
        System.out.println("i2 = " + i2);
    }
    public static int superEggDrop(int k, int n) {
        if (k == 0 || n == 1 || k == 1) {
            return n;
        }
        int[][] dp = new int[k + 1][n + 1];
        //base case
        for (int i = 0; i < dp.length; i++) {
            for (int b = 0; b < dp[i].length; b++) {
                if (i == 0 || b == 0)
                    dp[i][b] = 0;

                if (i == 1)
                    dp[i][b] = 1;
            }
        }
        for (int j = 1; j < k; j++) {
            for (int i = 1; i <= n; i++) {
                // i就是层数
                dp[j][i] = dp[j - 1][i - 1] + dp[j][n - i] + 1;
                if (dp[j][i] > n) {
                    return i;
                }
            }
        }

        return n;

    }

    public static int dp1(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0; // zero egg
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }

    private int superEggDrop1(int K, int N) {
        // m 最多不会超过 N 次（线性扫描）
        int[][] dp = new int[K + 1][N + 1];
        // base case:
        // dp[0][..] = 0
        // dp[..][0] = 0
        // Java 默认初始化数组都为 0
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++)
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
        }
        return m;
    }
}
