package org.buptdavid.datastructure.zj;

import java.util.Arrays;
import java.util.Random;

/**
 * @author root
 * @CalssName: ArrayUtiles
 * @Package org.buptdavid.datastructure.zj
 * @Description: 数组工具类
 * @date 2022/8/25/15:24
 */
public class ArrayUtils {
    static Random random = new Random();

    /**
     * 生成无序数组
     *
     * @return
     */
    public static int[] generateArray(int length, int randomLength) {
        int[] arr2 = new int[length];
        for (int i = 0; i < length; i++) {
            arr2[i] = random.nextInt(randomLength);
        }
        System.out.println("生成的原始数组 = " + Arrays.toString(arr2));
        return arr2;
    }

    /**
     * @return
     */
    public static void swap(int[] arr, int i, int j) {
        //交换
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void print(int[] arr){
        String s = Arrays.toString(arr);
        System.out.println("arr = " + s);
    }

}
