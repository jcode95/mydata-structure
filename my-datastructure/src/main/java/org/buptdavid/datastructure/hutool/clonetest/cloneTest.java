package org.buptdavid.datastructure.hutool.clonetest;

import cn.hutool.core.clone.Cloneable;
import cn.hutool.core.util.ObjectUtil;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author jiezhou
 * @CalssName: cloneTest
 * @Package org.buptdavid.datastructure.hutool.clonetest
 * @Description: hutool实现深度克隆和浅克隆
 * @date 2021/2/6/14:41
 */
public class cloneTest {
    public static void main(String[] args) {
        Proson proson = new Proson("hutool", true, 18, new School("XXX大学"));
        Proson cloneProson = proson.clone();
        System.out.println("浅克隆,也就是属性对象会指向同一个地址...  ");

        //深度克隆
        Proson dpProson = ObjectUtil.cloneByStream(proson);
        System.out.println("深度克隆，也就是属性对象会克隆出来到新地址...  ");
    }
}

/**
 * 深克隆
 * 我们知道实现Cloneable接口后克隆的对象是浅克隆，要想实现深克隆，请使用：
 * ObjectUtil.cloneByStream(obj)
 * Copy to clipboardErrorCopied
 * 前提是对象必须实现Serializable接口（属性对象也需要实现此接口）。
 */
class Proson implements Cloneable<Proson>, Serializable {//或者 都可以 extends CloneSupport<Proson>
    private String name;
    private boolean sex;
    private int age;

    private School school;

    public Proson(String name, boolean sex, int age, School school) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proson proson = (Proson) o;
        return isSex() == proson.isSex() &&
                getAge() == proson.getAge() &&
                Objects.equals(getName(), proson.getName()) &&
                Objects.equals(school, proson.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), isSex(), getAge(), school);
    }

    @Override
    public Proson clone() {
        try {
            return (Proson) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class School implements Serializable {
    private String name;//学校名称

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
