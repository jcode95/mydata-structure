package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.hash;

/**
 * @author jiezhou
 * @CalssName: Emp
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.hash
 * @Description:
 * @date 2020/8/19/16:52
 */
public class Emp {

    public  int id;
    public  String  name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Emp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
