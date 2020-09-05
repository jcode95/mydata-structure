package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sort;

/**
 * @author jiezhou
 * @CalssName: SelectSort
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.sort
 * @Description: 选择排序(最小的找出来放到前面)
 * @date 2020/8/15/16:32
 */
public class SelectSort {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            int v = (int) (Math.random() * 80000);
            arr[i]=v;
        }
//        int[] arr1 = {3, -10, 4, 20, 5, 8, 10, 23};
        sort1(arr, 0);
        long s1 = System.currentTimeMillis();
        System.out.println((s1-s)/1000);
//        list(arr1);
    }
    //数据太多会抛出栈太深异常
    private static void sort(int[] arr, int index) {
        if (index == arr.length - 1) {
            return;
        }
        int minIndex = index;
        int minValue = arr[index];
        for (int i = index; i < arr.length; i++) {
            if (minValue <= arr[i]) {
                minIndex = i;
                minValue = arr[i];
            }
        }
        //交换
        int tmp = arr[minIndex];
        arr[minIndex] = arr[index];
        arr[index] = tmp;


        sort(arr, ++index);
    }
    private static void sort1(int[] arr, int index) {
        if (index == arr.length - 1) {
            return;
        }
        while (index<arr.length){
            int minIndex = index;
            int minValue = arr[index];
            for (int i = index; i < arr.length; i++) {
                if (minValue <= arr[i]) {
                    minIndex = i;
                    minValue = arr[i];
                }
            }
            //交换
            int tmp = arr[minIndex];
            arr[minIndex] = arr[index];
            arr[index] = tmp;
            index++;
        }
    }

    private static void list(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
