package org.buptdavid.datastructure.zj.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo1 {


    public static void main(String[] args) {
//        ConcurrentSkipListMap<Integer, Integer> integerIntegerConcurrentSkipListMap = new ConcurrentSkipListMap<Integer, Integer>();
        HashMap<Integer, Integer> integerIntegerConcurrentSkipListMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < 100;i++ ) {
            if(i%2==0){
                integerIntegerConcurrentSkipListMap.put(i,i+10);
            }else{
                integerIntegerConcurrentSkipListMap.put(i,i+100);
            }
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : integerIntegerConcurrentSkipListMap.entrySet()) {
            System.out.println(integerIntegerEntry.getKey()+"========"+integerIntegerEntry.getValue());

        }

//        int a=24;
//        int b=a >>> 24;
//        System.out.println("b="+b);
    }


}
