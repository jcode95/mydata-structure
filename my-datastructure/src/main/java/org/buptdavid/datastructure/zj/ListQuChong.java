package org.buptdavid.datastructure.zj;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jiezhou
 * @CalssName: ListQuChong
 * @Package org.buptdavid.datastructure.zj.学习笔记
 * @Description:list 去重
 * @date 2021/12/7/19:57
 */
public class ListQuChong {
    private static List<Integer> tarList=new ArrayList<>();
    static {
        tarList.add(1);
        tarList.add(3);
        tarList.add(5);
        tarList.add(3);
        tarList.add(6);
        tarList.add(7);
        tarList.add(9);
        tarList.add(5);
        tarList.add(3);
        tarList.add(2);
        tarList.add(8);
        System.out.println("原来集合  = " + tarList);
    }

    public static void main(String[] args) {
        method_1();
        System.out.println("-------------------");
        method_2();
        System.out.println("-------------------");
        method_3();
        System.out.println("-------------------");
        method_4();
        System.out.println("-------------------");
        method_5();
        System.out.println("-------------------");
        method_6();
    }

    public static void method_1(){
        //contains判断去重 有序
        ArrayList<Integer> integers = new ArrayList<>(tarList.size());
        tarList.forEach(e->{
            if(!integers.contains(e)){
                integers.add(e);
            }
        });
        System.out.println("去重后集合 = " + integers);
    }
    public static void method_2(){
        //迭代器去重 无序
        List<Integer> ls=tarList;
        //contains判断去重
        Iterator<Integer> iterator = ls.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(ls.indexOf(next)!=ls.lastIndexOf(next)){
                iterator.remove();
            }
        }
        System.out.println("去重后集合 = " + ls);
    }
    public static void method_3(){
        //HashSet 无序
        List<Integer> ls=tarList;
        //contains判断去重
        HashSet<Integer> set = new HashSet<>(ls);
        System.out.println("去重后集合 = " + set);
    }
    public static void method_4(){
        //LinkedHashSet 有序
        List<Integer> ls=tarList;
        //contains判断去重
        LinkedHashSet<Integer> set = new LinkedHashSet<>(ls);
        System.out.println("去重后集合 = " + set);
    }
    public static void method_5(){
        //TreeSet 有序
        List<Integer> ls=tarList;
        //contains判断去重
        TreeSet<Integer> set = new TreeSet<>(ls);
        System.out.println("去重后集合 = " + set);
    }
    public static void method_6(){
        //Stream 有序
        List<Integer> ls=tarList;
        //contains判断去重
        List<Integer> list = ls.stream().distinct().collect(Collectors.toList());
        System.out.println("去重后集合 = " + list);
    }

}
