package org.buptdavid.datastructure.sort;


import java.util.ArrayList;
import java.util.List;

/**
 * 选择排序<br>
 * 时间复杂度: 平均情况与最差情况都是O(n^2)<br>
 * 空间复杂度: O(1)
 *
 * @author weijielu
 * @see ISort
 * @see
 */
public class SelectionSort {
    static List<Integer> ls=new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[]{2,1,4,6,4,3,2,0};
        //定义新数组
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ls.add(arr[i]);
        }
        new SelectionSort().sort(ls,newArr);

        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }

    }


    public void sort(List<Integer> ls,int[] newArr) {
        int i = 0;
        while (i < newArr.length) {
            int v = findMin(ls);
            newArr[i] = v;
            i++;
        }
    }

    public int findMin(List<Integer> arr) {
        int min = arr.get(0);
        int minIndex = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
                minIndex = i;
            }
        }
        arr.remove(minIndex);
        return min;
    }

}
