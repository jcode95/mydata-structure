package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sort;

/**
 * @author jiezhou
 * @CalssName: RidexSort
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.sort
 * @Description: 基数排序 可以说是桶排序(空间换时间,数据量太大了会抛出内存溢出异常) 稳定的
 *
 * 注意1、数据量太大了会抛出内存溢出异常
 *      2、数组里面有负数当前代码需要处理一下负数,否则会报错
 * @date 2020/8/18/16:01
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{53, 3, 4, 746, 0, 8, 90,0};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));


        long s = System.currentTimeMillis();
        int[] arr=new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            int v = (int) (Math.random() * 8000000);
            arr[i]=v;
        }
        sort(arr);
        long s1 = System.currentTimeMillis();
        System.out.println((s1-s)/1000);
    }


    public static void sort(int[] arr) {
        /*1、定义一个二维数组来表示10个桶*/
        int[][] bucket = new int[10][arr.length];
        int[] recoud = new int[10];//记录每个桶中存放的有效数据的个数，下标对应桶的下标
        int x = 10;
        int y = 1;
        while (true) {
            boolean flg = true;
            for (int j = 0; j < arr.length; j++) {
                int k = arr[j] % x;
                k = k / y;
                //放入桶中
                bucket[k][recoud[k]] = arr[j];
                recoud[k]++;//把当前这个值++
                if (k != 0) {
                    flg = false;
                }
            }
            if (flg) {
                break;
            }
            x *= 10;
            y *= 10;
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                int[] r = bucket[i];
                if (recoud[i] > 0) {//有数据
                    for (int l = 0; l < recoud[i]; l++) {
                        arr[index] = r[l];
                        index++;
                    }
                }
            }
            //清空recoud数组和bucket数组
            for (int i = 0; i < recoud.length; i++) {
                recoud[i] = 0;
            }
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < bucket[i].length; j++) {
                    bucket[i][j] = 0;
                }
            }
        }
    }
}
