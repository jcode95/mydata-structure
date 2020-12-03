package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.kmp;

/**
 * @author jiezhou
 * @CalssName: Violentmatch
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.kmp
 * @Description: 暴力匹配
 * @date 2020/9/2/9:48
 */
public class Violentmatch {

    public static void main(String[] args) {
        String s1 = "abdbc";
        String s2 = "c";
        int match = match(s1, s2);
        System.out.println(match);
    }

    public static int match(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int c1Length = c1.length;
        int c2Length = c2.length;
        int i = 0, j = 0;
        while (i < c1Length && j < c2Length) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;//i往前挪j个位置，然后再往后挪1个位置
                j = 0;
            }
        }
        //退出条件
        if (j == c2Length) {
            return i - j;
        } else {
            return -1;
        }
    }
}
