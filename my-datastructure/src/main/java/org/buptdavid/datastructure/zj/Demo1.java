package org.buptdavid.datastructure.zj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，
 * 但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力
 */
public class Demo1 {
    static int key=0;
    static int value=0;
    private static final double tmp=0.5;
    private static final int   day =3;//N天
    private static final int   food =7;//M块巧克力
    public static void main(String[] args) {

        while (true){

            Map<Integer,Integer> map=new HashMap<Integer, Integer>();
            map.put(key,value);
            key++;value++;
            double result = exce(map);
            if(result!=-1){
                System.out.println("第一天最多吃"+result+"块巧克力");
                break;
            }

        }
    }
    public static double  exce(Map<Integer,Integer> map){
//        1     x
//        2     x+x*0.5
//        3     x+(x*0.5)+(x*0.5)*0.5
//        ...
        double sum=0;
        int key =0;
        double temp=0;
        double onday=0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            sum=entry.getValue();
            key = entry.getKey();
            onday=sum;

        }
        for (int i = 2; i <=day; i++) {
            temp=onday*tmp;
            sum+=temp;
            onday=temp;
        }
        System.out.println("如果第一天吃"+key+"块，那么到父母出差回来总共吃了"+sum+"块");
        if(sum >=food){
           return  key;
        }
        return  -1;
    }
}
