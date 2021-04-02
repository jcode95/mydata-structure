package org.buptdavid.datastructure.zj;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: Demo51
 * @Package org.buptdavid.datastructure.zj
 * @Description:
 * @date 2021/3/14/3:34
 */
public class Demo51 {

    public static void main(String[] args) {
        Object o = new Object();

        Thread a = new Thread() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        Thread.sleep(6000);
                        o.wait();//一直阻塞，不会执行下面的代码，除非其他线程调用到notify/notifyAll,才会执行下面的方法
                        o.notifyAll();//所以在这里执行这个方法没有用
                        System.out.println("cccccccccc");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread b = new Thread() {
            @Override
            public void run() {
                synchronized (o) {
                    System.out.println("==============");
                    try {
                        o.notifyAll();
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        a.setName("tA");
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.setName("tB");
        b.start();


    }

    static class MergeSort1 {
        public static void main(String[] args) {
            int[] arr = new int[]{3, -10, 88, 20, 44, 8, 56, 23};
            int[] temp = new int[arr.length];
            sort(arr, 0, arr.length - 1, temp);
            System.out.println(Arrays.toString(arr));
        }

        private static void sort(int[] arr, int left, int right, int[] temp) {
            if (left >= right) {
                return;
            }

            int mid = (left + right) / 2;
            //左边
            sort(arr, left, mid, temp);
            //右边
            sort(arr, mid + 1, right, temp);
            //合并
            merge1(arr, left, mid, right, temp);
        }

        private static void merge1(int[] arr, int left, int mid, int right, int[] temp) {
            int t = 0;
            int i = left;//左边的最小下标
            int j = mid + 1;//右边的最小下标
            //从小到大顺序放入temp数组
            while (i <= mid && j <= right) {
                if (arr[i] >= arr[j]) {
                    temp[t] = arr[j];
                    t++;
                    j++;
                } else {
                    temp[t] = arr[i];
                    t++;
                    i++;
                }
            }

            //处理一边太大，处理不完全的情况
            while (i <= mid) {
                temp[t] = arr[i];
                t++;
                i++;
            }
            while (j <= right) {
                temp[t] = arr[j];
                t++;
                j++;
            }

            //吧temp填充到arr数组
            t = 0;
            int i1 = left;
            while (i1 <= right) {
                arr[i1] = temp[t];
                t++;
                i1++;
            }
        }
    }


}
