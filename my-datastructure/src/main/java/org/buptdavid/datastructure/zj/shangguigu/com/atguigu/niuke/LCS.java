package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.niuke;

/**
 * @author jiezhou
 * @CalssName: LCS
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.niuke
 * @Description: 最长的公共子串
 * @date 2021/7/22/21:28
 */
public class LCS {
    public static void main(String[] args) {
        String a = "5cfepeople", b = "5cfeplm";
        String lcs = new LCS().LCS(a, b);
        System.out.println("lcs = " + lcs);

    }

    public String LCS(String str1, String str2) {
        int maxLength = 0;//最长公共子串长度
        int maxLengthIndex = 0;//最长公共子串最后一个元素在str1 中的下标
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        maxLengthIndex = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println("maxLength = " + maxLength);
        return str1.substring(maxLengthIndex - maxLength + 1, maxLengthIndex + 1);

    }


}
