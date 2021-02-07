package org.buptdavid.datastructure.zj.spring.config;

/**
 * @author jiezhou
 * @CalssName: MyApplicationConfig
 * @Package org.buptdavid.datastructure.zj.spring.config
 * @Description: 自定义配置文件类
 * @date 2021/2/10/18:20
 */
public class MyApplicationConfig {

    private String id;
    private String name;
    private int age;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
