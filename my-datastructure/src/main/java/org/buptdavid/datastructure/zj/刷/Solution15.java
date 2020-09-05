package org.buptdavid.datastructure.zj.刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: Solution15
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 三数之和
 * @date 2020/8/10/11:47
 */
public class Solution15 {

    /*
    * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //找到基准数p
            int p = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = p + nums[left] + nums[right];
                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //再判断left位置的元素与下一个元素是否相等
                    while ((left + 1) < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    //再判断right位置的元素与前一个元素是否相等
                    while ((right - 1) >= 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution15().threeSum(arr);
        System.out.println(lists.toString());
    }
}
