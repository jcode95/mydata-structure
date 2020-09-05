package org.buptdavid.datastructure.zj.刷;

/**
 * @author jiezhou
 * @CalssName: Solution14
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 求最长公共字串
 * @date 2020/8/10/9:58
 */
public class Solution14 {

    public static void main(String[] args) {
        String[] strs = new String[]{"a", "as", "accc"};
        String s = new Solution14().longestCommonPrefix(strs);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = getValue(strs);
        if (str == "" || str.length() == 0) {
            return "";
        }
        boolean flg = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    flg = true;
                    break;
                }
            }
            if (!flg)
                sb.append(c);
        }

        return sb.toString();
    }

    /**
     * 找出数组里面长度最小的字符串
     *
     * @param strs
     * @return
     */
    private String getValue(String[] strs) {
        String string = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (string.length() > strs[i].length()) {
                string = strs[i];
            }
        }
        return string;
    }

}
