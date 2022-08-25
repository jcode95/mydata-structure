package org.buptdavid.datastructure.zj.zuo_shen;

import org.buptdavid.datastructure.zj.ArrayUtils;

import java.util.Arrays;

/**
 * @author root
 * @CalssName: 大顶堆
 * @Package org.buptdavid.datastructure.zj.zuo_shen
 * @Description:O(nlogn)
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
     *
     * @param arr
     */
    private static void heapSort(int[] arr) {
        //首先吧整个数组构建为大顶堆
//        for (int i = 0; i < arr.length; i++) {//从数组第一个数开始构建大顶堆
//            buildMaxHeap(arr, i, arr.length);
//        }
        //上面的for循环可优化,之前是对每个节点处理，现在是只对非叶子节点堆化处理即可
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }


        //再去掉最大值，继续吧剩下的构建大顶堆，直到完成
        int heapSize = arr.length;
        ArrayUtils.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
//            maxHeap(arr, 0, heapSize);
            ArrayUtils.swap(arr, 0, heapSize - 1);
            heapSize--;
        }
    }

    /**
     * 该方法其实就是  maxHeap 方法的变换而已
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            if (left + 1 < heapSize && arr[left] < arr[left + 1]) {
                left++;
            }
            if (arr[index] < arr[left]) {
                ArrayUtils.swap(arr, index, left);
                index = left;
                left = index * 2 + 1;//获取index 的左节点
            } else {
                break;
            }
        }
    }

    public static void maxHeap(int[] arr, int i, int length) {
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {//j = i * 2 + 1 得到左节点在数组里面的下标 j+1就是右子节点的下标
            //找当前节点的左右节点，找出最大的节点的i
            if (j + 1 < length && arr[j] < arr[j + 1]) {//左节点小于右节点
                j++;//让j指向右节点
            }
            if (arr[j] > arr[i]) {//如果当前节点小于左右子节点，就让最大的一个左右节点与当前i节点交换数据
                ArrayUtils.swap(arr, i, j);
                i = j;//交换完之后，再判断左or右节点的树是否为大顶堆，如果不是继续处理成大顶堆，直到break
            } else {
                break;
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
