package org.buptdavid.datastructure.zj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: Robot
 * @Package org.buptdavid.datastructure.zj
 * @Description: 链接：https://www.nowcoder.com/questionTerminal/e8bb8e68434e42acbcdff0341f2a32c5 来源：牛客网
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。  给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 * @date 2020/7/20/16:27
 */
public class Robot {

    /*
    *   0 1 2 3
    *   1 2 3 4
    *   2 3 4 5
    *   3 4 5 6
    * */
//    static StringBuffer stringBuffer = new StringBuffer();
    static int s = 0;
    static List<StringBuffer> ls = new ArrayList<>();

    public static void main(String[] args) {

        int x = 3;
        int y = 3;
        System.out.println(countWayss(x, y));
//        System.out.println(countWayss(x, y));
//        for (StringBuffer l : ls) {
//            System.out.println(l.toString().substring(0,l.length()-3));
//        }
    }

    public static int countWays(int x, int y) {
        return countY(0, 0, x, y);
    }


    public static int countY(int currX, int currY, int endX, int endY) {
        s++;
        if (currX == endX || currY == endY) {
            return 1;
        }
        return countY(currX, currY + 1, endX, endY) + countY(currX + 1, currY, endX, endY);
    }

    /*基本动态规划*/
    public static int countWayss(int x, int y) {
        // write code here
        int[][] dp = new int[x][y];
        dp[0][0] = 1;
        for (int i = 1; i < x; i++) {
            dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i < y; i++) {
            dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];//上一个值加上左边的值就是当前的值
            }
        }
        return dp[x - 1][y - 1];//取最右下角值
    }

}
