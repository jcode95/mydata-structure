package org.buptdavid.datastructure.zj.zuo_shen;

import java.util.Arrays;

/**
 * @author root
 * @CalssName: ZuoShen_MergeSort
 * @Package org.buptdavid.datastructure.zj.zuo_shen
 * @Description:
 * @date 2022/8/16/16:35
 */
public class ZuoShen_MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 2};
        sort(arr, 0, arr.length - 1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        //求小和
        int[] arr2 = {1, 3, 4, 2, 5};
        int minSun = minSun(arr2, 0, arr2.length - 1);
        System.out.println("小和： = " + minSun);

    }

    public static void sort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
//        int mid = L + (R - L) >> 1;
        int mid = (R + L) / 2;
        //排左边
        sort(arr, L, mid);
        //排右边
        sort(arr, mid + 1, R);
        //合并
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int i = 0;//help 的下标
        int[] help = new int[R - L + 1];
        int l = L;
        int r = mid + 1;
        while (l <= mid && r <= R) {
            if (arr[l] <= arr[r]) {
                //填充help
                help[i] = arr[l];
                l++;
                i++;
            } else {
                //填充help
                help[i] = arr[r];
                r++;
                i++;
            }
        }
        //肯还存在 某一边还没有放完情况
        while (l <= L) {
            //填充help
            help[i] = arr[l];
            l++;
            i++;
        }
        while (r <= R) {
            //填充help
            help[i] = arr[r];
            r++;
            i++;
        }

        //填充arr数组
        int tempLeft = L;
        i = 0;
        while (tempLeft <= R) {
            arr[tempLeft] = help[i];
            i++;
            tempLeft++;
        }
    }

    //求小和
    public static int minSun(int[] arr, int L, int R) {
        if (L >= R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return minSun(arr, L, mid) + minSun(arr, mid + 1, R) + mergeMinSum(arr, L, mid, R);
    }

    //小和merge
    private static int mergeMinSum(int[] arr, int L, int mid, int R) {
        int result = 0;
        int i = 0;//help 的下标
        int[] help = new int[R - L + 1];
        int l = L;
        int r = mid + 1;
        while (l <= mid && r <= R) {
            //填充help
            result += arr[l] < arr[r] ? arr[l] * (R - r + 1) : 0;
            help[i++] = arr[l] < arr[r] ? arr[l++] : arr[r++];//如果相等，先处理右边的数
        }
        while (l <= mid) {
            help[i++] = arr[l++];
        }
        while (r <= R) {
            help[i++] = arr[r++];
        }

        //填充arr数组
        int indexL = L;
        for (int j = 0; j < help.length; j++) {
            arr[indexL++] = help[j];
        }


        return result;
    }


}
