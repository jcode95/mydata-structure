package org.buptdavid.datastructure.LRU;

/**
 * @author jiezhou
 * @CalssName: LRUAction
 * @Package org.buptdavid.datastructure.LRU
 * @Description: 操作
 * @date 2020/7/27/17:15
 */
public class LRUAction<K,V> {

    /**
     * 添加元素的时候首先判断是不是新的元素，如果是新元素，判断当前的大小是不是大于总容量了，
     * 防止超过总链表大小，如果大于的话直接抛弃最后一个节点，
     * 然后再以传入的key\value值创建新的节点。对于已经存在的元素，
     * 直接覆盖旧值，再将该元素移动到头部，然后保存在map中
     * @param key
     * @param value
     */
    public void put(K key,V value){



    }
}
