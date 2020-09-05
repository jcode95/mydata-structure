package org.buptdavid.datastructure.zj;

public class Demo2Test {

    public static void main(String[] args) {
        Demo2 instance = Demo2.INSTANCE;
        Demo2 instance1 = Demo2.INSTANCE1;
        if (instance == instance1) {
            System.out.println("同一个对象");
        } else System.out.println("不是同一个对象");

       /* String msg="AA.bb；c；";
        String[] str = msg.trim().split("[：:；; .]");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }*/


    }


}
