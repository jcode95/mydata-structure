package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sort;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: MergetSort
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.sort
 * @Description: 归并排序 O(nlog^n) 由 master 公式推出来
 * 分而治之的思想（分：就把大问题递归分解为小问题，治：把各个小问题合并得到原问题的解）
 * @date 2020/8/18/14:55
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, -10, 4, 20, 5, 8, 10, 23};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{3, -10, 4, 20, 5, 8, 10, 23};
        temp = new int[arr.length];
        sort1(arr, temp, 0, arr.length - 1);
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
            /*合并*/
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
            /*比较两边值大小，看谁小就放在另一个的前面*/
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
        /*以下两个while，就是防止出现一边的一个值太大，出现放不完的情况*/
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
        //最后，把temp数组的值填充到arr中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }


    public static void sort1(int[] arr, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort1(arr, tmp, left, mid);
        sort1(arr, tmp, mid + 1, right);
        merge1(arr, tmp, left, mid, right);
    }

    private static void merge1(int[] arr, int[] tmp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                tmp[k] = arr[j];
                j++;
                k++;
            } else {
                tmp[k] = arr[i];
                i++;
                k++;
            }
        }

        while (i <= mid) {
            tmp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= right) {
            tmp[k] = arr[j];
            j++;
            k++;
        }

        //把tmp填充到arr里面，并不是全部填充
        k = 0;
        int tempL = left;
        while (tempL <= right) {
            arr[tempL] = tmp[k];
            tempL++;
            k++;
        }
    }
}
