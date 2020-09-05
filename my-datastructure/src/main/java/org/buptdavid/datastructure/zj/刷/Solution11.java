package org.buptdavid.datastructure.zj.刷;

/**
 * @author jiezhou
 * @CalssName: Solution11
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 盛最多水的容器
 * @date 2020/8/8/12:00
 */
public class Solution11 {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = new Solution11().maxArea(arr);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int h=Math.min(height[right], height[left]);
            int tmp = h * (right - left);
            max=Math.max(tmp,max);
            if (height[left] < height[right]) {
                left++;
            } else if(height[left] > height[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return max;
    }
}
