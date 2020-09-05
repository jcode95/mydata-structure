package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree;

/**
 * 线索二叉树节点类
 *
 * 线索化二叉树不能再使用原来的  前序，中序，后序遍历了，会造成死循环
 */
class ThreadedHeroNode {

    public int no;//编号
    public String name;//名称
    public ThreadedHeroNode left;//左节点
    public ThreadedHeroNode right;//右节点
    public int leftType;// 0 代表 left节点指向的是左节点，1 代表left指向的是前驱节点
    public int rightType;// 0 代表 right节点指向的是右节点，1 代表right指向的是后继节点

    public ThreadedHeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThreadedHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }



}