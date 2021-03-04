package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.search;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: FibonacciSearch
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.search
 * @Description: 斐波那契数列查找算法(黄金分割查找算法)
 * @date 2020/8/19/14:16
 */
public class FibonacciSearch implements ISearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
//        int[] arr = new int[]{-56, 1, 1, 2, 2, 2, 20, 25, 44, 47, 50, 56, 90};
        int i = new FibonacciSearch().search(arr, 3);
        System.out.println(i);
    }


    @Override
    public int search(int[] arr, int value) {
        if (arr == null && arr.length == 0) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int[] F = createFibonacci(20);//创建一个斐波那契数组
        //计算arr.length位于斐波那契数列的位置
        while (arr.length > F[k] ) {
            k++;
        }
        //创建一个temp的新数组长度为  F[k] - 1，并且吧arr里面的值放到temp里面，后面不足的补上arr[arr.length-1]的值构成一个有序数组
        int[] temp = Arrays.copyOf(arr, F[k]);
        //把temp后面补齐
        for (int i = arr.length; i < F[k]; i++) {
            temp[i] = arr[arr.length - 1];
        }

        //操作的时候就用temp来操作
        while (left <= right) {
            int mid = left + F[k - 1] - 1;//存放mid值
            if (temp[mid] > value) {
                right = mid - 1;
                k -= 1;              //F[k-1]=F[k-1-1]+F[k-2-1]=F[k-2]+F[k-3],F[k-1]-->F[k-2]，看分解后的第一个 k要-1
            } else if (temp[mid] < value) {
                left = mid + 1;
                k -= 2; //F[k-1]=F[k-1-1]+F[k-2-1]=F[k-2]+F[k-3],F[k-1]-->F[k-3]  看分解后的第二个 k要-2
            } else {//找到了
                if (mid > arr.length - 1) {
                    return arr.length - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 创建斐波那契数列来辅助查找
     *
     * @param i
     * @return
     */
    private int[] createFibonacci(int i) {
        int[] F = new int[i];
        F[0] = 1;
        F[1] = 1;
        for (int j = 2; j < i; j++) {
            F[j] = F[j - 1] + F[j - 2];
        }
        return F;
    }
}
