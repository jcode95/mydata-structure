package org.buptdavid.datastructure.zj.zuo_shen.sort;

import org.buptdavid.datastructure.zj.ArrayUtils;

import java.util.Arrays;

/**
 * @author root
 * @CalssName: ZuoShen_RadixSort
 * @Package org.buptdavid.datastructure.zj.zuo_shen
 * @Description: 基数排序（桶排序 负数情况没有处理）
 * @date 2022/8/29/18:13
 */
public class ZuoShen_RadixSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateArray(10,100000);
//        int digitValue = getDigitValue(-36, 1);
//        System.out.println("digitValue = " + digitValue);
        sort(arr);
        System.out.println(Arrays.toString(arr));


//        long s = System.currentTimeMillis();
//        int[] arr=new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            int v = (int) (Math.random() * 8000000);
//            arr[i]=v;
//        }
//        sort(arr);
//        long s1 = System.currentTimeMillis();
//        System.out.println(" 花费时间："+(s1-s)/1000+" s");

    }

    public static void sort(int[] arr) {
        int[] count = new int[10];


        int[] help = new int[arr.length];

        int maxDigit = getMaxDigit(arr);
        System.out.println("maxDigit = " + maxDigit);
        for (int i = 1; i <= maxDigit; i++) {
            for (int value : arr) {
                int digitValue = getDigitValue(value, i);
                count[digitValue]++;//当前的这个计数
            }
            //count吧当前位置的数加上前面的数,构造count 数组
            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }
//            System.out.println(Arrays.toString(count));

            //构造help 数组，从右到左

            for (int j = arr.length - 1; j >= 0; j--) {
                int var = arr[j];
                int index = getDigitValue(var, i);
                help[count[index] - 1] = var;
                //count 数组--
                count[index]--;
            }
            for (int k = 0; k < help.length; k++) {
                arr[k] = help[k];
            }
            count = new int[10];
            help = new int[arr.length];

        }
    }

    /**
     * 获取数组里面最大的数的位数
     *
     * @param arr
     * @return
     */
    public static int getMaxDigit(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(getDigit(i), max);
        }
        return max;
    }

    /**
     * 获取一个数的位数
     *
     * @param value
     * @return
     */
    public static int getDigit(int value) {
        int count = 0;
        while (value != 0) {
            count++;
            value = value / 10;
        }
        return count;
    }

    /**
     * 获取一个数的对应的位数  左到右 1 开始
     *
     * @param value
     * @param digit
     * @return
     */
    public static int getDigitValue(int value, int digit) {
        if (digit <= 0) {
            throw new RuntimeException("digit  error " + digit);
        }
        return (value % power(10, digit)) / power(10, digit - 1);

    }

    /**
     * 位运算求a 的p次方
     *
     * @param a
     * @param p
     * @return
     */
    public static int power(int a, int p) {
        int res = 1;
        while (p != 0) {
            if ((p & 1) == 1) {
                res = res * a;
            }
            p >>= 1;
            a = a * a;
        }
        return res;
    }
}
