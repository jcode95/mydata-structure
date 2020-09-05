package org.buptdavid.datastructure.zj.design_mode.Filter;

/**
 * @author jiezhou
 * @CalssName: Person
 * @Package org.buptdavid.datastructure.zj.design_mode.Filter
 * @Description: 实体类
 * @date 2020/4/21/15:58
 */
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name,String gender,String maritalStatus){
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
}
