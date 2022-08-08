package org.buptdavid.datastructure.zj.泛型;

/**
 * @author jiezhou
 * @CalssName: MemberInfo2
 * @Package org.buptdavid.datastructure.zj.泛型
 * @Description:
 * @date 2022/8/8/23:16
 */
public class MemberInfo2 {
    private String name;
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MemberInfo2{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
