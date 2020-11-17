package org.buptdavid.datastructure.zj.thread.test;

/**
 * 单例设计模式
 */
public class Singletion {

    public static int STATUS=1;

    private Singletion(){
        System.out.println("Singletion is  create ....");
    }

    private static Singletion singletion=new Singletion();

    public static Singletion getInstance(){
        return singletion;
    }


}
