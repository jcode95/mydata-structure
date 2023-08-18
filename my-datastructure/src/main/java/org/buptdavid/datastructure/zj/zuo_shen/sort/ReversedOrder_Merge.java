package org.buptdavid.datastructure.zj.zuo_shen.sort;

import org.buptdavid.datastructure.comm.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoujie
 * @CalssName: ReverOrder_Merge
 * @Package org.buptdavid.datastructure.zj.zuo_shen.sort
 * @Description:打印所有逆序对 使用 mere sort (归并排序思想)
 */
public class ReversedOrder_Merge {
    public static void main(String[] args) {
//        int[] arr = ArrayUtils.generateArray(10, 10);
        int[] arr = {2, 3, 8, 6, 1, 4};
        List<int[]> res = new ArrayList<>();
        process(arr, 0, arr.length - 1, res);
        ArrayUtils.print(arr);
        for (int[] ints : res) {
            System.out.println(ints[0] + " " + ints[1]);
        }

    }

    private static void process(int[] arr, int l, int r, List<int[]> res) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid, res);
        process(arr, mid + 1, r, res);
        List<int[]> merge = merge(arr, l, mid, r, res);
        res.addAll(merge);
    }

    private static List<int[]> merge(int[] arr, int l, int mid, int r, List<int[]> res) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
                for (int j = p1; j <= mid; j++) {
                    int[] pair = {j, p2 - 1};
                    res.add(pair);
                }
            }
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
        return res;
    }

}
