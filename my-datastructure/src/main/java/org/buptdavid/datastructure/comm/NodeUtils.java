package org.buptdavid.datastructure.comm;

import java.util.Random;

/**
 * @author zhoujie
 * @CalssName: NodeUtils
 * @Package org.buptdavid.datastructure.comm
 * @Description:
 */
public class NodeUtils {
    static Random random = new Random();

    public static ListNode createNode(int length, int randomMax) {
        ListNode head = null;
        ListNode listNode = null;
        for (int i = 0; i < length; i++) {
            ListNode node = new ListNode(random.nextInt(randomMax) + 1);
            if (head == null) {
                head = node;
                listNode = head;
            } else {
                listNode.next = node;
                listNode = listNode.next;
            }
        }
        return head;
    }


}
