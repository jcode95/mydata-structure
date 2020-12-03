package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划;

/**
 * @author jiezhou
 * @CalssName: ShiTouGame
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划
 * @Description: 石头游戏
 * <p>
 * 你和你的朋友⾯前有⼀排⽯头堆，⽤⼀个数组 piles 表⽰，piles[i] 表⽰第 i 堆⽯⼦有多少个。
 * 你们轮流拿⽯头，⼀次拿⼀堆，但是只能拿⾛最左边或者 最右边的⽯头堆。
 * 所有⽯头被拿完后，谁拥有的⽯头多，谁获胜。
 * ⽯头的堆数可以是任意正整数，⽯头的总数也可以是任意正整数，
 * 这样就能 打破先⼿必胜的局⾯了。⽐如有三堆⽯头 piles = [1, 100, 3] ，
 * 先⼿不管 拿 1 还是 3，能够决定胜负的 100 都会被后⼿拿⾛，后⼿会获胜。
 * 假设两⼈都很聪明，请你设计⼀个算法，返回先⼿和后⼿的最后得分（⽯头 总数）之差。⽐如上⾯那个例⼦，
 * 先⼿能获得 4 分，后⼿会获得 100 分，你 的算法应该返回 -96。
 * @date 2020/12/2/14:15
 */
public class ShiTouGame {

    public static void main(String[] args) {
        System.out.println(process(new int[]{3, 9, 1, 2}));
    }


    /**
     * @param piles 石头堆
     * @return 返回先手最后得分-后手最后得分
     */
    static int process(int piles[]) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        //初始化,只填充上三角
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        //填入base case,对角线上的元素就是当i==j时，只有一堆石头，先手的就得到最多
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(piles[i], 0);
            dp[i][i] = pair;
        }

        //斜着遍历二维数组
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                int j = L + i - 1;
                if (j > n - 1) {
                    continue;
                }
                int left = dp[i + 1][j].sec + piles[i];
                int right = dp[i][j - 1].sec + piles[j];
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        Pair pair = dp[0][n - 1];
        return pair.fir - pair.sec;
    }

    static class Pair {
        int fir;//先手
        int sec;//后手

        public Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
}
