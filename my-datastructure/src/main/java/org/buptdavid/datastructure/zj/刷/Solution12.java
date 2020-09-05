package org.buptdavid.datastructure.zj.刷;


/**
 * @author jiezhou
 * @CalssName: Solution12
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 整数转罗马数字
 * @date 2020/8/8/14:04
 */

/*
*
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
* */
public class Solution12 {
    public static void main(String[] args) {
        int i = 1234;
        String s = new Solution12().intToRoman(i);
        System.out.println(s);

    }

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < 13) {
            if (num >= nums[index]) {
                result.append(romans[index]);
                num -= nums[index];
            } else {
                index++;
            }
        }
        return result.toString();
    }
}
