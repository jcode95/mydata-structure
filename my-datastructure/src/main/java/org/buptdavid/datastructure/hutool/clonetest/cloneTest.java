package org.buptdavid.datastructure.hutool.clonetest;

import cn.hutool.core.clone.Cloneable;

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
        cloneProson.setSchool(new School("ssss"));
        System.out.println(cloneProson.equals(proson));
    }


}


class Proson implements Cloneable<Proson> {
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

class School {
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
