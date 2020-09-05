package org.buptdavid.datastructure.zj.刷;


/**
 * @author jiezhou
 * @CalssName: Solution9
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description: 判断一整数是否是一个回文数
 * @date 2020/8/7/16:11
 */
public class Solution9 {

    public static void main(String[] args) {
        int i = 121;
        boolean palindrome = new Solution9().isPalindrome(i);
        System.out.println(palindrome);

    }

    public boolean isPalindrome(int x) {
        /*if (x < 0) {
            return false;
        }
        if (x / 10 == 0) {
            return true;
        }

        List<Integer> ls = new ArrayList<>();
        int i = x / 10;
        ls.add(x % 10);
        while (i != 0) {
            ls.add(i % 10);
            i = i / 10;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("@");
        for (int j = 0; j < ls.size(); j++) {
            sb.append("#");
            sb.append(ls.get(j));
        }
        sb.append("#");
        sb.append("&");
        //马拉夫算法

        int left = sb.length() / 2;
        int right = sb.length() / 2;
        while (sb.charAt(left) == sb.charAt(right)) {
            left--;
            right++;
        }
        if (sb.charAt(left) == '@') {
            return true;
        }
        return false;*/


        //解法二
        if (x < 0) {
            return false;
        }
        if (x / 10 == 0) {
            return true;
        }

        String s = x + "";
        int mid = s.length() / 2;

        StringBuilder sb = new StringBuilder();
        int k = s.length() - 1;
        if (s.length() % 2 == 0) {//偶数
            while (k >= mid) {
                sb.append(s.charAt(k));
                k--;
            }
            int i1 = Integer.parseInt(s.substring(0, mid));
            int i = Integer.parseInt(sb.toString());
            if (i == i1) {
                return true;
            } else {
                return false;
            }
        } else {
            while (k > mid) {
                sb.append(s.charAt(k));
                k--;
            }
            int i1 = Integer.parseInt(s.substring(0, mid));
            int i = Integer.parseInt(sb.toString());
            if (i == i1) {
                return true;
            } else {
                return false;
            }
        }


    }
}
