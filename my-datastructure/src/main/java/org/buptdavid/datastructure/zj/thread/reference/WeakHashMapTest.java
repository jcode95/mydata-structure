package org.buptdavid.datastructure.zj.thread.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author jiezhou
 * @CalssName: WeakHashMap
 * @Package org.buptdavid.datastructure.zj.thread.reference
 * @Description:
 * @date 2021/2/23/20:11
 */
public class WeakHashMapTest {
    public static void main(String[] args) {

        myHashMap();
    }

    private static void myHashMap() {
        /*强引用的hashmap*/
        HashMap<Object, Object> map = new HashMap<>();
        String v = new String("aaa");
        String k = new String("k1");
        map.put(k, v);
        System.out.println("map = " + map);
        k = null;
        System.gc();
        System.out.println("map = " + map);

//        new TreeMap<>().put()

        System.out.println("======================== ");
         /*弱引用的hashmap */
//        String k1 = "kkk";//java 1.8 是在元空间  1.7是在方法区
        String k1 = new String("kkk");//在堆内存，测试WeakHashMap必须要使用堆内存
        String v1 = new String("v1");
        WeakHashMap<String, Object> weakHashMap = new WeakHashMap<String, Object>();
        weakHashMap.put(k1, v1);
        System.out.println("weakHashMap = " + weakHashMap);
        k1 = null;
        System.gc();
        System.out.println("weakHashMap = " + weakHashMap);
//        Map<String, Object> synchronizedMap = Collections.synchronizedMap(weakHashMap);

    }


}

