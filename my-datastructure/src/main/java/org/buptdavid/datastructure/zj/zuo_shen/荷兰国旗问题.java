package org.buptdavid.datastructure.zj.zuo_shen;

import java.util.Arrays;

/**
 * @author root
 * @CalssName: 荷兰国旗问题
 * @Package org.buptdavid.datastructure.zj.zuo_shen
 * @Description:
 * @date 2022/8/22/15:52
 */
public class 荷兰国旗问题 {
    /**
     * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。要求额外空间复杂度O(1）,时间复杂度 O(N）
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {6, 3, 2, 7, 1, 5, 4};

        process(arr, 4);
        System.out.println("arr = " + Arrays.toString(arr));
        int[] arr2 = {2, 4, 4, 6, 1, 7, 4, 2};
        process2(arr2, 4);
        System.out.println("arr = " + Arrays.toString(arr2));
    }

    /**
     * 小于num的放左边，大于num放右边，不要求有序 时间复杂度 O(n) 空间复杂度O(1)
     *
     * @param arr
     * @param num
     */
    public static void process(int[] arr, int num) {
        int left = -1;//小于区域的边界
        int i = 0;//遍历数组的下标
        while (i <= arr.length - 1) {
            if (arr[i] <= num) {
                //i 跳到下一个.判断i位置的数是否比num小，小就让小于区域的下一个数和此值交换，然后小于区域右扩一位
                swep(arr, left + 1, i);
                left++;
            }
            i++;
        }
    }

    private static void swep(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 荷兰国旗问题 切分数组
     * 小于num的放左边，等于放中间，大于num放右边，不要求有序 时间复杂度 O(n) 空间复杂度O(1)
     *
     * @param arr
     * @param num
     */
    public static void process2(int[] arr, int num) {
        int left = -1;//小于区域的右边界
        int right = arr.length;//大于区域的左边界
        int i = 0;//遍历数组的下标
        while (i <= arr.length - 1) {
            if (i >= right) {
                break;
            }
            if (arr[i] < num) {
                //i 跳到下一个.判断i位置的数是否比num小，小就让小于区域的下一个数和此值交换，然后小于区域右扩一位
                swep(arr, left + 1, i);
                left++;
                i++;
            } else if (arr[i] > num) {
                swep(arr, right - 1, i);
                right--;
            } else if (arr[i] == num) {
                i++;
            }

        }
    }
}
