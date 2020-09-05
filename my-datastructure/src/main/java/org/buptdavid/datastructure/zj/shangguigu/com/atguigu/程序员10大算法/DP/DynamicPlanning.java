package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiezhou
 * @CalssName: DynamicPlanning
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.DP
 * @Description: 动态规划-0-1背包问题
 * @date 2020/9/1/14:52
 */
public class DynamicPlanning {
    private static int[][] v;//二维数组，用于填表过程，最终最右下角的的值就是我们需要的解
    private static Map<Integer, Integer> goods = new HashMap<>();//物品

    public static void main(String[] args) {
        init(4);
        process();
        /*打印的填的表可能会和网上的不同，但最终的结果看肯定是唯一的，不同的原因取决于goods map的顺序*/
        list();
        System.out.println(v[v.length - 1][v[v.length - 1].length - 1]);//输出最终右下角的值
    }

    private static void list() {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 填表过程
     */
    private static void process() {
        /*以下是填表过程*/
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : goods.entrySet()) {
            i++;
            Integer wi = entry.getKey();
            Integer vi = entry.getValue();
            for (int j = 1; j < v[i].length; j++) {//得到列 1 2 3 4 磅 也就是背包假如取的容量
                if (j >= wi) {//如果当前背包容量大于要添加物品的容量
                    v[i][j] = Math.max(v[i - 1][j], vi + v[i - 1][j - wi]);//v[i-1][j-wi]  这个的解释：我的理解: 使用当前背包的容量(j)-当前添加的物品的重量  用这个值作为列 ，行(hang)的话就使用当前的上一行
                } else {//背包容量小于要添加物品的容量 直接使用上个单元格的值
                    v[i][j] = v[i - 1][j];
                }
            }
        }
    }

    /**
     * 初始化
     *
     * @param w 背包的容量
     */
    public static void init(int w) {
        goods.put(1, 1500);
        goods.put(4, 3000);
        goods.put(3, 2000);
        v = new int[goods.size() + 1][w + 1];//这里行列都加1是为了做没有添加物品的时候当背包的容量为0，物品的价值也就为0。
    }
}
