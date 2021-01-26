package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.双指针;

/**
 * @author jiezhou
 * @CalssName: MaxArea
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 存水最多的容器
 * @date 2020/12/28/10:50
 */
public class MaxArea11 {

    /**
     * 示例：
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * <p>
     * 输出：49
     * <p>
     * 使用双指针
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = 0;
            if (height[left] < height[right]) {
                area = (height[left] * (right - left));
                left++;
            } else if (height[left] > height[right]) {
                area = (height[right] * (right - left));
                right--;
            } else {
                area = (height[right] * (right - left));
                left++;
                right--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = new MaxArea11().maxArea(arr);
        System.out.println(area);
    }
}
