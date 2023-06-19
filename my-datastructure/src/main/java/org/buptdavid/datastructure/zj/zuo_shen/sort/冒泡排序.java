package org.buptdavid.datastructure.zj.zuo_shen.sort;

import org.buptdavid.datastructure.zj.ArrayUtils;

/**
 * 冒泡排序：每次通过对相邻两个元素进行比较和交换，将待排序序列中的最大(或最小)元素逐个沉淀到序列底部
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] array = ArrayUtils.generateArray(5, 100); // 生成随机数组

        for (int e = array.length - 1; e > 0; e--) { // 外层循环控制冒泡的次数
            for (int j = 0; j < e; j++) { // 内层循环从头开始扫描待排序元素，将相邻的两个元素进行比较和交换
                if (array[j] >= array[j + 1]) { // 如果前一个元素大于等于后一个元素
                    ArrayUtils.swap(array, j, j + 1); // 将这两个元素进行交换
                }
            }
        }
        ArrayUtils.print(array); // 输出排序后的数组
    }
}
