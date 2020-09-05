package org.buptdavid.datastructure.zj.刷;


/**
 * @author jiezhou
 * @CalssName: Solution10
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 正则表达式匹配
 * @date 2020/8/7/18:12
 */
public class Solution10 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = ".*";
        boolean process = new Solution10().isMatch(s1, s2);
        System.out.println(process);
    }

    public boolean isMatch(String s, String p) {
        return process(s, p, 0, 0);
    }

    /**
     * @param s z字符串1
     * @param p 字符串2
     * @param i 字符串1的下标
     * @param j 字符串2的下标
     * @return 当前s和p的匹配结果
     */
    private boolean process(String s, String p, int i, int j) {
        if (i == s.length() && (j == p.length() || (j == p.length() - 2 && p.charAt(j + 1) == '*'))) {
            return true;
        }
        if (i == s.length() || p.length() == j) {
            if (i == s.length()) {
                return change(p, j);
            } else {
                return false;
            }
        }

        //p字符串的当前字符的下一个字符是*时
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (judeg(s.charAt(i), p.charAt(j))) {
                return process(s, p, i, j + 2) || process(s, p, i + 1, j);
            } else {
                return process(s, p, i, j + 2);
            }
        }


        if (judeg(s.charAt(i), p.charAt(j))) {
            //直接看下一个字符
            return process(s, p, i + 1, j + 1);
        }
        return false;
    }

    private boolean change(String p, int j) {
        while (j < p.length()) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                j += 2;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean judeg(char c, char c1) {
        if (c == c1 || c1 == '.') {
            return true;
        }
        return false;
    }


}
