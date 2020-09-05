package org.buptdavid.datastructure.zj.刷;

import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public static void main(String[] args) {
        int length = new Solution3().lengthOfLongestSubstring("pwwkew");
        System.out.println(length);


    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Map map = new HashMap<>();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int start, ans = 0, end;
        for (start = 0, end = 0; end < s.length(); end++) {
            char key = s.charAt(end);
            if (map.containsKey(s.charAt(end))) {
                start = Math.max((int)map.get(key), start);
            }
            map.put(s.charAt(end), end + 1);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
        /*int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;*/
    }
}