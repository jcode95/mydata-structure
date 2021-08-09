package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.niuke;

import java.util.Arrays;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: WordBreak
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.niuke
 * @Description: 拆分单词
 * @date 2021/7/23/10:15
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "applepenapple";
        String[] wordDict = new String[]{"apple", "pen"};
        boolean aBreak = new WordBreak().wordBreak(s, Arrays.asList(wordDict));
        System.out.println("aBreak = " + aBreak);
    }

    public boolean wordBreak(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];//dp[i]  字符串 s 在 i处是否存在dict 里面
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {//向前截取下标j的字符串
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }

}
