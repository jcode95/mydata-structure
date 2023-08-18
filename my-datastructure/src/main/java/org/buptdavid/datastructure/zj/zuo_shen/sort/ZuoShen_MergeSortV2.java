package org.buptdavid.datastructure.zj.zuo_shen.sort;

import org.buptdavid.datastructure.comm.ArrayUtils;

/**
 * @author zhoujie
 * @CalssName: ZuoShen_MergeSortV2
 * @Package org.buptdavid.datastructure.zj.zuo_shen.sort
 * @Description:归并排序 满足 matser 公式
 */
public class ZuoShen_MergeSortV2 {


    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateArray(10, 10);
        ArrayUtils.print(arr);
        sort(arr, 0, arr.length - 1);
        ArrayUtils.print(arr);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);

        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int e : help) {
            arr[l++] = e;
        }
    }

}
