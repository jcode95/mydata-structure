package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jiezhou
 * @CalssName: GreedyAlgorithm
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.greedy
 * @Description: 贪心算法,一个问题分为很多步，每步取最优，但不一定能保证最终结果最优
 * @date 2020/9/2/16:46
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        //创建广播电台，放入map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        //创建ArrayList, 存放选择的电台集合
        ArrayList<String> selects = new ArrayList<String>();

        //定义一个临时的集合， 在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<String>();

        //定义给maxKey ， 保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台的key
        //如果maxKey 不为null , 则会加入到 selects
        String maxKey = null;
        int maxSize = 0;
        while (allAreas.size() != 0) {
            //遍历 broadcasts, 取出对应key
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);//求出tempSet 和   allAreas 集合的交集, 交集会赋给 tempSet
                if (tempSet.size() > maxSize) {
                    maxSize=tempSet.size();
                    maxKey=key;
                }
            }
            allAreas.removeAll(broadcasts.get(maxKey));//删掉
            selects.add(maxKey);
            maxSize=0;//重置
            maxKey=null;//重置
        }
        System.out.println(selects);
    }
}
