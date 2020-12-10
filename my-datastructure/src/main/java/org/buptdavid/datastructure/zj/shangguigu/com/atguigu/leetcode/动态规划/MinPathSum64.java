package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: MinPathSum64
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 最小路径和
 * @date 2020/12/8/19:02
 */
public class MinPathSum64 {

    /**
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        //base case
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {//初始化第0行
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {//初始化第0列
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //转移方程
        //dp[i][j]=min(dp[i][j-1],dp[i-1][j])+gird[i][j];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        //return
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
       /* int[][] arr = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };*/
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(minPathSum(arr));
    }
}
