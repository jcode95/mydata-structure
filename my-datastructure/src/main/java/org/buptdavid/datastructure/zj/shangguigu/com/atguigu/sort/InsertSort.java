package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sort;

/**
 * @author jiezhou
 * @CalssName: InsertSort
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.sort
 * @Description: 插入排序 O(n^2)
 * @date 2020/8/17/12:19
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3, -10, -4, 20, 5, 8, 10, 23, 0};
        sort(arr);
        list(arr);

    }

    private static void list(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int tarIndex = 0;//初始下标
            while (tarIndex < i) {
                if (arr[i] < arr[tarIndex]) {
                    int tmp = arr[i];
                    arr[i] = arr[tarIndex];
                    arr[tarIndex] = tmp;
                }
                tarIndex++;
            }

        }


    }

    public static void sort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currValue = arr[i];//当前值
            int insertIndex = i - 1;//前一个值下标
            while (insertIndex >= 0 && currValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = currValue;
        }
    }
}
