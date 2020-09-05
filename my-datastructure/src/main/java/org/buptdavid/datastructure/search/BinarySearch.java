package org.buptdavid.datastructure.search;

import java.util.Comparator;

/**
 * 二分查找的实现： 在一个有序数组中查找某个值
 * @author weijielu
 * @see BinarySearchTest
 */
public class BinarySearch{

	static int  count=0;
	/**
	 * 使用循环的方式实现二分查找
	 * @param array
	 * @param value
	 * @return
	 */
	public static Integer searchCirculation(int[] array, int value){
		int low = 0;
		int high = array.length - 1;
		int middle;
		
		while(low <= high){
			middle = (low + high) / 2;
			if(value < array[middle]){
				high = middle - 1;
			}else if(value > array[middle]){
				low = middle + 1;
			}else{
				return array[middle];
			}
		}
		
		return null;
	}
	public static <T> int search(T key, T[] x, Comparator<T> comp){
		int start=0;
		int end=x.length-1;
		while (start<=end){
			int mid=(start+end)/2;
			int compare = comp.compare(x[mid], key);
			if(compare<0){
				start=mid+1;
			}
			if(compare>0){
				end=mid-1;
			}
			if(compare==0){
				return mid;
			}
		}
		return -1;
	}


	
	/**
	 * 使用递归的方式实现二分查找
	 * @param array
	 * @param value
	 * @return
	 */
	public static Integer searchRecursive(int[] array, int value){
		return searchRecursive(array, value, 0, array.length - 1);
	}
	
	private static Integer searchRecursive(int[] array, int value, int low, int high){
		count++;
		if(high < low){
			return null;
		}
		
		int middle = (low + high) / 2;
		
		if(value < array[middle]){
			return searchRecursive(array, value, low, middle - 1);
		}else if(value > array[middle]){
			return searchRecursive(array, value, middle + 1, high);
		}else {
			System.out.println("查找了："+count+"次");
			return array[middle];
		}
	}

	public static void main(String[] args) {

		Integer[] array={13,18,24,35,47,50,62,83,90,115,134,554};
		int value=90;
//		Integer integer = searchRecursive(array, value);
		int search = search(115, array, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		System.out.println("找到了,下标："+search);
	}


}
