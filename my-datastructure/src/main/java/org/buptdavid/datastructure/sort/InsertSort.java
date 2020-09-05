/**
 *
 */
package org.buptdavid.datastructure.sort;

/**
 * 插入排序实现
 *
 * @author weijielu
 */
public class InsertSort implements ISort {

    public static void main(String[] args) {

        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};

        new InsertSort().sortMy(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

	@Override
    public void sort(int[] array) {
        for(int i = 1; i < array.length; i++){
			int temp = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > temp){
				array[j + 1] = array[j];
				j--;
			}
			
			if(j != i - 1){
				array[j +1] = temp;
			}
		}
	}
    public void sortMy(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp;
            int j = i - 1;
            while (j >= 0 && array[j+1] < array[j]) {
                //交换位置
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                j--;//向前走一位
            }
        }
    }

}
