package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree;

import org.buptdavid.datastructure.zj.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author jiezhou
 * @CalssName: HeapSort
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.tree
 * @Description: 堆排序
 * @date 2020/8/22/10:22
 */
public class HeapSortTest {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 8, 5, 9};
        HeapSortTest test = new HeapSortTest();
        int[] arr2 = ArrayUtils.generateArray(50, 100);
        test.maxHeap(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /*
     *  arr.length / 2 - 1   从右到左，从下到上第一个不是叶子节点的节点对应数组的下标
     * */
    public void maxHeap(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {//这个循环：有几个非叶子节点
            this.maxHeap(arr, i, arr.length);
        }
        //由于做的是升序，吧最后一个与第一个交换位置。然后再对除去交换的后一剩下的再做大顶堆
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            maxHeap(arr, 0, j);
        }

    }

    /**
     * 通过arr数组构建大顶堆，长度到数组的length
     *
     * @param arr
     * @param i      从右到左（视频里面说左到右是错误的），从下到上第一个不是叶子节点的节点对应数组的下标 ，
     * @param length 当前要排序的长度 构建大顶堆的长度（数组length 长度之前构建大顶堆，后面的不用构建）
     */
    public void maxHeap(int[] arr, int i, int length) {

        int temp = arr[i];//当前节点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {//j = i * 2 + 1 得到左节点在数组里面的下标 j+1就是右子节点的下标
            //找当前节点的左右节点，找出最大的节点的i
            if (j + 1 < length && arr[j] < arr[j + 1]) {//左节点小于右节点
                j++;//让j指向右节点
            }
            if (arr[j] > temp) {//如果当前节点小于左右子节点，就让最大的一个左右节点与当前i节点交换数据
                arr[i] = arr[j];
                arr[j] = temp;
                i = j;//交换完之后，再判断左or右节点的树是否为大顶堆，如果不是继续处理成大顶堆，直到break
            } else {
                break;
            }
        }
//        arr[i] = temp; 这里不需要这一行是因为我在比较的时候就交换了，韩老师代码是最后比较的时候并没有都交换，所以他放到最后才交换temp 的值
    }
}
