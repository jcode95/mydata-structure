package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.kmp;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: KmpSearch
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.kmp
 * @Description: kmp字符串匹配算法
 * @date 2020/9/2/10:15
 */
public class KmpSearch {


    /*public static int kmpSearch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Length = s1.length;
        int s2length = s2.length;
        int i = 0, j = 0;
        while (i < s1Length && j < s2length) {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
//                j = next[j];
            }
        }
        if (j == s2length)
            return i - j;
        else {
            return -1;
        }
    }*/



    // 生成Next数组
    /*private static int[] getNexts(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                //从next[i+1]的求解回溯到 next[j]
                j = next[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }*/

    /*public static int[] getF(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串是长度为1 部分匹配值就是0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到我们发现 有  dest.charAt(i) == dest.charAt(j)成立才退出
            //这是kmp算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;


    }*/

    public static void main(String[] args) {
//        String str = "ATGTGAGCTGGTGTGTGCFAA";
        String str = "ATGTGAGCTGGTGTGTGCFAA";
//        String pattern = "GTGTGCF";
//        String pattern = "ABCDABD";
        String pattern = "abab";
//        int index = kmp(str, pattern);
//        System.out.println("首次出现位置：" + index);
        int[] next = getArr1(pattern);
        System.out.println(Arrays.toString(next));
        System.out.println(kmpMy1(str, pattern));
    }

    private static int kmpMy(String secStr, String pStr) {
        int[] next = getArr(pStr);
        for (int i = 0, j = 0; i < secStr.length(); i++) {
            while (j > 0 && secStr.charAt(i) != pStr.charAt(j)) {
                j = next[j - 1];
            }
            if (secStr.charAt(i) == pStr.charAt(j)) {
                j++;
            }
            if (j == pStr.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private static int[] getArr(String string) {
        int[] next = new int[string.length()];
        //填充数组
        int j = 0;
        for (int i = 1; i < string.length(); i++) {
            while (j > 0 && string.charAt(i) != string.charAt(j - 1)) {
                j = next[j - 1];
            }
            if (string.charAt(i) == string.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    public static int kmpMy1(String sString, String pString) {
        //获取kmp的前缀和后缀的数组
        int[] next = getArr1(pString);
        for (int i = 0, j = 0; i < sString.length(); i++) {
            while (j > 0 && sString.charAt(i) != pString.charAt(j)) {
                j = next[j - 1];
            }
            if (sString.charAt(i) == pString.charAt(j)) {
                j++;
            }
            if (j == pString.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private static int[] getArr1(String pString) {
        int[] next = new int[pString.length()];
        int j = 0;
        for (int i = 1; i < pString.length(); i++) {
            while (j > 0 && pString.charAt(i) != pString.charAt(j)) {
                j = next[j - 1];
            }
            if (pString.charAt(i) == pString.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


}
