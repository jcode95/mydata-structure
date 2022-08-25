package org.buptdavid.datastructure.zj.zuo_shen;

import org.buptdavid.datastructure.zj.ArrayUtils;

import java.util.Arrays;

/**
 * @author root
 * @CalssName: 大顶堆
 * @Package org.buptdavid.datastructure.zj.zuo_shen
 * @Description:
 * @date 2022/8/25/15:24
 */
public class 大顶堆 {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateArray(10, 100);
        System.out.println("原数组： " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {//从数组第一个数开始构建大顶堆
            buildMaxHeap(arr, i, arr.length);
        }
        System.out.println("构建之后数组： " + Arrays.toString(arr));
        //堆排序
        heapSort(arr);
        System.out.println("排序之后数组： " + Arrays.toString(arr));


    }

    /**
     * 参照左神堆排序思想写的代码
     * @param arr
     */
    private static void heapSort(int[] arr) {
        //首先吧整个数组构建为大顶堆
        for (int i = 0; i < arr.length; i++) {//从数组第一个数开始构建大顶堆
            buildMaxHeap(arr, i, arr.length);
        }
        //再去掉最大值，继续吧剩下的构建大顶堆，直到完成
        int heapSize = arr.length;
        while (heapSize > 0) {
            ArrayUtils.swap(arr, 0, --heapSize);
            for (int i = 0; i < heapSize; i++) {//从数组第一个数开始构建大顶堆
                buildMaxHeap(arr, i, heapSize);
            }
        }
    }

    /**
     * 构建一个大顶堆
     *
     * @param arr
     * @param index
     */
    public static void buildMaxHeap(int[] arr, int index, int heapSize) {
        if (index > heapSize || index < 0) {
            return;
        }
        //用当前节点与父节点比较 父节点下标（index-1）/2
        if ((index - 1) / 2 >= 0 && arr[index] > arr[(index - 1) / 2]) {
            //如果大，需要交换，继续找父节点的父节点
            ArrayUtils.swap(arr, index, (index - 1) / 2);
            buildMaxHeap(arr, (index - 1) / 2, heapSize);
        }
    }
}
