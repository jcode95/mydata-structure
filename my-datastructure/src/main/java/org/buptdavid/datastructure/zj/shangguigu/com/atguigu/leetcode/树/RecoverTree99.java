package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.树;

/**
 * @author jiezhou
 * @CalssName: RecoverTree99
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.leetcode.树
 * @Description: 恢复二叉搜索树，又名二叉排序树，二叉查找树（左边都小于根节点，右边都大于根节点）
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * @date 2020/12/14/15:35
 */
public class RecoverTree99 {
    static int length = 0;
    static Integer[] result = new Integer[length];

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{3, 1, 4, null, null, 2};
        TreeNode root = new TreeNode();
        root.no = arr[0];
        createTree(arr, root, 0);
        getlength(root);
        System.out.println(length);
        System.out.println(getlength1(root));
    }

    /**
     * @param root
     */
    public static void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inFix(root, 0);
        root = new TreeNode();
        root.no = result[0];
    }

    public static void inFix(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        result[index] = root.no;
        recoverTree(root.left);
        recoverTree(root.right);
    }

    public static void createTree(Integer[] arr, TreeNode node, int index) {
        TreeNode tempNode = node;
        TreeNode left = new TreeNode();
        if (2 * index + 1 > arr.length - 1) {
            return;
        }
        left.no = arr[2 * index + 1];
        tempNode.left = left;
        createTree(arr, left, 2 * index + 1);
        TreeNode right = new TreeNode();
        if (2 * index + 2 > arr.length - 1) {
            return;
        }
        right.no = arr[2 * index + 2];
        createTree(arr, right, 2 * index + 2);
        tempNode.right = right;
    }

    public static void getlength(TreeNode root) {
        if (root == null) {
            return;
        }
        length += 1;
        getlength(root.left);
        getlength(root.right);
    }

    public static int getlength1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getlength1(root.left) + getlength1(root.right) + 1;
    }


    static class TreeNode {
        public Integer no;
        TreeNode left;
        TreeNode right;
    }
}
