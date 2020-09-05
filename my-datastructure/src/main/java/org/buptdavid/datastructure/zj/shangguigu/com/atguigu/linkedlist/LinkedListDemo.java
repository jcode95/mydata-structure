package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.linkedlist;

/**
 * @author jiezhou
 * @CalssName: LinkedListDemo
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.linkedlist
 * @Description: 单链表
 * @date 2020/8/11/10:24
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "zhansan", "张三");

        Node node3 = new Node(3, "lisi", "李四");
        Node node2 = new Node(2, "wnagwu", "王五");
        Node node6 = new Node(6, "666", "666");
        LinkedList linkedList = new LinkedList();
        linkedList.add(node1);
        linkedList.add(node3);
        linkedList.list();
        System.out.println("--------------------");
        linkedList.add(node2);
        linkedList.list();
        System.out.println("--------------------");
        linkedList.add(node2);
        linkedList.add(node6);
        linkedList.list();

        System.out.println("----------edit-------------");
        linkedList.edit(1, "猪八戒", "天蓬元帅");
        linkedList.list();

        int size = linkedList.getSize();
        System.out.println("SIZE:" + size);

        System.out.println("----------remove-------------");
        linkedList.remove(6);
        linkedList.list();
        System.out.println("----------getSize-------------");
        size = linkedList.getSize();
        System.out.println("SIZE:" + size);
        System.out.println("----------getNodeByK-------------");
        int i=1;
        Node k = linkedList.getNodeByK(i);
        System.out.println("倒数第：+"+i+"个："+ k);
        System.out.println("----------reversalNode-------------");
        linkedList.reversalNode();
        linkedList.list();
    }
}

class LinkedList {
    private Node headNode;

    //添加操作
    public void add(Node node) {
        Node temp = headNode;
        if (temp == null) {
            headNode = node;
        } else {
            while (true) {
                if(node.equals(temp)){
                    System.out.println("已经存在，不能重复添加");
                    break;
                }
                if (temp.next == null) {
                    temp.next = node;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    //添加操作(按照id大小插入)
    public void addByOrder(Node node) {
        Node temp = headNode;
        if (temp == null) {
            headNode = node;
        } else {
            while (true) {
                if (temp.next == null) {
                    temp.next = node;
                    break;
                }
                if (temp.next.id > node.id) {//此时temp节点就是我们要找的节点
                    node.next = temp.next;
                    temp.next = node;
                    break;
                } else if (temp.next.id == node.id) {
                    System.out.println("编号：" + node.id + "，已经存在不能加入！");
                    break;
                }
                temp = temp.next;
            }
        }
    }

    /**
     * 反转链表
     */
    public void reversalNode() {
        Node temp = headNode;
        if (temp == null) {
            System.out.println("链表为空，不能反转！");
            return;
        }
        if (temp.next == null) {
            System.out.println("链表只有一个节点，不能反转！");
            return;
        }
        int right = getSize() - 1;//得到链表的有效下标
        int left = 0;
        Node reversalNode = null;
        //最后一个单独处理
        if (reversalNode == null) {
            reversalNode = getNodeBy(right);
        }
        Node tempReversalNode = reversalNode;
        right--;
        while (left <= right) {//注意，这里可能会出现环
            Node nodeBy = getNodeBy(right);
            nodeBy.next = null;//把他的下一个指向null，否则可能会出现环
            tempReversalNode.next = nodeBy;
            right -= 1;
            tempReversalNode = tempReversalNode.next;
        }
        this.headNode = reversalNode;
    }

    public Node getNodeBy(int index) {
        Node temp = headNode;
        if (index < 0 || index >= getSize()) {
            return null;
        }
        int s = 0;
        while (true) {
            if (temp == null) {
                break;
            }
            if (index == s) {
                return temp;
            }
            s++;
            temp = temp.next;
        }
        return null;
    }


    //根据id来删除指定的节点
    public void remove(int id) {
        Node temp = headNode;
        Node var = null;//前一个Node
        if (temp == null) {
            System.out.println("链表为空，不能删除...");
        }
        //处理头结点
        if (temp.id == id) {
            headNode = temp.next;
            return;
        }
        while (true) {
            //到最后的节点
            if (temp == null) {
                break;
            }
            if (temp.id < id) {//找到前一个
                var = temp;
            } else if (temp.id == id) {//找到之后，就停止了，此时的temp就是id的node
                break;
            }

            temp = temp.next;
        }

        //走到这代表遍历完了链表
        if (var != null) {
            if (temp != null) {
                //找到了
                var.next = var.next.next;
                System.out.println("删除成功！");
            } else {
                System.out.println("不存在该节点！删除失败");
            }
        }
    }


    //修改(根据编号来下指定节点)
    public void edit(int id, String... var) {
        Node temp = headNode;
        if (headNode == null) {
            System.out.println("链表为空....");
            return;
        }
        //找打id的节点
        while (true) {
            if (temp == null) {//遍历完了，退出循环
                break;
            }
            if (temp.id == id) {
                if (var.length > 0) {
                    String name = var[0];
                    temp.setName(name);
                }
                if (var.length > 1) {
                    String nickname = var[1];
                    temp.setNickName(nickname);
                }
            }
            temp = temp.next;
        }
    }

    //获取倒数弟K个节点并打印
    public Node getNodeByK(int k) {
        Node temp = headNode;
        if (temp == null) {
            return temp;
        }
        //获取链表长度
        int size = getSize();
        int index = size - k;
        if (index < 0 || index >= size) {
            System.out.println("k错误：" + k);
            return null;
        }
        int tmpIndex = 0;
        while (true) {
            if (temp != null) {
                if (tmpIndex == index) {
                    return temp;
                }
                tmpIndex++;
            }
            temp = temp.next;
        }
    }


    //显示操作
    public void list() {
        Node temp = headNode;
        if (temp == null) {
            System.out.println("节点为空~~~");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //获取单链表的有效节点个数
    public int getSize() {
        Node temp = headNode;
        int count = 0;
        if (headNode == null) {//没有统计头结点
            return count;
        }
        while (true) {
            if (temp == null) return count;
            if (temp != null) {
                count++;
            }
            temp = temp.next;
        }
    }

}

class Node {
    public int id;
    private String name;
    private String nickName;
    public Node next;


    public Node(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (id != node.id) return false;
        if (name != null ? !name.equals(node.name) : node.name != null) return false;
        if (nickName != null ? !nickName.equals(node.nickName) : node.nickName != null) return false;
        return next != null ? next.equals(node.next) : node.next == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
