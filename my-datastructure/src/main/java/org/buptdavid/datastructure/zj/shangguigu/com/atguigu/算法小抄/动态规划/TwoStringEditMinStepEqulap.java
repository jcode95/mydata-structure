package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划;

/**
 * @author jiezhou
 * @CalssName: TwoSubStringEditMinStepEqulap
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.算法小抄.动态规划
 * @Description: 两个字符串操作最少步数得相同字符串
 * @date 2020/11/27/0:16
 */
public class TwoStringEditMinStepEqulap {
/*
* 这道题给了我们两个单词，问我们最少需要多少步可以让两个单词相等，
* 每一步我们可以在任意一个单词中删掉一个字符。那么我们分析怎么能让步数最少呢，
* 是不是知道两个单词最长的相同子序列的长度，并乘以2，被两个单词的长度之和减，就是最少步数了。
* 其实这道题就转换成求Longest Common Subsequence最长相同子序列的问题，
* 对于这种玩字符串，并且是求极值的问题，十有八九都是用dp来解的，
* 那么决定了用dp来做，就定义一个二维的dp数组，其中dp[i][j]表示word1的前i个字符和word2的前j个字符组成的两个单词的最长公共子序列的长度。下面来看递推式dp[i][j]怎么求，首先来考虑dp[i][j]和dp[i-1][j-1]之间的关系，我们可以发现，如果当前的两个字符相等，那么dp[i][j] = dp[i-1][j-1] + 1，这不难理解吧，因为最长相同子序列又多了一个相同的字符，所以长度加1。由于我们dp数组的大小定义的是(n1+1) x (n2+1)，所以我们比较的是word1[i-1]和word2[j-1]。那么我们想如果这两个字符不相等呢，难道我们直接将dp[i-1][j-1]赋值给dp[i][j]吗，当然不是，我们还要错位相比嘛，比如就拿题目中的例子来说，"sea"和"eat"，当我们比较第一个字符，发现's'和'e'不相等，下一步就要错位比较啊，比较sea中第一个's'和eat中的'a'，sea中的'e'跟eat中的第一个'e'相比，这样我们的dp[i][j]就要取dp[i-1][j]跟dp[i][j-1]中的较大值了，最后我们求出了最大共同子序列的长度，就能直接算出最小步数了
* */

    public static void main(String[] args) {
        String s1 = "131";
        String s2 = "132";
        TwoStringEditMinStepEqulap stepEqulap = new TwoStringEditMinStepEqulap();
        int minStep = stepEqulap.process(s1, s2);//得到最小步数（不能替换，删除算一步增加算一步）
        System.out.println("解法一 " + minStep);
        int minStep1 = stepEqulap.process1(s1, s2);//得到最小步数（可以替换，替换就只算一步）
        System.out.println("解法二 " + minStep1);
    }

    /**
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 最小步数
     */
    private int process(String s1, String s2) {
        int length = getGonggongSubStrLength(s1, s2);//得到最长公共字串长度
        int sumLength = s1.length() + s2.length();
        return sumLength - length * 2;

    }

    /**
     * 获取两个字符串的最长公共字串长度
     *
     * @param s1
     * @param s2
     * @return
     */
    private int getGonggongSubStrLength(String s1, String s2) {
        int s1Length = s1.length();
        int s2length = s2.length();
        int[][] dp = new int[s1Length + 1][s2length + 1];
        for (int i = 1; i < s1Length + 1; i++) {
            for (int j = 1; j < s2length + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1Length][s2length];
    }


    /*++++++++++++++++++++解法二、自底向上求解++++++++++++++++++++++++*/

    /**
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 最小步数
     */
    private int process1(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        //自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    /*# 解释： # 本来就相等，不需要任何操作
                    # s1[0..i] 和 s2[0..j] 的最⼩编辑距离等于
                    # s1[0..i-1] 和 s2[0..j-1] 的最⼩编辑距离
                    # 也就是说 dp(i, j) 等于 dp(i-1, j-1)*/
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    /*
                    * dp(i, j - 1) + 1, # 插⼊
                    * # 解释：
                    * # 我直接在 s1[i] 插⼊⼀个和 s2[j] ⼀样的字符
                    * # 那么 s2[j] 就被匹配了，前移 j，继续跟 i 对⽐
                    * # 别忘了操作数加⼀
                    *dp(i - 1, j) + 1, # 删除
                    * # 解释：
                    * # 我直接把 s[i] 这个字符删掉
                    * # 前移 i，继续跟 j 对⽐
                    * # 操作数加⼀
                    *
                    * */
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;//想象为一个二维数组，取左上三角的最小值+1
                }
            }
        }
        return dp[m][n];
    }


}
