package org.buptdavid.datastructure.sort;

/**
 * @author jiezhou
 * @CalssName: MyQuickSort
 * @Package org.buptdavid.datastructure.sort
 * @Description: 自己实现的快排
 * @date 2020/7/20/10:43
 */
public class MyQuickSort implements ISort {
    public static void main(String[] args) {

        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};

        new MyQuickSort().sort(arr);

    }

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.println(i);
        }


    }

    private void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        int tmp;
        //取基准值
        int var = array[left];
        while (left < right) {
            while (right > left && array[right] >= var) {
                right--;
            }
            //从后往前找，比var小的就交换
            tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;

            while (left < right && array[left] <= var) {
                left++;
            }
            //从前往后找，比var小的就交换
            tmp = array[right];
            array[right] = array[left];
            array[left] = tmp;
        }
        array[left] = var;
        quickSort(array, leftIndex, left - 1);
        quickSort(array, right + 1, rightIndex);

    }
}
