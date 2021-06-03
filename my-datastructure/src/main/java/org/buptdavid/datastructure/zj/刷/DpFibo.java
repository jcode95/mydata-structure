package org.buptdavid.datastructure.zj.刷;

/**
 * @author jiezhou
 * @CalssName: DpFibo
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 动态规划-斐波那契数列
 * @date 2021/6/4/2:55
 */
public class DpFibo {


    public static int pprocess(int N) {
        if (N == 1 || N == 2) {
            return 0;
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N-1];
    }

    public static void main(String[] args) {
        System.out.println("pprocess(9) = " + pprocess(9));

        
    }
}
