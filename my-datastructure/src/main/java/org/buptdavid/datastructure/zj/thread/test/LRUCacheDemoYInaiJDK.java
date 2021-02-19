package org.buptdavid.datastructure.zj.thread.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jiezhou
 * @CalssName: LRUCacheDemoYInaiJDKYInaiJDK
 * @Package org.buptdavid.datastructure.zj.thread.test
 * @Description: LRU算法依赖jdk实现
 * @date 2021/2/19/19:57
 */
public class LRUCacheDemoYInaiJDK<K, V> extends LinkedHashMap<K, V> {

    private int capacity;//缓存坑位....

    public LRUCacheDemoYInaiJDK(int capacity) {
        super(capacity, 0.75F, false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemoYInaiJDK LRUCacheDemoYInaiJDK = new LRUCacheDemoYInaiJDK(3);

        LRUCacheDemoYInaiJDK.put(1, "a");
        LRUCacheDemoYInaiJDK.put(2, "b");
        LRUCacheDemoYInaiJDK.put(3, "c");
        System.out.println(LRUCacheDemoYInaiJDK.keySet());

        LRUCacheDemoYInaiJDK.put(4, "d");
        System.out.println(LRUCacheDemoYInaiJDK.keySet());

        LRUCacheDemoYInaiJDK.put(3, "c");
        System.out.println(LRUCacheDemoYInaiJDK.keySet());
        LRUCacheDemoYInaiJDK.put(3, "c");
        System.out.println(LRUCacheDemoYInaiJDK.keySet());
        LRUCacheDemoYInaiJDK.put(3, "c");
        System.out.println(LRUCacheDemoYInaiJDK.keySet());
        LRUCacheDemoYInaiJDK.put(5, "x");
        System.out.println(LRUCacheDemoYInaiJDK.keySet());
    }
}
