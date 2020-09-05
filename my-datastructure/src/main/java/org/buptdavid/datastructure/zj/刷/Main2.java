package org.buptdavid.datastructure.zj.刷;


/**
 * @author jiezhou
 * @CalssName: Main12
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description:
 * @date 2020/7/30/15:50
 * <p>
 * <p>
 * 求子数组最大值
 * <p>
 * arr[]{1,2,3,4,5}
 * max 15
 */
public class Main2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, -10, -4, -7, -2, -5};
        int max = maxAddSub(arr, 0, arr.length - 1);
        int process = process(arr);
        int var = GetSubMax(arr);
        System.out.println(max);
        System.out.println(process);

        System.out.println(var);
    }

    /**
     * 分治法
     * 思想：分三种情况 （从中间分开成两个数组）
     * 1、最大值在左边
     * <p>
     * 2、最大值在右边
     * <p>
     * <p>
     * 3、最大值中间，跨左右两个数组（先求）
     *
     * @param arr
     * @param form
     * @param to
     * @return
     */
    public static int maxAddSub(int[] arr, int form, int to) {
        if (form == to) {
            return arr[form];
        }
        int middle = (form + to) / 2;
        //1、最大值在左边
        int m1 = maxAddSub(arr, form, middle);
        //2、最大值在右边
        int m2 = maxAddSub(arr, middle + 1, to);

        //3、最大值中间，跨左右两个数组
        int i, left = arr[middle], now = arr[middle];
        for (i = middle - 1; i >= 0; i--) {
            now += arr[i];
            left = Math.max(now, left);
        }
        int right = arr[middle + 1];
        now = arr[middle + 1];
        for (i = middle + 2; i <= to; i++) {
            now += arr[i];
            right = Math.max(now, right);
        }
        int m3 = left + right;
        //去三个值的最大值即可
        return Math.max(Math.max(m1, m2), m3);
    }

    /**
     * 分析法  1 2 3 4 5
     * p[i]=15
     * min 1
     * 14
     *
     * @param arr
     * @return
     */
    public static int process(int[] arr) {
        int result = arr[0];
        int sum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            //max(sum+c, c)==max(sum,0)
            if (sum > 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            result = Math.max(sum, result);
        }
        return result;
    }

    public static int GetSubMax(int[] arr) {
        int max = 0, subSum = 0;
        for (int i = 0; i < arr.length; i++) {
            subSum = subSum > 0 ? subSum + arr[i] : arr[i];
            max = subSum > max ? subSum : max;
        }
        return max;
    }
}
