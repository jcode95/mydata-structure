package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.binarysorttree;

/**
 * @author jiezhou
 * @CalssName: BinarySortTreeTest
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.binarysorttree
 * @Description: 二叉排序树 （二叉查找树）BST
 * @date 2020/8/26/10:11
 */
public class BinarySortTreeTest {

    public static void main(String[] args) {
        BinarySortTree sortTree = new BinarySortTree();
        Node node7 = new Node(7);
        Node node3 = new Node(3);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        Node node5 = new Node(5);
        Node node9 = new Node(9);
        Node node12 = new Node(12);
        Node node2 = new Node(2);
        sortTree.add(node7);
        sortTree.add(node3);
        sortTree.add(node10);
        sortTree.add(node1);
        sortTree.add(node5);
        sortTree.add(node9);
        sortTree.add(node12);
        sortTree.add(node2);

        sortTree.infixOrder();
        sortTree.delNode(7);
        System.out.println("------------delNode--------------");
        sortTree.infixOrder();
        //右左中遍历二叉树
        System.out.println("------------RLIOrder--------------");
        sortTree.RLIOrder();


    }

}

class BinarySortTree {

    Node root;//跟节点


    /**
     * @param arr
     */
    /*public void createBinarySortTree(int[] arr) {
        root = new Node(arr[0]);//创建root


    }*/


    /**
     * 删除节点
     *
     * @param data
     */
    public void delNode(int data) {
        if (root == null) {
            return;
        }
        Node delNode = root.searchDel(data);
        if (delNode == null) {
            return;
        }
        //处理只有根节点情况,删除根节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        //找到delNode的父节点
        Node parentNode = searchParent(data);
        if (delNode.left == null && delNode.right == null) { //判断目标节点是否是叶子节点
            //判断delNode是父节点的左节点还是右节点，直接比较data大小就行
            if (parentNode.left != null && parentNode.left.data == data) {//是左节点
                parentNode.left = null;//删除
            }
            if (parentNode.right != null && parentNode.right.data == data) {//是右节点
                parentNode.right = null;//删除
            }
        } else if (delNode.left != null && delNode.right != null) {//目标节点不是叶子节点,并且左右子树都不为空
            //找到右子树最小的值
            int rightTreeMinV = getRightTreeMin(delNode.right);
            //把找到的这个最小值设置给delNode
            delNode.data = rightTreeMinV;
        } else {//目标节点只有一个子节点时
            //要删除的节点有左节点时
            if (delNode.left != null) {//左节点
                //判断要删除的节点是父节点的左还是右
                if (parentNode != null) {
                    if (parentNode.left.data == data) {
                        parentNode.left = delNode.left;
                    } else {
                        parentNode.right = delNode.left;
                    }
                } else {
                    root = delNode.left;//处理根节点
                }
            } else { //要删除的节点有右节点时
                if (parentNode != null) {
                    if (parentNode.left.data == data) {
                        parentNode.left = delNode.right;
                    } else {
                        parentNode.right = delNode.right;
                    }
                } else {
                    root = delNode.right;//处理根节点
                }
            }
        }
    }

    /**
     * 插入
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        if (node == null) {
            return;
        }
        root.add(node);
    }

    /**
     * 中序遍历，对于二叉排序树来说，中序遍历得到的结果就是排好序的，从小到到大排序
     */
    public void infixOrder() {
        if (root == null) {
            System.out.println("BinarySortTree is null");
            return;
        }
        root.infixOrder();
    }
    /**
     * 右左中遍历
     */
    public void RLIOrder() {
        if (root == null) {
            System.out.println("BinarySortTree is null");
            return;
        }
        root.RLIOrder();
    }

    /**
     * 查找要删除的节点
     *
     * @param data
     * @return
     */
    public Node searchDel(int data) {
        if (root == null) {
            return null;
        }
        return root.searchDel(data);
    }

    /**
     * 查找要删除的节点的父节点
     *
     * @param data 要删除节点的值
     * @return 父节点
     */
    public Node searchParent(int data) {
        if (root == null) {
            return null;
        }
        return root.searchParent(data);
    }

    /**
     * 找到右子树节点最小值
     *
     * @param node 子树为一颗二叉排序树，所以最小值就是在左叶子节点上
     * @return
     */
    public int getRightTreeMin(Node node) {
        Node tarNode = node;
        while (tarNode.left != null) {
            tarNode = tarNode.left;
        }
        //删除最小的节点
        delNode(tarNode.data);
        return tarNode.data;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    /**
     * 插入,这里没有做左旋或者右旋操作，会导致某个子树很长，不平衡
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.data > this.data) {
            //放在右边
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        } else {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.toString());
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
    /**
     * 右左中遍历 自己的遍历
     */
    public void RLIOrder() {
        if (this.right != null) {
            this.right.RLIOrder();
        }
        if (this.left != null) {
            this.left.RLIOrder();
        }
        System.out.println(this.toString());
    }


    /**
     * 查找要删除的节点
     *
     * @param data
     * @return
     */
    public Node searchDel(int data) {
        if (this.data == data) {
            return this;
        }
        if (data < this.data) {
            if (this.left != null) {
                //应该咋左子树递归找
                return this.left.searchDel(data);
            } else {
                return null;
            }
        } else {
            if (this.right != null) {
                //应该咋右子树递归找
                return this.right.searchDel(data);
            } else {
                return null;
            }
        }
    }

    /**
     * 查找要删除的节点的父节点
     *
     * @param data 要删除节点的值
     * @return 父节点
     */
    public Node searchParent(int data) {
        Node parentNode = null;
        if (this.left != null && this.left.data == data || this.right != null && this.right.data == data) {
            return this;
        }
        if (data < this.data && this.left != null) {
            parentNode = this.left.searchParent(data);
        } else if (data > this.data && this.right != null) {
            parentNode = this.right.searchParent(data);
        }
        return parentNode;
    }
}
