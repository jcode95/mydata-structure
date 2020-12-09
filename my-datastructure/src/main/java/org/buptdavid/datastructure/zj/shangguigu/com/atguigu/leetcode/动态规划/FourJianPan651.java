package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: FourJianPan
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 4键盘问题
 * @date 2020/12/7/9:11
 * 题目：
 * 四键键盘问题很有意思，⽽且可以明显感受到：对 dp 数组的不同定义需要 完全不同的逻辑，从⽽产⽣完全不同的解法。
 * <p>
 * 假如 你有一个特殊的键盘，包含下面的按键
 * key 1 ：（A） 在屏幕上打印一个A
 * key 2 ：（C-A） :选中整个屏幕
 * key 3： （C-C） :复制选中区域到缓冲区
 * key 4： （C-V） :将缓冲区的内容输出到上次输入的结束位置，并在屏幕上显示。
 * 现在， 你只可以按键N次（使用上述4种按键），问屏幕上最多可以显示几个“A”呢？
 * <p>
 * 上面的题目也就是我们生活中复制粘贴（全选-复制-粘贴）的表示。
 * <p>
 * <p>
 * <p>
 * 思路：
 * 这种思路稍微有点复杂，但是效率⾼。
 * 继续⾛流程，「选择」还是那 4 个， 但是这次我们只定义⼀个「状态」，也就是剩余的敲击次数 n 。
 * 这个算法基于这样⼀个事实，最优按键序列⼀定只有两种情况： 要么⼀直按 A ：A,A,...A（当 N ⽐较⼩时）。
 * 要么是这么⼀个形式：A,A,...C-A,C-C,C-V,C-V,...C-V（当 N ⽐较⼤时）。
 * 因为字符数量少（N ⽐较⼩）时， C-A C-C C-V 这⼀套操作的代价相对⽐较 ⾼，
 * 可能不如⼀个个按 A ；⽽当 N ⽐较⼤时，后期 C-V 的收获肯定很 ⼤。这种情况下整个操作序列⼤致是：开头连按⼏个 A ，然后 C-A C-C 组合再接若⼲ C-V ，然后再 C-A C-C 接着若⼲ C-V ，循环下去。
 * 换句话说，最后⼀次按键要么是 A 要么是 C-V 。
 * 明确了这⼀点，可以通 过这两种情况来设计算法：
 */
public class FourJianPan651 {
    public static void main(String[] args) {
        System.out.println(process(7));
    }


    public static int process(int n) {
        int[] dp = new int[n + 1];//dp[i] i 是当前按键次数，dp[i] 值的当前屏幕上'A' 的个数。
        for (int i = 1; i <= n; i++) {
            // 按 A 键 dp[i] = dp[i - 1] + 1;
            dp[i] = dp[i - 1] + 1;
            //按下 （C-A）-->(C-C)-->(C-V)...
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
                //dp[j - 2] * (i - j + 1)  解释： dp[j - 2] 也就是上次开始（C-V）时屏幕上的‘A’的个数 ,j-2 的意思是刚开始（C-V）时向前（C-A）的按键个数，(i - j + 1) 就是在j按键次数时到i按键次数按了几次，加1是加上之前的最开始的全选的那一次，因为题目是在最后粘贴的，所以要加上之前的。
            }
        }
        return dp[n];
    }
}
