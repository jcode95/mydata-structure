package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.双指针;

import java.util.*;

/**
 * @author jiezhou
 * @CalssName: LetterCombinations17
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.双指针
 * @Description:电话号码组合
 * @date 2021/1/8/11:58
 */
public class LetterCombinations17 {
    List<String> resultList = new ArrayList<>();

    public static void main(String[] args) {
        new LetterCombinations17().letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = init();
        if (digits==null||digits=="") {
            resultList.add("");
            return resultList;
        }
        process(digits, 0, new StringBuilder(), map);
        System.out.println(Arrays.toString(resultList.toArray()));
        return resultList;
    }

    private void process(String digits, int i, StringBuilder stringBuilder, Map<Character, String> map) {
        if (i == digits.length()) {
            resultList.add(stringBuilder.toString());
            return;
        }
        String var = map.get(digits.charAt(i));
        for (int j = 0; j < var.length(); j++) {
            StringBuilder sb = new StringBuilder(stringBuilder);
            sb.append(var.charAt(j));
            process(digits, i + 1, sb, map);
        }
    }


    private Map<Character, String> init() {
        HashMap<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }
}
