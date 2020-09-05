package org.buptdavid.datastructure.clone;

import java.io.Serializable;

/**
 * @author jiezhou
 * @CalssName: Student
 * @Package org.buptdavid.datastructure.clone
 * @Description: 测试cloneable
 * @date 2020/6/23/16:56
 */
public class Student implements Cloneable ,Serializable{

    private String name;

    private int age;

    private A a;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a=" + a +
                '}';
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
