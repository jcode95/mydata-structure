package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author jiezhou
 * @CalssName: PoLangNotation
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.stack
 * @Description: 逆波兰表达式计算器
 * @date 2020/8/12/16:53
 */
public class PoLangNotation {
    public static void main(String[] args) {
//        String str = "3 4 + 5 * 6 -";//逆波兰表达式((3+4)*5-6=29)
//        String str = "93 99 + 2 / 4 5 + 2 / - 11 + 7 -";//逆波兰表达式  (93+99)/2-(4+5)/2+11-7
//        String str = "1 2 3 + 4 * + 5 -";//逆波兰表达式  (93+99)/2-(4+5)/2+11-7
        //1、将str放入arraylist
        //计算逆波兰表达式
        String s = new PoLangNotation().processPoLang("1+((2+3)*4)-5");
        System.out.println(s);
        System.out.println("---------------------");
        List<String> ls = getListString(s);
        double result = call(ls);
        System.out.println(result);
    }

    /**
     *  通过中缀表达式获取后缀表达式（逆波兰表达式）
     * @param string  1+((2+3)*4)-5
     * @return 1 2 3 + 4 * + 5 -
     */
    public String processPoLang(String string) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();//字符栈
        Stack<String> s2 = new Stack<>();//数字栈
        int index = 0;
        while (index < string.length()) {
            int tmp = 0;
            String currStr = string.charAt(index) + "";
            if (chackNum(string.charAt(index + tmp))) {//遇到操作数
                while (index + tmp + 1 < string.length() && chackNum(string.charAt(index + tmp + 1))) {
                    tmp++;
                }
                s2.push(string.substring(index, index + tmp + 1));

            } else if (isNotation(currStr)) {//遇到运算符
                boolean flg = true;
                while (flg) {
                    String currOP = currStr;
                    if (s1.isEmpty()) {
                        s1.push(currOP);
                        flg = false;
                    } else {
                        String upOP = s1.peek();//获取栈顶元素，不出栈
                        if (s1.isEmpty() || chackNotation(upOP, currOP) || upOP.equals("(")) {
                            s1.push(currStr);
                            flg = false;
                        } else {
                            s2.push(s1.pop());
                            flg = true;
                        }
                    }
                }
            } else if (isBracket(currStr)) {//遇到括号
                if (currStr.equals("(")) {
                    s1.push(currStr);
                } else {
                    while (!s1.isEmpty()) {
                        String var = s1.pop();
                        if (var.equals("(")) {
                            break;
                        }
                        s2.push(var);
                    }
                }
            }
            index = index + tmp + 1;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        StringBuilder sb = new StringBuilder();
        List<String> ls = new ArrayList<>();
        while (!s2.isEmpty()) {
            ls.add(s2.pop());
        }
        Collections.reverse(ls);
        for (int i = 0; i < ls.size(); i++) {
            sb.append(ls.get(i));
            sb.append(" ");
        }
        String substring = sb.substring(0, sb.length() - 1);
        return substring;
    }

    /**
     * 校验是否运算符
     *
     * @param s
     * @return
     */
    private boolean isNotation(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }

    /**
     * 校验是否是括号
     *
     * @param c
     * @return
     */
    private boolean isBracket(String c) {
        if (c.equals("(") || c.equals(")")) {
            return true;
        }
        return false;
    }

    /**
     * c 的优先级比s高 true 否则返回false
     *
     * @param s
     * @param c
     * @return
     */
    private boolean chackNotation(String s, String c) {
        if (c.equals("*") || c.equals("/")) {
            if (s.equals("+") | s.equals("-")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验是否为数字
     *
     * @param c
     * @return
     */
    private static boolean chackNum(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * 计算 后缀表达式（逆波兰表达式）
     * @param ls
     * @return
     */
    private static double call(List<String> ls) {
        //创建一个栈
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < ls.size(); i++) {
            String s = ls.get(i);
            if (s.matches("\\d+")) {
                //直接入栈
                stack.push(s);
            } else {
                double a = Double.parseDouble(stack.pop());
                double b = Double.parseDouble(stack.pop());
                double res = processOP(a, b, s);
                stack.push(res + "");
            }
        }
        //最后留在stack中的值就是结果
        return Double.parseDouble(stack.pop());

    }

    private static double processOP(double var, double var1, String op) {
        double result = 0;
        switch (op) {
            case "+":
                result = var + var1;
                break;
            case "-":
                result = var1 - var;
                break;
            case "*":
                result = var * var1;
                break;
            case "/":
                result = var1 / var;
                break;
        }
        return result;
    }

    private static List<String> getListString(String str) {
        String[] split = str.split(" ");
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            ls.add(split[i]);
        }
        return ls;
    }
}
