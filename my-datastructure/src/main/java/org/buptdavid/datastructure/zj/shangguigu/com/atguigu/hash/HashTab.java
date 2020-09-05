package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.hash;

/**
 * @author jiezhou
 * @CalssName: ClassHashTab
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.hash
 * @Description: 管理多条链表
 * @date 2020/8/19/16:51
 */
public class HashTab {

    EmplinkedList[] emplinkedListArr;
    private int size;

    public HashTab(int size) {
        this.size = size;
        emplinkedListArr = new EmplinkedList[size];
        for (int i = 0; i < size; i++) {
            emplinkedListArr[i] = new EmplinkedList();
        }
    }

    /**
     * 添加雇员，根据员工的id应该添加到哪条链表
     */
    public void add(Emp emp) {
        int emplinkedListNo = hashFun(emp.getId());
        emplinkedListArr[emplinkedListNo].add(emp);
        System.out.println("添加成功！");
    }

    /**
     * 遍历hash表
     */
    public void list() {
        boolean f = false;//只为提示
        if (emplinkedListArr != null && emplinkedListArr.length > 0) {
            for (int i = 0; i < emplinkedListArr.length; i++) {
                boolean b = emplinkedListArr[i].list();
                if (b) {
                    f = b;
                }
            }
        } else {
            System.out.println("没有数据！");
        }
        if (!f) {
            System.out.println("没有数据！");
        }
    }

    public void getEmpById(int id) {
        if (emplinkedListArr == null || emplinkedListArr.length == 0) {
            System.out.println("没有任何元素！");
            return;
        }
        int index = hashFun(id);
        if (emplinkedListArr != null && emplinkedListArr.length > 0) {
            Emp emp = emplinkedListArr[index].getEmpById(id);
            if (emp != null) {
                System.out.println("找到雇员：位于 " + index + "槽位  ，" + emp.toString());
                return;
            }
            System.out.println("没有找到！id=" + id + "的雇员");
        }

    }

    //编写一个散列函数，使用简单的取模法
    public int hashFun(int id) {
        return id % 10;
    }


}
