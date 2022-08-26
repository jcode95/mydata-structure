package org.buptdavid.datastructure.zj.zuo_shen;


import org.buptdavid.datastructure.zj.ArrayUtils;

import java.util.Arrays;

/**
 * @author root
 * @CalssName: 小顶堆案例
 * @Package org.buptdavid.datastructure.zj.zuo_shen
 * @Description:
 * @date 2022/8/25/20:18
 */
public class 小顶堆案例 {

    public static void main(String[] args) {

//        int[] arr = ArrayUtils.generateArray(6, 10);
        int[] arr = {1, 2, 3, 1, 4, 5, 4};
        System.out.println("arr = " + Arrays.toString(arr));
        minHeap(arr, 3);
        System.out.println("arr = " + Arrays.toString(arr));
    }


    /**
     * 已知一个几乎有序的数组，把数组排好顺序的话，每个元素移动的距离一定不超过k，并且k相对于数组长度来说比较小
     */

    /**
     * @param arr
     * @param k   最多移动距离
     */
    public static void minHeap(int[] arr, int k) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, k);
        }
        int c = 0;
        int i = 1;
        while (i < arr.length) {
            heapifyV2(arr, c, i, k);
            c++;
            i++;
        }

    }

    private static void heapifyV2(int[] arr, int skip, int i, int k) {
        int left = (int) ((1 / 2.0 + skip / 2.0) * 2 + 1);
        int length = i + k;
        if (length > arr.length) {
            length = arr.length;
        }
        while (left >= 0 && left < length) {
            if (left + 1 < length && left + 1 <= arr.length - 1 && arr[left] > arr[left + 1]) {
                //找最小的左右节点
                left++;
            }
            if (arr[left] <= arr[i]) {
                ArrayUtils.swap(arr, left, i);
                if (left == arr.length - 1) break;//到达最后一个，可退出
                i = left;
                left = (i - skip) * 2 + 1;
            } else {
                break;
            }
        }


    }

    /**
     * 构建小顶堆
     *
     * @param arr
     * @param i
     * @param k
     */
    public static void heapify(int[] arr, int i, int k) {
        int left = i * 2 + 1;
        int length = i + k;
        if (length > arr.length) {
            length = arr.length;
        }
        while (left < length) {
            if (left + 1 < length && left + 1 < arr.length - 1 && arr[left] > arr[left + 1]) {
                //找最小的左右节点
                left++;
            }
            if (arr[left] < arr[i]) {
                ArrayUtils.swap(arr, left, i);
                i = left;
                left = i * 2 + 1;
            } else {
                break;
            }
        }
    }
}
