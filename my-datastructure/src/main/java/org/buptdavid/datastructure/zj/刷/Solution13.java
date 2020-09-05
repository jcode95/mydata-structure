package org.buptdavid.datastructure.zj.刷;

/**
 * @author jiezhou
 * @CalssName: Solution13
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 罗马字符串转换为整数
 * @date 2020/8/10/9:51
 */
public class Solution13 {

    public int romanToInt(String s) {
        int i = 0, j = s.length();
        int sum = 0;
        while (i < j - 1) {
            if (getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
                sum -= getValue(s.charAt(i));
            } else {
                sum += getValue(s.charAt(i));
            }
            i++;
        }
        sum+=getValue(s.charAt(j-1));
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        int iv = new Solution13().romanToInt("IV");
        System.out.println(iv);


    }


}
