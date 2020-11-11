package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.linkedlist;

import java.util.Objects;

/**
 * @author jiezhou
 * @CalssName: CircularLinkedList
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.linkedlist
 * @Description: 单向环形链表（约瑟夫问题，丢手帕问题）
 * @date 2020/8/11/12:17
 */


public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList linkedList = new CircularLinkedList();
        linkedList.add(5);
        linkedList.list();
        System.out.println("----------------");
        linkedList.del1(3);
        CircularNode node = new CircularNode(5, 5 + "", 5 + "");
        CircularNode upNode = linkedList.getUpNode(node);
        linkedList.list();
        System.out.println("-------约瑟夫---------");
        String countBoy = linkedList.countBoy(1, 2);
        System.out.println(countBoy);

    }
}

class CircularLinkedList {
    private CircularNode first;

    //添加节点，构建成环形链表
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("nums:" + nums + "error");
        }
        CircularNode curr = null;//辅助节点
        for (int i = 0; i < nums; i++) {
            CircularNode node = new CircularNode(i, i + "", i + "");
            //如果是第一个
            if (i == 0) {
                first = node;
                first.next = node;
                curr = first;
            } else {
                curr.next = node;
                node.next = first;
                curr = node;
            }
        }

    }

    //遍历当前环形链表
    public void list() {
        CircularNode tmp = first;
        if (tmp == null) {
            System.out.println("链表为空！");
            return;
        }
        while (true) {
            System.out.println(tmp);
            if (tmp.next == first) {
                break;
            }
            tmp = tmp.next;
        }
    }

    /**
     * 丢手帕（约瑟夫）问题
     *
     * @param startId 开始的位置节点id
     * @param skip    跳跃多少个,也就是数到skip的人出列
     * @return 出队的序列
     */
    public String countBoy(int startId, int skip) {
        //校验startNode是否存在和skip是否超过环形链表的长度(待写)~~~
        //~~~~~~

        StringBuilder sb = new StringBuilder();
        CircularNode tmp = first;
        if (tmp == null) {
            System.out.println("链表为空，出队失败！");
            return null;
        }
        CircularNode skipNode = null;
        CircularNode startNode = getNode(startId);
        if (startNode == null) {
            System.out.println("节点未在链表中找到！");
            return null;
        }
        while (tmp != null) {
            for (int i = 1; i < skip; i++) {
                skipNode = startNode.next;
                startNode = startNode.next;
            }
            //重置start
            startNode = skipNode.next;
            //删除
            if (skipNode != null) {
                sb.append(skipNode.id + "-->");
                del(skipNode.id);
            }
            tmp = first;
        }

        return sb.substring(0, sb.length() - 3);
    }

    /**
     * 获取指定节点
     *
     * @param id
     * @return
     */
    public CircularNode getNode(int id) {
        CircularNode tmp = first;
        if (tmp == null) {
            System.out.println("链表为空！");
            return null;
        }
        while (true) {
            if (tmp.next == first) {
                break;
            }
            if (tmp.id == id) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    //删除节点，删除之后还是环形链表
    public void del1(int id) {
        CircularNode delNode = getNode(id);
        CircularNode tmp = first;
        if (delNode == null) {
            System.out.println("不能删除空节点！");
            return;
        }
        if (tmp == null) {
            System.out.println("链表为空，删除失败！");
            return;
        }
        if (tmp.next.equals(first)) {
            if (first.equals(delNode)) {
                first.next = null;
                first = null;
            }
        }
        //获取指定节点的前一个节点
        CircularNode upNode = getUpNode(delNode);
        if (upNode == null) {
            System.out.println("找不到要删除的节点的上一个节点！");
            return;
        }
        if (upNode.equals(delNode)) {//是当前本身，也就是说当前环形链表只有一个节点，并且删除的节点就是当前的节点
            first.next = null;
            first = null;
            return;
        }
        upNode.next = delNode.next;
    }

    /**
     * 获取指定节点的上一个节点
     *
     * @param node
     * @return
     */
    public CircularNode getUpNode(CircularNode node) {
        if (first == null) {
            return null;
        }
        CircularNode currNode = first;
        while (true) {
            if (currNode.next.equals(node)) {
                return currNode;
            }
            if (currNode.next.equals(first)) {//没有找到
                return null;
            }
            currNode = currNode.next;
        }
    }

    //删除节点，删除之后还是环形链表
    public void del(int id) {
        CircularNode delNode = new CircularNode(id, id + "", id + "");
        CircularNode tmp = first;
        if (delNode == null) {
            System.out.println("不能删除空节点！");
            return;
        }
        if (tmp == null) {
            System.out.println("链表为空，删除失败！");
            return;
        }
        CircularNode upNode = null;
        while (true) {
            if (tmp.next.equals(first)) {
                if (tmp.equals(delNode)) {//找到要删除的节点了,此时是需要删除的最后一个节点（注意，如果是只有一个节点的情况要处理）
                    if (first.next.equals(first)) {
                        //只有一个节点且是循环依赖自身,直接让其等于null
                        first.next = null;
                        first = null;
                    } else {
                        upNode.next = first;
                    }
                }
                break;
            }
            if (tmp.equals(delNode)) {  //找到要删除的节点了
                if (tmp.equals(first)) {//如果要删除的是第一个节点
                    CircularNode lastNode = getLastNode();
                    first = tmp.next;
                    //修改最后一个节点
                    lastNode.next = first;
                } else {
                    upNode.next = tmp.next;
                }
                break;
            }
            upNode = tmp;
            tmp = tmp.next;
        }
    }

    /**
     * 获取最后一个节点
     *
     * @return
     */
    public CircularNode getLastNode() {
        CircularNode tmp = first;
        if (tmp == null) {
            System.out.println("链表为空！");
            return null;
        }
        while (true) {
            if (tmp.next == first) {
                return tmp;
            }
            tmp = tmp.next;
        }
    }
}

class CircularNode {
    public int id;
    private String name;
    private String nickName;
    public CircularNode next;


    public CircularNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "CircularNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircularNode that = (CircularNode) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(nickName, that.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickName, next);
    }
}
