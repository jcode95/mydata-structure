package org.buptdavid.datastructure.zj.zuo_shen.递归;

/**
 * @author root
 * @CalssName: FindMax
 * @Package org.buptdavid.datastructure.zj.zuo_shen.递归
 * @Description:
 * @date 2022/8/16/15:52
 */
public class FindMax {

    public static void main(String[] args) {
        int[] arr2 = new int[]{
                1, 2, 3, 4, 5, 1, 2, 3, 5, 4, 4, 2};
        int max = getMax(arr2, 0, arr2.length - 1);
        System.out.println("max = " + max);
    }

    /**
     * 获取数组里面的最大值   递归写法
     *
     * @param arr
     * @return
     */
    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + (R - L) / 2;//int mid=L+ (R-L)>>1   >>1 相当于/2  这种写法比 int mid =(L+R)/2 好，因为 L+R 可能会溢出
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
