package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sort;

/**
 * @author jiezhou
 * @CalssName: DubbleSort
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.sort
 * @Description: 冒泡排序  O(n^2)
 * @date 2020/8/15/15:09
 */
public class DubbleSort {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = {3, -10, 4, 20, 5, 8, 10, 23};
        sort(arr);
        list(arr);
        System.out.println("循环次数：" + count);
       /* long s = System.currentTimeMillis();
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            int v = (int) (Math.random() * 80000);
            arr[i]=v;
        }
        sort(arr);
        long s1 = System.currentTimeMillis();
        System.out.println((s1-s)/1000);*/


    }

    private static void list(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr) {
        /*for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                count++;
                if (arr[i] > arr[k]) {
                    int tmp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = tmp;
                }
            }
        }*/
        /*{3, -10, 4, 20, 5, 8, 10, 23};*/
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flg = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    flg = false;
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
            if (flg) {
                return;
            }
        }

    }
}
