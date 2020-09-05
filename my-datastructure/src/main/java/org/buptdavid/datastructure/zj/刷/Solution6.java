package org.buptdavid.datastructure.zj.刷;


import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: Solution6
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: Z 字形变换
 * @date 2020/8/6/11:31
 */
public class Solution6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String convert = new Solution6().convert(s, 5);
        System.out.println(convert);


    }

    public String convert(String s, int numRows) {
        if ("".equals(s)) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            k = i % (2 * numRows - 2);
            if (k < numRows) {
                arr[k] += c;
            } else {
                arr[(2 * numRows - 2) - k] += c;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String c = arr[i];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
