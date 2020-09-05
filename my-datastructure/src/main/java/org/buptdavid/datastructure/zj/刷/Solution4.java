package org.buptdavid.datastructure.zj.刷;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * @author jiezhou
 * @CalssName: Solution4
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description:
 * @date 2020/8/4/10:48
 */
public class Solution4 {


    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2};
        int[] arr2 = new int[]{3,4};
        new Solution4().findMedianSortedArrays(arr1, arr2);
    }

    /**
     * 34678
     * [1,2,7,8]
     * [3,4,6,9]
     * [1,2,3,4,6,7,8,9]
     * <p>
     * (4+6)/2=5   中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;
        return (findKMy(nums1, 0, nums2, 0, left) + findKMy(nums1, 0, nums2, 0, right)) / 2.0;

    }

    //找到两个数组中第k小的元素
    public int findK(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length)
            return nums2[j + k - 1];
        if (j >= nums2.length)
            return nums1[i + k - 1];
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        //计算出每次要比较的两个数的值，来决定 "删除"" 哪边的元素
        int mid1 = (i + (k / 2) - 1) < nums1.length ? nums1[i + (k / 2) - 1] : Integer.MAX_VALUE;//k/2就是要删除的个数
        int mid2 = (j + (k / 2) - 1) < nums2.length ? nums2[j + (k / 2) - 1] : Integer.MAX_VALUE;
        //通过递归的方式，来模拟删除掉前K/2个元素
        if (mid1 < mid2) {
            return findK(nums1, i + (k / 2), nums2, j, k - (k / 2));
        }
        return findK(nums1, i, nums2, j + (k / 2), k - (k / 2));
    }

    public int findKMy(int[] nums1, int i, int[] nums2, int j, int k) {


        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int mid1 = (i + (k / 2) - 1) > nums1.length ? Integer.MAX_VALUE : nums1[i + (k / 2) - 1];
        int mid2 = (j + (k / 2) - 1) > nums2.length ? Integer.MAX_VALUE : nums2[j + (k / 2) - 1];
        if (mid1 < mid2) {
            //删除nums1
            return findKMy(nums1, i + (k / 2), nums2, j, k - (k / 2));
        }
        return findKMy(nums1, i, nums2, j + (k / 2), k - (k / 2));
    }


}
