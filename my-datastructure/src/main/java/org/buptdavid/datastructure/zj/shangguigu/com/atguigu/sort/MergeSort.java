package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sort;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: MergetSort
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.sort
 * @Description: 归并排序 O(log~n)
 * @date 2020/8/18/14:55
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, -10, 4, 20, 5, 8, 10, 23};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));

       /* int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            int v = (int) (Math.random() * 80000000);
            arr[i] = v;
        }
        int[] temp = new int[arr.length];
        long s = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1, temp);
        long s1 = System.currentTimeMillis();
        System.out.println((s1 - s) / 1000);*/
    }


    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左分
            mergeSort(arr, left, mid, temp);
            //向右分
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);

        }

    }

    /**
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左边有序序列的初始索引
        int j = mid + 1;//右边有序序列的初始索引
        int t = 0;//指向temp数组当前索引

        //先把左右两边的数据合并
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        //吧temp数组的值填充到arr中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
