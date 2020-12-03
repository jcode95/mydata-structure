package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jiezhou
 * @CalssName: SubArrDisjoint
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划
 * @Description:
 * @date 2020/12/2/17:45
 * <p>
 * 本⽂解决⼀个很经典的贪⼼算法问题 Interval Scheduling（区间 调度问题）。
 * 给你很多形如 [start, end] 的闭区间，请你设计⼀个算法， 算出这些区间中最多有⼏个互不相交的区间。
 * int intervalSchedule(int[][] intvs) {} 89
 * 贪⼼算法之区间调度问题
 * 举个例⼦:
 * intvs = [[1,3], [2,4], [3,6]] ，
 * 这些区间最多有 2 个区间互不 相交，即 [[1,3], [3,6]] ，你的算法应该返回 2。注意边界相同并不算相 交。
 * <p>
 * 思路：
 * 正确的思路其实很简单，可以分为以下三步： 1. 从区间集合 intvs 中选择⼀个区间 x，这个 x 是在当前所有区间中结束 最早的（end 最⼩）。 2. 把所有与 x 区间相交的区间从区间集合 intvs 中删除。 3. 重复步骤 1 和 2，直到 intvs 为空为⽌。之前选出的那些 x 就是最⼤不 相交⼦集。 把这个思路实现成算法的话，
 * 可以按每个区间的 end 数值升序排序，因为 这样处理之后实现步骤 1 和步骤 2 都⽅便很多
 */
public class SubArrDisjoint {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {2, 4}, {3, 6}};
        System.out.println(process(arr));

    }

    static int process(int[][] arr) {
        //对数组arr 按照第二维按升序排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 1;
        int x_end = arr[0][1];
        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            if (start >= x_end) {
                count++;
                x_end = arr[i][1];
            }

        }
        return count;
    }
}
