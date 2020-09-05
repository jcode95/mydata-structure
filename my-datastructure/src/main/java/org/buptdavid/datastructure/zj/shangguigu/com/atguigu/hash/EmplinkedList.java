package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.hash;

/**
 * @author jiezhou
 * @CalssName: EmplinkedList
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.hash
 * @Description: 链表
 * @date 2020/8/19/16:51
 */
public class EmplinkedList {

    private Emp head = null;//头指针,指向第一个雇员

    /**
     * 添加雇员
     */
    public void add(Emp emp) {
        Emp empTemp = head;
        if (head == null) {
            head = emp;
            return;
        }
        while (true) {
            if (empTemp.next == null) {
                empTemp.next = emp;
                return;
            }
            empTemp = empTemp.next;
        }
    }

    public boolean list() {
        if (head == null) {
//            System.out.println("没有雇员！");
            return false;
        }
        Emp empTemp = head;
        while (empTemp != null) {
            System.out.println(empTemp.toString());
            empTemp = empTemp.next;
        }
        return true;
    }

    public Emp getEmpById(int id) {
        Emp tmp = head;
        boolean flg=true;
        if (head != null) {
            while (tmp != null) {
                if (tmp.getId() == id) {
                    return tmp;
                }
                tmp = tmp.next;
            }
        }
        return null;
    }
}
