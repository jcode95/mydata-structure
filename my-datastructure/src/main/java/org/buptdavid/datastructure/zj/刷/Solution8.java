package org.buptdavid.datastructure.zj.刷;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * @author jiezhou
 * @CalssName: Solution8
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 字符串转换整数
 * @date 2020/8/7/14:18
 */
public class Solution8 {

    public static void main(String[] args) {
        String s = "3.14159";
        int i = new Solution8().myAtoi(s);
        System.out.println(i);
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str == "" || str.length() == 0) {
            return 0;
        }
        if (!chackChar(str.charAt(0)) && !chack(str.charAt(0))) {
            return 0;
        }
        if (str.length() == 1 && !chackChar(str.charAt(0))) {
            return 0;
        }
        if (str.length() > 1 && !chackChar(str.charAt(1)) && !chackChar(str.charAt(0))) {
            return 0;
        }
        int i = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        while (i < str.length()) {
            if (chackChar(str.charAt(i))) {
                sb.append(str.charAt(i));
                i++;
            } else {
                break;
            }
        }
        String result = sb.toString();
        try {
            int s = Integer.parseInt(result);
            return s;
        } catch (Exception e) {
            if (result.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }

    public boolean chack(char c) {
        if (c == '-' || c == '+') {
            return true;
        } else {
            return false;
        }
    }

    public boolean chackChar(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
