package org.buptdavid.datastructure.zj.zuo_shen;

/**
 * @author root
 * @CalssName: 局部最小
 * @Package org.buptdavid.datastructure.zj.zuo_shen
 * @Description:
 * @date 2022/8/16/14:17
 */
public class 局部最小 {

    public static void main(String[] args) {

        int[] arr = {7, 6, 5, 4, 3, 2, 5, 4, 3, 2, 9};


        int i = process(arr, 0, arr.length - 1);
        System.out.println("i = " + i);

    }

    public static int process(int[] arr, int left, int right) {
        if (left < 0 || right > arr.length || left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int v = arr[mid];
        if ((mid - 1 < 0 ? true : arr[mid - 1] > v) && (mid + 1 > arr.length-1 ? true : arr[mid + 1] > v)) {
            //min v
            return mid;
        }
        int leftV = process(arr, left, mid - 1);
        if (leftV != -1) {
            return leftV;
        }

        int rightV = process(arr, mid + 1, right);
        if (rightV != -1) {
            return rightV;
        }
        return -1;
    }
}
