package org.buptdavid.datastructure.zj.zuo_shen.sort;

import org.buptdavid.datastructure.comm.ArrayUtils;

/**
 * 选择排序：每次从剩余未排序的元素中选择最小的元素，与当前位置进行交换
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] array = ArrayUtils.generateArray(5, 100); // 生成随机数组

        for (int i = 0; i < array.length; i++) { // 外层循环控制当前需要排序的位置
            int minIndex = i; // 记录当前最小元素的下标，初始化为当前位置
            for (int j = i + 1; j < array.length; j++) { // 内层循环从剩余未排序的元素中选择最小的元素
                if (array[j] <= array[minIndex]) { // 如果当前元素比最小元素还小
                    minIndex = j; // 更新最小元素的下标
                }
            }
            ArrayUtils.swap(array, i, minIndex); // 将当前位置与最小元素进行交换
        }
        ArrayUtils.print(array); // 输出排序后的数组
    }

}
