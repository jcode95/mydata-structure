package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: UniqiePaths63
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: UniqiePaths62 II
 * @date 2020/12/8/15:48
 */
public class UniqiePaths63 {


    /**
     * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
     * 解释：
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     *
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        //base case
        for (int i = 0; i < m; i++) {//处理第0行
            dp[0][i] = 1;
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                continue;
            }
            if (i - 1 >= 0) {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 0; i < n; i++) {//处理第0列
            dp[i][0] = 1;
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                continue;
            }
            if (i - 1 >= 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {//处理障碍物
                    dp[i][j] = 0;
                    continue;
                }
                //状态转移方程
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
//        int[][] arr = new int[][]{
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
//        int[][] arr = new int[][]{
//                {0, 0, 0, 1, 0, 0, 0, 0}
//        };
        int[][] arr = new int[][]{
                {1},
                {0}
        };
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
