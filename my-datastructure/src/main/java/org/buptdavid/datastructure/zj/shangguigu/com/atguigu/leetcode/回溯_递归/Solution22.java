package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.回溯_递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: Solution22
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description:
 * @date 2021/7/22/13:55
 */
public class Solution22 {
    public static void main(String[] args) {
        List<String> strings = new Solution22().generateParenthesis(2);
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        dfs(list, 0, 0, n, new StringBuilder());
        return list;


    }

    /** 回溯（递归算法）
     * @param list
     * @param left
     * @param right
     * @param n
     * @param currString
     */
    private void dfs(ArrayList<String> list, int left, int right, int n, StringBuilder currString) {
        if (left == n && right == n) {
            list.add(currString.toString());
            return;
        }
        if (left < right) {
            return;
        }

        if (left < n) {
            currString.append("(");
            dfs(list, left + 1, right, n, currString);
            currString.deleteCharAt(currString.length() - 1); // 回溯到添加前的转态
        }
        if (right < n) {
            currString.append(")");
            dfs(list, left, right + 1, n, currString);
            currString.deleteCharAt(currString.length() - 1); // 回溯到添加前的转态
        }
    }
}
