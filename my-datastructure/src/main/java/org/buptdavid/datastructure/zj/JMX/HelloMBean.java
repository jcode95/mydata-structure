package org.buptdavid.datastructure.zj.JMX;

/**
 * @author jiezhou
 * @InterfaceName: HelloMBean
 * @Package org.buptdavid.datastructure.zj.JMX
 * @Description:
 * @date 2021/5/17/15:00
 */
public interface HelloMBean {

    public String getName();

    public void setName(String name);

    public String getAge();

    public void setAge(String age);

    public void helloWorld();

    public void helloWorld(String str);

    public void getTelephone();
}
