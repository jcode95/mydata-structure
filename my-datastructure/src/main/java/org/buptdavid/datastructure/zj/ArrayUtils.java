package org.buptdavid.datastructure.zj;

import java.util.ArrayList;
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
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            integers.add(random.nextInt(randomLength));
        }
        int[] arr2 = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            arr2[i] = integers.get(i);
        }
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

}
