package org.buptdavid.datastructure.zj.刷;


/**
 * @author jiezhou
 * @CalssName: Solution5
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 最长回文字串
 * @date 2020/8/5/15:54
 * <p>
 * <p>
 * // 输入: "babad"
 * //输出: "bab"
 * //注意: "aba" 也是一个有效答案。
 */
public class Solution5 {

    public static void main(String[] args) {
//        String s = "cinoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        String s = "babad";
//        String str = new Solution5().longestPalindromeManacher(s);
        String str = new Solution5().longestPalindrome(s);
        System.out.println(str);//ranynar
    }

    //------------------------------暴力法---------------------------------------------------
   /* public String longestPalindrome(String s) {
        if (s == null || s == "" || s.length() <= 0) {
            return "";
        }
        List<String> ls = process(s);//所有的字串
        int max = ls.get(0).length();
        String result = ls.get(0);
        for (int i = 0; i < ls.size(); i++) {
            if (chack(ls.get(i))) {//判断是否是回文字串
                if (max <= ls.get(i).length()) {
                    max = ls.get(i).length();
                    result = ls.get(i);
                }
            }
        }
        return result;
    }

    private boolean chack(String s) {
        boolean flg = true;
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i] != chars[j]) {
                flg = false;
                break;
            }
            i++;
            j--;
        }
        return flg;

    }

    private List<String> process(String s) {
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                ls.add(s.substring(i, j + 1));
            }

        }
        return ls;
    }
*/
    //------------------------------Manacher(马拉车)算法（时间复杂度O(n)）---------------------------------------------------
    public String longestPalindrome(String s) {
        if (s == null || s == "" || s.length() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("@");
        for (int i = 0; i <= s.length() - 1; i++) {//除去数组的最开始和最后面不需要处理
            char c = s.charAt(i);
            sb.append("#").append(c);
        }
        sb.append("#");
        sb.append("&");
        String string = sb.toString();
        String result = processMy(string);
        result = result.replace("#", "");
        return result;
    }

    /**
     * @param string
     * @return
     */
    private String processMy(String string) {
        char[] array = string.toCharArray();
        int max = 0;
        String maxString = array[1] + "";
        int index;
        for (int j = 1; j < array.length - 1; j++) {
            index = j;
            int left = index;
            int right = index;
            int tmpMax = 0;
            while (array[left] == array[right]) {
                tmpMax += 1;
                left--;
                right++;
            }
            if (tmpMax > max) {
                max = tmpMax;
                maxString = string.substring(left+1, right);
            }
        }
        return maxString;
    }


}
