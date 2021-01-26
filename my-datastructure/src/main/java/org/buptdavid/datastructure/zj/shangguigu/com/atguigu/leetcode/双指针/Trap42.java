package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.双指针;

/**
 * @author jiezhou
 * @CalssName: Trap42
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.双指针
 * @Description: 接雨水
 * @date 2020/12/28/15:01
 */
public class Trap42 {


    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int sumArea = 0;
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
            sumArea += area;
        }
        return sumArea;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = new Trap42().trap(arr);
        System.out.println(trap);


    }
}
