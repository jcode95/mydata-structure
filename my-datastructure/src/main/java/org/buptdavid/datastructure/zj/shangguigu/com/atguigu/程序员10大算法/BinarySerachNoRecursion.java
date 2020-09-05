package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法;

/**
 * @author jiezhou
 * @CalssName: BinarySortNoRecursion
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法
 * @Description: 二分查找非递归算法
 * @date 2020/8/31/16:35
 */
public class BinarySerachNoRecursion {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int searchIndex = search(arr, 1);
        System.out.println(searchIndex);
    }

    /**
     * @param arr 原数组
     * @param v   目标值
     * @return
     */
    public static int search(int[] arr, int v) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == v) {
                return mid;
            } else if (arr[mid] > v) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;//找不到
    }
}
