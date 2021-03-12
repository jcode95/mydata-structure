package org.buptdavid.datastructure.zj;

import java.util.*;

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

        Map<Integer, Long> recycleMoneyLimit = new HashMap<Integer, Long>();//装备等阶回收上限元宝 key=阶数 value=已经回收的得到元宝
        for (int i = 0; i < 30; i++) {
            int v = i + 1000;
            recycleMoneyLimit.put(i, Long.parseLong(v+""));
        }
        StringBuffer str = new StringBuffer();
        Set<Map.Entry<Integer, Long>> info = recycleMoneyLimit.entrySet();
        if (info != null && info.size() > 0) {
            for (Map.Entry<Integer, Long> var : info) {
                str.append(var.getKey());
                str.append(";");
                str.append(var.getValue());
                str.append("#");
            }
        }
        String substring = str.substring(0, str.length()-1);
        System.out.println("substring = " + substring);
    }

    public static <F> F getLists(List<F> data){
        return data.get(0);
    }

    private  <T> T getListc(T data){
        return (T)data;
    }


}
