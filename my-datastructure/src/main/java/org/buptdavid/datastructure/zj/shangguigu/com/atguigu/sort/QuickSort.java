package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sort;

import org.buptdavid.datastructure.zj.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jiezhou
 * @CalssName: QuickSort
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.sort
 * @Description: 快速排序  O (nlogn)  找个基准值c，比c小的放左边，大的放右边，然后在左边和右边分别重复此步骤，直到只有一个元素停止
 * @date 2020/8/18/10:20
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] arr1 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0, -1};
        int[] arr1 = {8, 8, 8, 7, 2, 3, 4, 4, 4, 0, -1};
        arr1 = ArrayUtils.generateArray(20, 10);
//        int[] arr1 = {8, 8, 1, 7, 2};
//        quickSort(arr1, 0, arr1.length - 1);
//        sort(arr1, 0, arr1.length - 1);
//        sort1(arr1, 0, arr1.length - 1);
//        sort1(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
        /*long s = System.currentTimeMillis();
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            int v = (int) (Math.random() * 80000000);
            arr[i] = v;
        }
        sort(arr, 0, arr.length - 1);
        long s1 = System.currentTimeMillis();
        System.out.println((s1 - s) / 1000);*/

        quickSort3(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 韩老师代码
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }


    }

    /**
     * 找个基准值c，比c小的放左边，大的放右边，然后在左边和右边分别重复此步骤，直到只有一个元素停止
     *
     * @param arr        原数组
     * @param startIndex 开始下标
     * @param endIndex   结束下标
     */
    public static void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int ciIndex = (endIndex + startIndex) / 2;
        int pivot = arr[ciIndex];
        int i = startIndex;
        int j = endIndex;
        int tmp = 0;
        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i >= j) {//左边全部小于pivot，右边全部大于pivot，退出
                break;
            }
            //交换
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            if (arr[i] == pivot) {
                j--;
            }
            if (arr[j] == pivot) {
                i++;
            }

        }
        if (i == j) {
            i++;
            j--;
        }
        if (startIndex < i)
            sort(arr, startIndex, j);//左边
        if (endIndex > j)
            sort(arr, i, endIndex);//右边
    }


    public static void sort1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //获取基准数
        int midIndex = (left + right) / 2;
        int midV = arr[midIndex];
        int l = left;
        int r = right;

        while (l < r) {
            while (arr[l] < midV) {
                l++;
            }
            while (arr[r] > midV) {
                r--;
            }
            if (l >= r) {
                break;
            }
            //交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == midV) {
                r--;
            }
            if (arr[r] == midV) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        //左边
        if (left < l)
            sort1(arr, left, r);
        //右边
        if (right > r)
            sort1(arr, l, right);
    }


    public static void sort2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middIndex = (left + right) / 2;
        int povid = arr[middIndex];
        int l = left;
        int r = right;
        while (l < r) {
            while (arr[l] < povid) {
                l++;
            }
            while (arr[r] > povid) {
                r--;
            }
            if (l >= r) {
                break;
            }

            //交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == povid) {
                r--;
            }
            if (arr[r] == povid) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < l)
            sort2(arr, left, r);
        if (right > r)
            sort2(arr, l, right);
    }


    /**
     * 左神--快排 思路
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void quickSort3(int[] arr, int L, int R) {
        if (L < R) {
            int[] p = partition(arr, L, R);
            quickSort3(arr, L, p[0]);
            quickSort3(arr, p[1], R);
        }
    }

    /**
     * @param arr
     * @param left
     * @param right
     */
    public static int[] partition(int[] arr, int left, int right) {//其实就是荷兰国旗问题
        int leftIndex = left - 1;//右边界
        int rightIndex = right + 1;//右边界
        int mid = left + ((right - left) >> 1);
        swap(arr, mid, right);
        int midV = arr[right];//基准值
        int curr = left;
        while (curr < right) {
            if (curr >= rightIndex) {
                //i与有边界碰撞，结束
                break;
            }
            if (arr[curr] < midV) {
                swap(arr, leftIndex + 1, curr);
                leftIndex++;
                curr++;
            } else if (arr[curr] > midV) {
                swap(arr, rightIndex - 1, curr);
                rightIndex--;
            } else if (arr[curr] == midV) {
                curr++;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }

    public static void swap(int[] arr, int l, int r) {
        //交换
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
