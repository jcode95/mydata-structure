package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: DichotomiaSearch
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.search
 * @Description: 二分查找
 * @date 2020/8/19/9:37
 */
public class DichotomiaSearch implements ISearch {
    @Override
    public int search(int[] arr, int value) {
        return dichotmia(arr, 0, arr.length - 1, value);
    }

    public int dichotmia(int[] arr, int left, int right, int value) {
        System.out.println("hello");
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {// value < arr[0] || value > arr[arr.length-1]提前退出，没有必要再执行了，提升效率
            return -1;
        }
        int mid = (left + right) / 2;
        if (value < arr[mid]) {
            return dichotmia(arr, left, mid - 1, value);
        } else if (value > arr[mid]) {
            return dichotmia(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }

    /**
     * 返回所有的找到的下标
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public List<Integer> dichotmia1(int[] arr, int left, int right, int value, ArrayList<Integer> ls) {
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {// value < arr[0] || value > arr[arr.length-1]提前退出，没有必要再执行了，提升效率
            return ls;
        }
        int mid = (left + right) / 2;
        if (value < arr[mid]) {
            dichotmia1(arr, left, mid - 1, value, ls);
        } else if (value > arr[mid]) {
            dichotmia1(arr, mid + 1, right, value, ls);
        } else {
            ls.add(mid);
            dichotmia1(arr, left, mid - 1, value, ls);//再次扫描左边
            dichotmia1(arr, mid + 1, right, value, ls);//再次扫描右边
        }
        return ls;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{-56, 1, 1, 2, 2, 2, 20, 25, 44, 47, 50, 56, 90};
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int i = new DichotomiaSearch().search(arr, 2);
        List<Integer> list = new DichotomiaSearch().dichotmia1(arr, 0, arr.length, 1, new ArrayList<Integer>());
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
    }
}
