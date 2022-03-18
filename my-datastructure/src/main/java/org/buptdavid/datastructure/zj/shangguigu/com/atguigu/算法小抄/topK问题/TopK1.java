package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.topK问题;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jiezhou
 * @CalssName: TopK1
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.topK问题
 * @Description: topk 问题
 * @date 2021/7/7/13:48
 */
public class TopK1 {

    public static void main(String[] args) {
        TopK1 topK1 = new TopK1();
        int[] nums = {1, 2, 7, 9, 4, 3, 6, 53, 3, 54, 45, 6, 3, 45, 6, 47, 56, 7, 567, 568,675, 67, 8, 67, 4, 56, 54, 64, 3, 56, 54, 765, 67, 56, 75, 675};
        int k = 10;
        int value = topK1.findKValue(nums, k);
        Arrays.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));

        System.out.println("value = " + value);
    }

    /**
     * 查找 第k大的元素的值
     *
     * @param nums 海量数组
     * @param k    关键字
     * @return
     */
    public int findKValue(int[] nums, int k) {
        /*使用堆排序（大顶堆/小顶堆）*/
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);//默认 大顶堆

        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });


        for (int e : nums) {
            if (priorityQueue.size() < k || e > priorityQueue.peek()) {
                priorityQueue.offer(e);//入堆
            }
            if (priorityQueue.size() > k) {
                priorityQueue.poll();//出堆
            }
        }
        return priorityQueue.peek();
    }
}
