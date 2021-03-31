package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.binarysorttree;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * @author jiezhou
 * @CalssName: BinaryReverTests
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.binarysorttree
 * @Description: 还原二叉树
 * @date 2021/3/30 0030/20:28
 */
public class BinaryReverTests {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};//前序遍历
        int[] inorder = new int[]{9, 3, 15, 20, 7};//中序遍历


    }


    //根据中序和前序还原二叉树
    public Node buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }


        return null;

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
         * 添加节点，此方法只处理添加，不进行旋转
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
}
