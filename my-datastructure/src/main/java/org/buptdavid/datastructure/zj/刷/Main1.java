package org.buptdavid.datastructure.zj.刷;

import scala.Int;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiezhou
 * @CalssName: Main1
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description:
 * @date 2020/7/24/15:45
 */

/*
* 题目描述
给定整数m以及n各数字A1,A2,..An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果，请求出这些结果中大于m的有多少个。
输入描述:
第一行包含两个整数n,m.

第二行给出n个整数A1，A2，...，An。

数据范围

对于30%的数据，1 <= n, m <= 1000

对于100%的数据，1 <= n, m, Ai <= 10^5
输出描述:
输出仅包括一行，即所求的答案


.位异或运算（^）

运算规则是：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
*
* */
public class Main1 {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch cd = new CountDownLatch(10);
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int result = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            if (arr.length < 10 && arr.length % 10 != 0) {
                System.out.println(count.intValue());
                return;
            }
            int var = 10;
            for (int i = 0; i < var; i++) {
                if (arr.length % 10 != 0) {
                    var += 1;
                }
                int[] ints = new int[arr.length / 10];
                for (int j = 0; j < ints.length; j++) {
                    ints[j] = arr[j + ints.length * i];
                }
                service.execute(new Process(ints, m, cd));


            }
            try {
                cd.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
    }

    static class Process implements Runnable {
        int m;
        int[] arr;
        CountDownLatch cd;

        Process(int[] arr, int m, CountDownLatch cd) {
            this.m = m;
            this.arr = arr;
            this.cd = cd;
        }

        @Override
        public void run() {
            try {
                cd.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
            process(arr, m);
        }
    }

    private static void process(int[] arr, int m) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int var = arr[i] ^ arr[j];
                if (var > m) {
                    count.incrementAndGet();
                }
            }
        }
    }


}
