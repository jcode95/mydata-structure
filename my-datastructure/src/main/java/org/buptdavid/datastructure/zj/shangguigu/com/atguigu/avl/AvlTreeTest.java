package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.avl;

/**
 * @author jiezhou
 * @CalssName: AvlTreeTest
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.avl
 * @Description: 平衡二叉树  AVL树
 * @date 2020/8/27/9:45
 */
public class AvlTreeTest {
    public static void main(String[] args) {
//        int[] arr = new int[]{4, 3, 6, 5, 7, 8};//测试左旋
//        int[] arr = new int[]{10, 12, 8, 9, 7, 6};//测试右旋
//        int[] arr = new int[]{10, 11, 7, 6, 8, 9};//测试双旋
        int[] arr = new int[]{13, 10, 15, 5, 11, 16, 4, 8, 3};//测试双旋
        AvlTree avlTree = new AvlTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        System.out.println("根树高度：" + avlTree.root.getRootHight());
        System.out.println("左子树高度：" + avlTree.root.getLeftHight());
        System.out.println("右子树高度：" + avlTree.root.getRightHight());
//        System.out.println("---------------左旋------------");
//        avlTree.leftR();
//        avlTree.infixOrder();
//        System.out.println("---------------右旋------------");
    }

}

/**
 * 平衡二叉树（顺序二叉树的变种）
 */
class AvlTree {

    Node root;//跟节点

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
        if (root.left == null || root.right == null) {
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
            if (parentNode.right != null && parentNode.right.data == data) {//是左节点
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

    /* ----------------------------avl  相关-------------------*/

    /**
     * 左旋 对root树
     */
    public void leftR(Node root) {
        /*1、创建一个新节点，值为root的值*/
        Node newNode = new Node(root.data);
        /*2、让根节点的左子树成为新节点的左子树*/
        newNode.left = root.left;
        /*3、把新节点的右子树设置为根节点的右子树的左子树*/
        newNode.right = root.right.left;
        /*4、把根节点的值替换为根节点的右节点的值*/
        root.data = root.right.data;
        /*5、把根节点的右子树设置为根节点的右子树的右子树*/
        root.right = root.right.right;
        /*6、把根节点的左子树设置为新节点*/
        root.left = newNode;
    }

    /**
     * 右旋,对root树
     */
    public void rightR(Node root) {
        /*1、创建一个新节点，值为root的值*/
        Node newNode = new Node(root.data);
        /*2、让根节点的左子树的右子树成为新节点的左子树*/
        newNode.left = root.left.right;
        /*3、把新节点的右子树设置为根节点的右子树*/
        newNode.right = root.right;
        /*4、把根节点的值替换为根节点的左节点的值*/
        root.data = root.left.data;
        /*5、把根节点的左子树设置为根节点的左子树的左子树*/
        root.left = root.left.left;
        /*6、把根节点的右子树设置为新节点*/
        root.right = newNode;
    }
    /**
     * 双旋,对root树
     */
    /*public void rightleftR(Node root) {
        //当右子树的高度-左子树的高度>1，就需要左旋转
        if (root.getRightHight() - root.getLeftHight() > 1) {
            //当右子树的左子树的高度大于右子树的右子树的高度时，需要对右子树进行右旋，然后再对当前节点进行左旋
            Node currRight = root.right;//当前节点的右节点
            if (currRight.getLeftHight() > currRight.getRightHight()) {
                //对currRight进行右旋
                rightR(currRight);
            }
            //进行左旋
            leftR(root);
            return;
        }
        //当左子树的高度-右子树的高度>1，就需要右旋转
        if (root.getLeftHight() - root.getRightHight() > 1) {
            //当左子树的右子树的高度大于左子树的左子树的高度时，需要对左子树进行左旋，然后再对当前节点进行右旋
            Node currleft = root.left;//当前节点的左节点
            if (currleft.getRightHight() > currleft.getLeftHight()) {
                //先对currleft进行左旋
                leftR(currleft);
            }
            //进行右旋
            rightR(root);
        }
    }*/

    /**
     * 添加节点，并且会进行旋转
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
        //当右子树的高度-左子树的高度>1，就需要左旋转
        if (root.getRightHight() - root.getLeftHight() > 1) {
            //当右子树的左子树的高度大于右子树的右子树的高度时，需要对右子树进行右旋，然后再对当前节点进行左旋
            Node currRight = root.right;//当前节点的右节点
            if (currRight.getLeftHight() > currRight.getRightHight()) {
                //对currRight进行右旋
                rightR(currRight);
            }
            //进行左旋
            leftR(root);
            return;
        }
        //当左子树的高度-右子树的高度>1，就需要右旋转
        if (root.getLeftHight() - root.getRightHight() > 1) {
            //当左子树的右子树的高度大于左子树的左子树的高度时，需要对左子树进行左旋，然后再对当前节点进行右旋
            Node currleft = root.left;//当前节点的左节点
            if (currleft.getRightHight() > currleft.getLeftHight()) {
                //先对currleft进行左旋
                leftR(currleft);
            }
            //进行右旋
            rightR(root);
        }
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

    /**
     * 返回根节点树的高度
     *
     * @return
     */
    public int getRootHight() {
        return Math.max(this.left == null ? 1 : this.left.getRootHight() + 1, this.right == null ? 1 : this
                .right.getRootHight() + 1);
    }

    /**
     * 返回左子数树的高度
     *
     * @return
     */
    public int getLeftHight() {
        if (this.left == null) {
            return 0;//这里注意。左子树是以左节点为root节点求其高度
        }
//        return this.left.getLeftHight() + 1;
        return this.left.getRootHight();
    }

    /**
     * 返回右子数树的高度
     *
     * @return
     */
    public int getRightHight() {
        if (this.right == null) {
            return 0;
        }
//        return this.right.getRightHight() + 1;
        return this.right.getRootHight();
    }


}
