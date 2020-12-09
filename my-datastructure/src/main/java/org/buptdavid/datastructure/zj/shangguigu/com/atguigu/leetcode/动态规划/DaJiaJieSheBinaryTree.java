package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划;

/**
 * @author jiezhou
 * @CalssName: DaJiaJieShe
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.动态规划
 * @Description: 打家劫舍问题、房屋按照二叉树排序
 * 第三题⼜想法设法地变花样了，此强盗发现现在⾯对的房⼦不是⼀排，不是 ⼀圈，⽽是⼀棵⼆叉树！房⼦在⼆叉树的节点上，
 * 相连的两个房⼦不能同时 被抢劫，果然是传说中的⾼智商犯罪：
 * @date 2020/12/3/19:01
 */
public class DaJiaJieSheBinaryTree {
    public static void main(String[] args) {
        int rob = new DaJiaJieSheBinaryTree().rob(new int[]{3, 4, 1, 1, 3, 0, 1});
        System.out.println(rob);
    }

    public int rob(int nums[]) {
        Node root = BinaryTree.getRoot(nums);
        return rob(root);
    }

    public int rob(Node root) {
        if (root == null) {
            return 0;
        }
       /*{3, 4,1, 1, 3, 0, 1}*/
        if (root.left == null) {
            return 0;
        }
        if (root.right == null) {
            return 0;
        }
        //抢,然后去下下家
        int qiang = root.value + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        //不抢
        int noQiang = rob(root.left) + rob(root.right);
        return Math.max(noQiang, qiang);
    }

    static class BinaryTree {
        static Node root;

        public static Node getRoot(int nums[]) {
            Node root = new Node(nums[0]);
            createArrBinaryTree(nums, root, 0);
            return root;
        }

        public static void createArrBinaryTree(int nums[], Node node, int index) {
            if (node == null) {
                return;
            }
            Node temp = node;
            //获取左节点的下标
            int leftIndex = 2 * index + 1;
            if (leftIndex >= nums.length) {
                return;
            }
            Node left = new Node(nums[leftIndex]);
            node.left = left;
            createArrBinaryTree(nums, node.left, leftIndex);
            //获取右节点的下标
            int rightIndex = 2 * index + 2;
            if (rightIndex >= nums.length) {
                return;
            }
            Node right = new Node(nums[rightIndex]);
            node.right = right;
            createArrBinaryTree(nums, node.right, rightIndex);
        }

    }

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
