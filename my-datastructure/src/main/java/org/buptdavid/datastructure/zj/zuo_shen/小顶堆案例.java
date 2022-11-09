package org.buptdavid.datastructure.zj.zuo_shen;



import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author root
 * @CalssName: 小顶堆案例
 * @Package org.buptdavid.datastructure.zj.zuo_shen
 * @Description:
 * @date 2022/8/25/20:18
 */
public class 小顶堆案例 {

    public static void main(String[] args) {

//        int[] arr = ArrayUtils.generateArray(6, 10);
//        int[] arr = {1, 2, 3, 1, 4, 5, 4};
        int[] arr = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 11, 12, 14, 13, 12};
        System.out.println("arr = " + Arrays.toString(arr));
        heapsort(arr, 3);
    }


    /**
     * 已知一个几乎有序的数组，把数组排好顺序的话，每个元素移动的距离一定不超过k，并且k相对于数组长度来说比较小
     */
    /**
     * 其他版本的代码
     *
     * @param arr
     * @param k
     */
    public static void heapsort(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();//优先级队列（默认小顶堆）
        for (int i = 0; i < Math.min(arr.length, k); i++) {
            heap.add(arr[i]);
        }
        System.out.print("[");
        while (k < arr.length) {
            System.out.print(heap.poll() + ", ");
            heap.add(arr[k]);
            k++;
        }
        int lock = heap.size();
        //未进行弹出操作之前,已经加入了k个元素,所以会有剩余在堆中
        while (!heap.isEmpty()) {
            if (lock != 1) {
                System.out.print(heap.poll() + ", ");
            } else {
                System.out.print(heap.poll());
            }
            lock--;
        }
        System.out.println("]");
    }

}
