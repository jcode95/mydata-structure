package org.buptdavid.datastructure.zj.刷;

/**
 * @author jiezhou
 * @CalssName: Main3
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 二分
 * @date 2020/7/30/17:35
 */
public class Main3 {

    public static void main(String[] args) {


    }

    // 6 7  0 1 2 4 5
    public static int process(int[] a, int low, int high) {
        if (low == high)
            return a[low];

        int middle = (low + high) / 2;
        while (low<high){
            if (a[middle] < a[high]) {
                //在左边
                process(a, low, middle - 1);

            } else {
                //在右边
                process(a, middle + 1, high);
            }
        }
        return a[low];

    }
}
