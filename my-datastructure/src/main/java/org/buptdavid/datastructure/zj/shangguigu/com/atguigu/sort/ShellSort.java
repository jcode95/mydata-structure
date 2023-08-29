package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sort;

import org.buptdavid.datastructure.comm.ArrayUtils;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: ShellSort
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.sort
 * @Description: 希尔排序(分组+插入排序)
 * @date 2020/8/17/15:55
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = ArrayUtils.generateArray(10, 8);
        sort3(array);
        System.out.println(Arrays.toString(array));
        /*long s = System.currentTimeMillis();
        int[] arr=new int[800000];
        for (int i = 0; i < 800000; i++) {
            int v = (int) (Math.random() * 800000);
            arr[i]=v;
        }
        sort1(arr);
        long s1 = System.currentTimeMillis();
        System.out.println((s1-s)/1000);*/


    }

    /**
     * 比较交换
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        int st = 2;//初始化就是除以2
        while (true) {
            int goup = arr.length / st;
            if (goup <= 0) {
                break;
            }
            System.out.println("----------" + goup + "-------------");
            for (int i = goup; i < arr.length; i++) {
                for (int j = i - goup; j >= 0; j -= goup) {
                    if (arr[j] > arr[j + goup]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + goup];
                        arr[j + goup] = tmp;
                    }
                }
                System.out.println(Arrays.toString(arr));
            }

            st = st * 2;
        }

    }

    /**
     * 比较交换
     *
     * @param arr
     */
    public static void sort1(int[] arr) {
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {//遍历组
            System.out.println("第 " + gap + " 组");
            for (int i = gap; i < length; i++) {//遍历每一组里面的数据
                int inserted = arr[i];
                int j;
                for (j = i - gap; j >= 0 && inserted < arr[j]; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = inserted;
            }
        }
    }

    /**
     * 移动法
     *
     * @param arr
     */
    public static void sort3(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {//遍历组
            for (int i = gap; i < arr.length; i++) {//遍历每一组里面的数据
                int currValue = arr[i];//当前值
                int tarIndex = i - gap;//前一个值
                while (tarIndex >= 0 && currValue < arr[tarIndex]) {//插入法（插入排序的核心思想）
                    arr[tarIndex + gap] = arr[tarIndex];
                    tarIndex -= gap;
                }
//                arr[tarIndex + gap] = currValue;
                if (i != tarIndex + gap) {//优化
                    arr[tarIndex + gap] = currValue;
                }

            }
        }
    }
}
