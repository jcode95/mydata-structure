package org.buptdavid.datastructure.zj;

import java.util.Scanner;

/**
 * @author jiezhou
 * @CalssName: Mian1
 * @Package org.buptdavid.datastructure.zj
 * @Description: 字符串反转（不是字母的字符还在原来的位置）
 * @date 2020/7/28/15:29
 */
public class Mian1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String var = sc.nextLine();
            System.out.println(process(var));

        }

    }

    private static String process(String var) {
        char[] c = var.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while (i <= j ) {
            if (!chack(c[i])) {//不是字母（包括大小写）
                i++;
            } else if (!chack(c[j])) {//不是字母（包括大小写）
                j--;
            } else {//是字母交换
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        return new String(c);
    }

    /**
     * 校验 字符是否是字母（包括大小写）
     *
     * @param c
     * @return
     */
    private static boolean chack(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}
