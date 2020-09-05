package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree;

/**
 * @author jiezhou
 * @CalssName: BinaryTreeTest
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.tree
 * @Description: 二叉树
 * @date 2020/8/20/11:18
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "A");
        HeroNode b = new HeroNode(2, "B");
        HeroNode c = new HeroNode(3, "C");
        HeroNode d = new HeroNode(4, "D");
        HeroNode e = new HeroNode(5, "E");
        HeroNode f = new HeroNode(6, "F");
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = f;
        c.right = e;
        /*---------------------测试数组转二叉树-----------------------*/
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        HeroNode node = new ArrBinaryTree().castArrToArrBinaryTree(arr);
         /*---------------------测试数组转二叉树-----------------------*/
        binaryTree.setRoot(node);
        System.out.println("-------前序遍历---------");
        binaryTree.preOrder();
        System.out.println("-------中序遍历---------");
        binaryTree.infixOrder();
        System.out.println("-------后序遍历---------");
        binaryTree.suffixOrder();
        System.out.println("-------后序遍历查找指定节点---------");
        HeroNode heroNode = binaryTree.suffixOrderByNo(6);
        System.out.println(heroNode.toString());
        System.out.println("-------前序遍历查找指定节点---------");
        HeroNode preOrderByNo = binaryTree.preOrderByNo(6);
        System.out.println(preOrderByNo.toString());
        System.out.println("-------中序遍历查找指定节点---------");
        HeroNode infixOrderByNo = binaryTree.infixOrderByNo(6);
        System.out.println(infixOrderByNo.toString());
        System.out.println("-------删除指定节点---------");
        binaryTree.removeNodeByNo(2);
        binaryTree.preOrder();

    }


}



/**
 * 定义一个二叉树
 */
class BinaryTree {
    HeroNode root = null;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root == null) {
            System.out.println("binaryTree is null");
            return;
        } else {
            this.root.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.root != null) {
            root.infixOrder();
        } else {
            System.out.println("binaryTree is null");
        }

    }

    /**
     * 后序遍历
     */
    public void suffixOrder() {
        if (this.root != null) {
            this.root.suffixOrder();
        } else {
            System.out.println("binaryTree is null");
        }
    }

    /**
     * 前序遍历查找指定节点
     */
    public HeroNode preOrderByNo(int no) {
        if (root == null) {
            System.out.println("binaryTree is null");
            return null;
        } else {
            return this.root.preOrderByNo(no);
        }
    }

    /**
     * 中序遍历查找指定节点
     */
    public HeroNode infixOrderByNo(int no) {
        if (this.root != null) {
            return root.infixOrderByNo(no);
        } else {
            System.out.println("binaryTree is null");
            return null;
        }

    }

    /**
     * 后序遍历查找指定节点
     */
    public HeroNode suffixOrderByNo(int no) {
        if (this.root != null) {
            return this.root.suffixOrderByNo(no);
        } else {
            System.out.println("binaryTree is null");
            return null;
        }
    }

    /**
     * 删除指定节点（包括节点的子树）
     *
     * @param no
     */
    public void removeNodeByNo(int no) {
        if (root == null) {
            System.out.println("binaryTree is null");
            return;
        } else {
            if (root.no == no) {
                root = null;
                return;
            }
            this.root.removeNodeByNo(no);
        }
    }


}
