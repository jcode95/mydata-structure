package org.buptdavid.datastructure.zj.刷;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: Solution16
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 最接近的三数之和
 * @date 2020/8/10/14:52
 */
public class Solution16 {

    /*
    *
    *
    * // 示例：
    //
    // 输入：nums = [-1,2,1,-4], target = 1
    //输出：2
    //解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
    * */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 999;//和
        int minAbs = 999;//差值
        for (int i = 0; i < nums.length; i++) {
            int p = nums[i];//基准数
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = p + nums[left] + nums[right];
                int abs = Math.abs(sum - target);
                if (minAbs > abs) {
                    minAbs = abs;
                    min = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                }else {
                    //相等就直接返回了
                   break;
                }
            }
        }
        return min;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,-1,-1,3};
        int i = new Solution16().threeSumClosest(arr, -1);
        System.out.println(i);
    }
}
