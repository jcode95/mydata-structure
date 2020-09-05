package org.buptdavid.datastructure.zj;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {

    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        String s = getLists(list);
        System.out.println(s);

        List<Integer> list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        Integer integer = getLists(list1);
        System.out.println(integer);
        Integer sd=1;
        Class<? extends Integer> aClass = sd.getClass();
        if(aClass.isPrimitive()){
            System.out.println("是基本数据类型");
        }

        List<? extends String> list2=new ArrayList<String>();
//        list2.add("sd");
    }

    public static <F> F getLists(List<F> data){
        return data.get(0);
    }

    private  <T> T getListc(T data){
        return (T)data;
    }


}
