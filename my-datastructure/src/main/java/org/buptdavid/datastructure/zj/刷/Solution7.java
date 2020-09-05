package org.buptdavid.datastructure.zj.刷;


/**
 * @author jiezhou
 * @CalssName: Solution7
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 整数反转
 * @date 2020/8/7/12:17
 */
public class Solution7 {


    public static void main(String[] args) {
        int reverse = new Solution7().reverse(-545465467);
        System.out.println(reverse);
    }

    /*
        则其数值范围为 [−231, 231 − 1]
    * */
    public int reverse(int x) {
        if (x < -Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
            return 0;
        }
        String s = x + "";
        int result;
        if (s.startsWith("-")) {
            s = s.substring(1);
            StringBuilder stringBuilder = new StringBuilder(s);
            StringBuilder reverse = stringBuilder.reverse();
            try {
                result = Integer.parseInt("-" + reverse.toString());
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder(s);
            StringBuilder reverse = stringBuilder.reverse();
            try {
                result = Integer.parseInt(reverse.toString());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        if (result < -Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }
}
