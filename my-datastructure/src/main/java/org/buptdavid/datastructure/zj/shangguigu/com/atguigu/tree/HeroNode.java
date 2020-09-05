package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree;

/**
 * 节点类
 */
class HeroNode {

    public int no;//编号
    public String name;//名称
    public HeroNode left;//左节点
    public HeroNode right;//右节点

    public HeroNode(int no, String name) {
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
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);//输出父节点
        //递归左边
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归右边
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 前序遍历查找指定的节点
     */
    public HeroNode preOrderByNo(int no) {
        System.out.println("前");
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        //递归左边
        if (this.left != null) {
            resNode = this.left.preOrderByNo(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //递归右边
        if (this.right != null) {
            resNode = this.right.preOrderByNo(no);
        }
        return resNode;
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        //递归左边
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);//输出父节点
        //递归右边
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 中序遍历查找指定的节点
     */
    public HeroNode infixOrderByNo(int no) {
        System.out.println("中");
        HeroNode resNode = null;
        //递归左边
        if (this.left != null) {
            resNode = this.left.infixOrderByNo(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        //递归右边
        if (this.right != null) {
            resNode = this.right.infixOrderByNo(no);
        }
        return resNode;
    }

    /**
     * 后序遍历查找指定的节点
     */
    public HeroNode suffixOrderByNo(int no) {
        System.out.println("后");
        HeroNode resNode = null;
        //递归左边
        if (this.left != null) {
            resNode = this.left.suffixOrderByNo(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //递归右边
        if (this.right != null) {
            resNode = this.right.suffixOrderByNo(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        return null;
    }

    /**
     * 后序遍历
     */
    public void suffixOrder() {
        //递归左边
        if (this.left != null) {
            this.left.suffixOrder();
        }
        //递归右边
        if (this.right != null) {
            this.right.suffixOrder();
        }
        System.out.println(this);//输出父节点
    }

    public void removeNodeByNo(int no) {
        if (this.left != null) {
            if (this.left.no != no) {
                this.left.removeNodeByNo(no);
            } else {
                this.left = null;
                return;
            }
        }
        if (this.right != null) {
            if (this.right.no != no) {
                this.right.removeNodeByNo(no);
            } else {
                this.right = null;
                return;
            }
        }
    }

}