package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.search;

/**
 * @author jiezhou
 * @CalssName: InsertValueSearch
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.search
 * @Description: 插值查找（二分法的改进 mid的改进）
 * @date 2020/8/19/10:18
 */
public class InsertValueSearch implements ISearch {
    @Override
    public int search(int[] arr, int value) {
        return insertValue(arr, value, 0, arr.length - 1);
    }

    public int insertValue(int[] arr, int findValue, int low, int hight) {
//        System.out.println("hello");
        if (low > hight || findValue < arr[0] || findValue > arr[arr.length - 1]) {// findValue < arr[0] || findValue > arr[arr.length-1]提前退出，没有必要再执行了，提升效率
            return -1;
        }
//        int mid = low + (hight - low) * (1/2);这是二分查找求mid的公式
        int mid = low + (hight - low) * ((findValue-arr[low]) / (arr[hight] - arr[low]));
        if (findValue > arr[mid]) {
            return insertValue(arr, findValue, mid + 1, hight);
        } else if (findValue < arr[mid]) {
            return insertValue(arr, findValue, low, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
//        int[] arr = new int[]{-56, 1, 1, 2, 2, 2, 20, 25, 44, 47, 50, 56, 90};
        int i = new InsertValueSearch().search(arr, 8);
        System.out.println(i);
    }
}
