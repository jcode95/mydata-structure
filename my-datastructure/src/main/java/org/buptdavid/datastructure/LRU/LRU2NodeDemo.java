package org.buptdavid.datastructure.LRU;
/**
 * @author jiezhou
 * @CalssName: LRU2Node
 * @Package com.cn.redis.boot1.redisboot1.utils
 * @Description: 自定义链表node来实现LRU算法
 * @date 2020/11/26/1:00
 */
public class LRU2NodeDemo {
    public static void main(String[] args) {
        LRU2Node lru2Node = new LRU2Node(3);
        lru2Node.put(1, "a");
        lru2Node.put(2, "b");
        lru2Node.put(3, "c");
        lru2Node.put(4, "d");
        lru2Node.put(5, "e");
        lru2Node.listNodes();
        lru2Node.put(6, "f");
        lru2Node.listNodes();
    }

    static class LRU2Node<K, V> {
        private Node<K, V> head;//队列头部
        private Node<K, V> tail;//队列尾部
        private int capacity;//因子

        LRU2Node(int capacity) {
            this.capacity = capacity;
        }

        /**
         * 获取链表的长度是否等于capacity,等于了就需要吧tail节点移除，然后再吧当前节点放到头节点，其他后移
         */
        private void put(K key, V value) {
            Node<K, V> newNode = new Node<K, V>(key, value);
            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            if (getNodeslength(head) >= capacity) {
                //移除最后一个节点
                tail = tail.pre;
                tail.next = null;
            }
            Node node = head;
            head = newNode;
            newNode.next = node;
            node.pre = newNode;
        }

        /**
         * 打印所有节点
         */
        public void listNodes() {
            StringBuilder sb = new StringBuilder();
            if (head == null) {
                return;
            }
            sb.append("[");
            Node node = head;
            do {
                sb.append(" " + node.key + " ");
                node = node.next;
            } while (node != null);
            sb.append("]");
            System.out.println(sb.toString());
        }

        /**
         * 获取节点的长度
         *
         * @param head
         */
        private int getNodeslength(Node head) {

            if (head == null) {
                return 0;
            }
            int length = 1;
            Node node = head;
            while (node.next != null) {
                length++;
                node = node.next;
            }
            return length;
        }
    }

    static class Node<K, V> {
        private K key;
        private V value;
        Node pre;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
