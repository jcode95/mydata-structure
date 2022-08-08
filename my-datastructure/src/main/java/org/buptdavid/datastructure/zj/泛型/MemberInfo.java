package org.buptdavid.datastructure.zj.泛型;

import java.util.Date;

/**
 * @author jiezhou
 * @CalssName: MemberInfo
 * @Package org.buptdavid.datastructure.zj.泛型
 * @Description:
 * @date 2022/8/8/23:09
 */
public class MemberInfo {
    private int age;
    private Date createTime;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "age=" + age +
                ", createTime=" + createTime +
                '}';
    }
}
