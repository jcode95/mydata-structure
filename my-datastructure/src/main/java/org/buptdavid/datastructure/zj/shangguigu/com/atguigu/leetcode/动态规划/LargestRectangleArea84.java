package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author jiezhou
 * @CalssName: LargestRectangleArea84
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description:柱状图中最大的矩形面积
 * @date 2020/12/19/10:53
 */
public class LargestRectangleArea84 {
    public static void main(String[] args) {
//        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(largestRectangleArea1(arr));

    }

    /**
     * 暴力解法，性能很差
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int h = i; h >= 0; h--) {
                minHeight = Math.min(heights[h], minHeight);
                dp[i] = minHeight * (i - h + 1);
                maxArea = Math.max(maxArea, dp[i]);
            }
        }
        return maxArea;
    }

    /**
     * 解法二，使用栈
     * 思路：
     * 栈里面存的就是在当前下标下，左边比当前下标还要小的柱子的下标，，如果比栈顶的下标柱子还大，就需要出栈来计算面积，否则就需要入栈
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     */
    public static int largestRectangleArea1(int[] heights) {
        //栈
        Stack<Integer> stack = new Stack<>();//当前比前一个柱子的高的下标
        int maxAre = 0;
        int n = heights.length;
        if (n == 1) {
            return heights[0];
        }
        int[] newArr = Arrays.copyOf(heights, n + 1);
        for (int i = 0; i <= n; i++) {
            if (!stack.isEmpty() && heights[stack.peek()] > newArr[i]) {
                //出栈计算面积
                Integer index = stack.pop();
                int area = newArr[index] * ((stack.isEmpty() ? i : (i - stack.peek() - 1)));
                maxAre = Math.max(maxAre, area);
                i--;
            } else {
                //入栈
                stack.push(i);
            }
        }
        return maxAre;
    }
}
