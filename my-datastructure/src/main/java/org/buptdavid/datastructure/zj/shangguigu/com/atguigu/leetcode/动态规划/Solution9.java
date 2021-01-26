package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * 思路：看成是比较面积，然后拿第一个与剩余的组成面积，然后循环拿第二个，以此类推
 */
public class Solution9 {
    static int min = 0;
    static int kuan = 0;
    static int store = 0;
    static int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 6, 7};

    static {
        min = height[0];
        kuan = 1;
        store = min * kuan;
    }

    public static void main(String[] args) {
        maxArea(height);
        System.out.println("min:" + min);
        System.out.println("kuan:" + kuan);
        System.out.println("store:" + store);

    }

    public static void maxArea(int[] height) {
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minTp = 0;
                if (height[i] > height[j]) {
                    minTp = height[j];
                } else {
                    minTp = height[i];
                }
                int kuanTp = j - i;
                int storeTp = kuanTp * minTp;
                if (storeTp > store) {
                    store = storeTp;
                    min = minTp;
                    kuan = kuanTp;
                }
            }
        }
    }

    //解法二，使用栈
    public int maxAreaToStack(int[] height) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();//存的是比前一个柱子的高的下标
        int maxAre = 0;
        for (int i = 0; i < height.length; i++) {
            if (!stack.isEmpty() && stack.peek() > height[i]) {

            }


        }
        return 0;

    }


}