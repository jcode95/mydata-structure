package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.recursion;


/**
 * @author jiezhou
 * @CalssName: EightQueen
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.recursion
 * @Description: 八皇后求解
 * @date 2020/8/15/11:13
 */
public class EightQueen {
    static final int MAX = 8;
    static int[] arr = new int[MAX];//存放
    static int count=0;
    static int jj=0;
    public static void main(String[] args) {
//        for (int i = 0; i < MAX; i++) {
        process(0);
        System.out.println(count);
        System.out.println(jj);
//        }
    }

    //放置第n个皇后
    public static void process(int n) {
        if (n == MAX) {
            printf(arr);
            return;
        }
        //依次放入皇后并判断皇后是否符合条件
        for (int i = 0; i < MAX; i++) {
            //先把第n个皇后放到该行的第1列
            arr[n] = i;
            if (chack(n)) {
                process(n + 1);
            }
        }

    }

    /**
     * 打印最终结果
     *
     * @param arr
     */
    private static void printf(int[] arr) {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断 第n个皇后是否符合条件
     *
     * @param n 第几个皇后
     */
    public static boolean chack(int n) {
        jj++;
        if (n < 0 && n >= MAX) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            //arr[i] == arr[n] 同一列
            //Math.abs(n - i) == Math.abs(arr[n] - arr[i]) 同一个对角线
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
