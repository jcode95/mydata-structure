package org.buptdavid.datastructure.LRU;

/**
 * @author jiezhou
 * @CalssName: Node
 * @Package org.buptdavid.datastructure.LRU
 * @Description:
 * @date 2020/7/27/17:07
 */
public class Node {

    //键
    Object key;
    //值
    Object value;
    //上一个节点
    Node pre;
    //下一个节点
    Node next;

    Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

}
