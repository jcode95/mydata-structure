package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划;

/**
 * @author jiezhou
 * @CalssName: Fibo
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划
 * @Description: 斐波那契数列
 * @date 2020/11/26/18:34
 */
public class Fibo {
    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        int fib = fibo.processArr(20);
        System.out.println("备忘录： " + fib);

        int fib1 = fibo.process(20);
        System.out.println("dp数组： " + fib1);
        int fib2 = fibo.process1(20);
        System.out.println("直观明了： " + fib2);


    }

    /**
     * 数组充当备忘录 优化的斐波那契数列求值问题 --自顶向下
     *
     * @param n
     * @return
     */
    public int processArr(int n) {
        return fib(n);
    }


    private int fib(int n) {
        if (n < 1) {
            return 0;
        }
        int[] memo = new int[n + 1];//使⽤⼀个数组充当这个「备忘录」
        return helper(memo, n);

    }

    private int helper(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }


    //-------------------------------------------------------------------------

    /**
     * 动态规划求斐波那契数列值问题--自底向上 O(n)
     */
    public int process(int n) {
        return fibo(n);
    }

    private int fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        //定义dp一维数组
        int[] dp = new int[n];
        dp[0] = 1;//初始化
        dp[1] = 1;//初始化
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 斐波那契数列值问题--自底向上
     */
    public int process1(int n) {
        return fibona(n);
    }

    private int fibona(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        //定义dp一维数组
        int pre = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = pre + curr;//得到计算的和
            pre = curr;//把当前值赋值给上一个值
            curr = sum;//吧计算的和赋值给当前值
        }
        return curr;//返回当前值
    }

}
