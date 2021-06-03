package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划;

/**
 * @author jiezhou
 * @CalssName: LongIncreSub
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划
 * @Description: 最长递增子序列
 * @date 2020/11/26/23:31
 */
public class LongIncreSub {
    public static void main(String[] args) {

        int res = new LongIncreSub().process(new int[]{10,9,2,5,3,7,101,18});
//        int res = new LongIncreSub().process(new int[]{2,3,2,3,4,2,4,6,5});
        System.out.println(res);
    }

    /**
     * 思路：
     * dp[i] 的定义，dp[i] 表示 arr在下标为i的对应的最长递增子序列长度
     * 初始化：
     * dp[0] 的最长递增子序列就为1
     *
     * @param arr
     * @return
     */
    public int process(int arr[]) {
        if (arr.length == 0) {
            return -1;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i > j && arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }
        /*找出dp数组里面最大值就是最长递增子序列了长度了*/
        int res=0;
        for (int i = 0; i < dp.length; i++) {
            res=Math.max(res,dp[i]);
        }
        return res;
    }


}
