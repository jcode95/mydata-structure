package org.buptdavid.datastructure.zj.JMX;

/**
 * @author jiezhou
 * @CalssName: Hello
 * @Package org.buptdavid.datastructure.zj.JMX
 * @Description:
 * @date 2021/5/17/15:01
 */
public class Hello implements HelloMBean{
    @Override
    public String getName() {
        System.out.println("getName = ");
        return null;
    }

    @Override
    public void setName(String name) {
        System.out.println("setName = " + name);
    }

    @Override
    public String getAge() {
        System.out.println("getAge = ");
        return null;
    }

    @Override
    public void setAge(String age) {
        System.out.println("setAge age = " + age);
    }

    @Override
    public void helloWorld() {
        System.out.println("helloWorld = ");
    }

    @Override
    public void helloWorld(String str) {
        System.out.println("helloWorld  str = " + str);
    }

    @Override
    public void getTelephone() {
        System.out.println("getTelephone = ");
    }
}
