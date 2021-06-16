package org.buptdavid.datastructure.zj;

import java.util.Calendar;
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
        /*Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String var = sc.nextLine();
            System.out.println(process(var));

        }*/
        System.out.println(" = "+ getTimeUnix(1));



    }

    public static int getTimeUnix(int dayofweek) {

        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE),0,0,0);
        int day = cal.get(Calendar.DAY_OF_WEEK) - 1;
        cal.set(Calendar. DAY_OF_WEEK, Calendar.SUNDAY);

        if(day>=dayofweek){
            dayofweek+=7;
        }
        cal.add(Calendar.DATE, dayofweek);

        return (int)(cal.getTimeInMillis()/1000);
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
