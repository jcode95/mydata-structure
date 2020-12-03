package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree;

/**
 * @author jiezhou
 * @CalssName: ThreadedBinaryTreeTest
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.tree
 * @Description: 线索二叉树
 * @date 2020/8/21/10:56
 */
public class ThreadedBinaryTreeTest {
    public static void main(String[] args) {
        ThreadedHeroNode root = new ThreadedHeroNode(1, "A");
        ThreadedHeroNode b = new ThreadedHeroNode(2, "B");
        ThreadedHeroNode c = new ThreadedHeroNode(3, "C");
        ThreadedHeroNode d = new ThreadedHeroNode(4, "D");
        ThreadedHeroNode e = new ThreadedHeroNode(5, "E");
        ThreadedHeroNode f = new ThreadedHeroNode(6, "F");
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = f;
        c.right = e;

        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.setRoot(root);
        tree.casePre(root);//线索化二叉树
        tree.threadedTree();
//        tree.preThreadList(root);

    }
}

/**
 * 定义一个线索化二叉树
 */
class ThreadedBinaryTree {

    ThreadedHeroNode root = null;
    ThreadedHeroNode pre = null;//保留当前节点的前一个节点

    public ThreadedHeroNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedHeroNode root) {
        this.root = root;
    }

    /**
     * 根据前序 线索化二叉树
     *
     * @param node 当前节点,当前已经是二叉树
     * @return
     */
    public void casePre(ThreadedHeroNode node) {
        /*不能线索化*/
        if (node == null) {
            return;
        }
        //处理当前节点
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;
        //处理左节点
        if (node.leftType == 0) {
            casePre(node.left);
        }
        //处理右节点
        if (node.rightType == 0) {
            casePre(node.right);
        }
    }

    /**
     * 根据后序 线索化二叉树
     *
     * @param node 当前节点,当前已经是二叉树
     * @return
     */
    public void caseSuffix(ThreadedHeroNode node) {
        /*不能线索化*/
        if (node == null) {
            return;
        }
        //处理左节点
        caseSuffix(node.left);
        //处理右节点
        caseSuffix(node.right);

        //处理当前节点
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }

        pre = node;

    }


    /**
     * 根据中序 线索化二叉树
     *
     * @param node 当前节点,当前已经是二叉树
     * @return
     */
    public void caseInfix(ThreadedHeroNode node) {
        /*不能线索化*/
        if (node == null) {
            return;
        }
        /*1、线索化左节点*/
        caseInfix(node.left);
        /*2、线索化当前节点*/
        //2.1 处理当前节点的前驱节点
        if (node.left == null) {
            //让当前节点的左指针指向前驱节点
            node.left = pre;
            node.leftType = 1;
        }
        //2.2 处理当前节点的后继节点,是在下次处理的
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        //***让当前节点成为下一个节点的前驱
        pre = node;
        /*3、线索化右节点*/
        caseInfix(node.right);


    }

    /**
     * 遍历中序线索化二叉树
     */
    public void threadedTree() {
        //定义一个变量来存储当前遍历的节点
        ThreadedHeroNode node = root;
        if (node == null) {
            return;
        }
        while (node != null) {
            while (node.leftType == 0) {
                node = node.left;
            }
            System.out.println(node);
            //判断node的右指针是否是后继节点
            while (node.rightType == 1) {
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }
    }

    /**
     * 前序遍历线索二叉树（按照后继线索遍历）
     *
     * @param node
     */
    public void preThreadList(ThreadedHeroNode node) {
        while (node != null) {
            while (node.leftType == 0) {
                System.out.println(node.toString());
                node = node.left;
            }
            System.out.println(node.toString());
            node = node.right;
        }
    }

}
