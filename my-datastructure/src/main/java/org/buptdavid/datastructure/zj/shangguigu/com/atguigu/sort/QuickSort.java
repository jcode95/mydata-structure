package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sort;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: QuickSort
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.sort
 * @Description: 快速排序
 * @date 2020/8/18/10:20
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr1 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0, -1};
//        int[] arr1 = {8, 8, 1, 7, 2};
        sort1(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
        /*long s = System.currentTimeMillis();
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            int v = (int) (Math.random() * 80000000);
            arr[i] = v;
        }
        sort(arr, 0, arr.length - 1);
        long s1 = System.currentTimeMillis();
        System.out.println((s1 - s) / 1000);*/
    }


    /**
     * 找个基准值c，比c小的放左边，大的放右边，然后在左边和右边分别重复此步骤，直到只有一个元素停止
     *
     * @param arr        原数组
     * @param startIndex 开始下标
     * @param endIndex   结束下标
     */
    public static void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int ciIndex = (endIndex + startIndex) / 2;
        int pivot = arr[ciIndex];
        int i = startIndex;
        int j = endIndex;
        int tmp = 0;
        while (i < j) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] >= pivot) {
                j--;
            }
            if (i >= j) {//左边全部小于pivot，右边全部大于pivot，退出
                break;
            }
            //交换
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        if (i == j) {
            i++;
            j--;
        }
        sort(arr, startIndex, j);//左边
        sort(arr, i, endIndex);//右边
    }


    public static void sort1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //获取基准数
        int midIndex = (left + right) / 2;
        int midV = arr[midIndex];
        int l = left;
        int r = right;

        while (l < r) {
            while (arr[l] < midV) {
                l++;
            }
            while (arr[r] > midV) {
                r--;
            }
            if (l >= r) {
                break;
            }
            //交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == midV) {
                r--;
            }
            if (arr[r] == midV) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        //左边
        sort1(arr,left,r);
        //右边
        sort1(arr,l,right);
    }
}
