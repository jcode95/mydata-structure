package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: MaximalRectangle85
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 最大矩形问题
 * @date 2020/12/10/10:45
 */
public class MaximalRectangle85 {

    /**
     * 2*3=6
     * 3*4=(1+2)*(1+3)=(1*1)+1*3+2*1+2*3=12
     * 4*5=20
     *
     * @param args
     */
    public static void main(String[] args) {
        /*int[][] matrix = new int[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };*/
        int[][] matrix = new int[][]{
                {0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1}
        };
        System.out.println(maximalRectangle(matrix));
    }

    /**
     * 暴力破解
     */
    public static int maximalRectangle(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];// dp[i][j] 代表以当前i行j列结尾的连续 1 的个数(说的是i行的连续个数)
        int maxAre = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    if (col == 0) {
                        dp[row][0] = 1;//初始值
                    } else {
                        dp[row][col] = dp[row][col - 1] + 1;
                    }
                } else {
                    dp[row][col] = 0;
                }
                int min = dp[row][col];
                //以行为标准，从下到上遍历
                for (int up_row = row; up_row >= 0; up_row--) {
                    min = Math.min(min, dp[up_row][col]);
                    //计算高度
                    int height = row - up_row + 1;
                    //更新最大面积
                    maxAre = Math.max(maxAre, height * min);
                }
            }
        }
        return maxAre;
    }
}
