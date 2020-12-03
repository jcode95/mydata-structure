package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jiezhou
 * @CalssName: MaxEnvelopes
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划
 * @Description: 信封嵌套问题
 * @date 2020/11/27/23:11
 */
public class MaxEnvelopes {

    /*
    * 给定一个N行2列的二维数组，每一个小数组的两个值分别代表一个信封的长和宽。如果信封A 的长度都小于信封B，那么信封A可以放在信封B里，请返回信封最多嵌套多少层
        举例：

        matrix = [[3,4],[2,3],[4,5],[1,3],[2,2],[3,6],[1,2],[3,2],[2,4]]

        信封最多可以套4层，从里到外分别是[1,2],[2,3],[3,4],[4,5],所以返回4

        时间复杂度为O(NlogN)
    *
    * */

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 4}, {2, 3}, {4, 5}, {1, 3}, {2, 2}, {3, 6}, {1, 2}, {3, 2}, {2, 4}};
//        showList(arr);
        System.out.println(maxEnvelopesProcess(arr));
    }

    private static void showList(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j : arr[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int maxEnvelopesProcess(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i = o1[0] - o2[0];
                if (i == 0) {
                    i = o1[1] - o2[1];
                }
                return i;
            }
        });
        showList(arr);


        //对宽也就是是arr的第二维度取最长递增子序列长度就是能套多少个信封
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int k = 0; k < dp.length; k++) {
                if (i > k && arr[i][1] > arr[k][1]) {
                    dp[i] = Math.max(dp[k] + 1,dp[i]);
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

}
