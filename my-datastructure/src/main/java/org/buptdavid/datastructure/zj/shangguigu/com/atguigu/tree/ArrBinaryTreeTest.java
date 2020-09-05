package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree;

/**
 * @author jiezhou
 * @CalssName: ArrBinaryTreeTest
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.tree
 * @Description: 顺序二叉树
 * @date 2020/8/20/16:48
 */
public class ArrBinaryTreeTest {

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] arr = new int[]{1, 3, 6, 8, 10, 14};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree();
        HeroNode node = arrBinaryTree.castArrToArrBinaryTree(arr);
//        System.out.println(node.toString());
        System.out.println("-------前序遍历---------");
        arrBinaryTree.preOrder(arr, 0);
        System.out.println("-------中序遍历---------");
        arrBinaryTree.infixOrder(arr, 0);
        System.out.println("-------后序遍历---------");
        arrBinaryTree.suffixOrder(arr, 0);
    }
}

/**
 * 顺序二叉树
 */
class ArrBinaryTree {


    /**
     * 数组转顺序二叉树
     */
    public HeroNode castArrToArrBinaryTree(int[] arr) {
        /*
        * 1、第n个元素的左子节点为 2*n+1  (也就是数组的下标)
        * 2、第n个元素的右子节点为 2*n+2  (也就是数组的下标)
        * 3、第n个元素的父节点为 (n-1)/2  (也就是数组的下标)
        * 4、n:标识二叉树中的第几个元素（按照0开始编号，从左到右，从上到下）
        * */
        //创建root节点
        HeroNode root = new HeroNode(arr[0], arr[0] + "节点");
        createTree(arr, root, 0);
        return root;
    }

    /**
     * 数组转二叉树
     *
     * @param arr
     * @param node
     * @param n
     */
    private void createTree(int[] arr, HeroNode node, int n) {
        int index = 0;
        //创建临时节点
        HeroNode temp = node;
        HeroNode var;
        //计算当前节点的左节点
        index = 2 * n + 1;
        if (index > arr.length - 1) {
            return;
        }
        var = new HeroNode(arr[index], arr[index] + "节点");
        temp.left = var;
        createTree(arr, var, index);
        //计算当前节点的右节点
        index = 2 * n + 2;
        if (index > arr.length - 1) {
            return;
        }
        var = new HeroNode(arr[index], arr[index] + "节点");
        temp.right = var;
        createTree(arr, var, index);
    }

    /**
     * 顺序存储二叉树的前序遍历
     *
     * @param arr   数组
     * @param index 数组的下标
     */
    public void preOrder(int[] arr, int index) {
        if (arr == null || arr.length == 0) {
            return;
        }

        //输出当前元素
        System.out.println(arr[index]);
        if (index * 2 + 1 < arr.length) {
            preOrder(arr, index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            preOrder(arr, index * 2 + 2);
        }
    }

    /**
     * 顺序存储二叉树的中序遍历
     *
     * @param arr   数组
     * @param index 数组的下标
     */
    public void infixOrder(int[] arr, int index) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (index * 2 + 1 < arr.length) {
            infixOrder(arr, index * 2 + 1);
        }
        //输出当前元素
        System.out.println(arr[index]);
        if (index * 2 + 2 < arr.length) {
            infixOrder(arr, index * 2 + 2);
        }
    }

    /**
     * 顺序存储二叉树的后序遍历
     *
     * @param arr   数组
     * @param index 数组的下标
     */
    public void suffixOrder(int[] arr, int index) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (index * 2 + 1 < arr.length) {
            suffixOrder(arr, index * 2 + 1);
        }

        if (index * 2 + 2 < arr.length) {
            suffixOrder(arr, index * 2 + 2);
        }
        //输出当前元素
        System.out.println(arr[index]);
    }
}

/**
 * 节点
 */
class Node {
    public int no;
    public String name;
    public Node left;
    public Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
