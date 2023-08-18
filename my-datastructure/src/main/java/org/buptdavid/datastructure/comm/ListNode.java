package org.buptdavid.datastructure.comm;

/**
 * @author jiezhou
 * @CalssName: ListNode
 * @Package org.buptdavid.datastructure.zj.刷
 * @Description:
 * @date 2020/8/3/14:07
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 打印节点
     */
    public void print() {
        ListNode head = this;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val).append(",");
            head = head.next;
        }
        String resultStr = sb.toString();
        if (sb.lastIndexOf(",") > 0) {
            resultStr = sb.substring(0, sb.lastIndexOf(","));
        }
        resultStr += "]";
        System.out.println(resultStr);
    }
}
