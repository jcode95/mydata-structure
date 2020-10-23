package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

import java.util.LinkedList;
import java.util.List;

public class LinkedArrarListTest {

    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(1);
        list.add(7);
        list.add(4);
        list.add(3);
        list.add(2);
//        TreeSet<Integer> list = new TreeSet<>();
//        list.add(1);
//        list.add(7);
//        list.add(4);
//        list.add(3);
//        list.add(2);
        for (Object o : list) {
            System.out.println(o);
        }

    }
}
