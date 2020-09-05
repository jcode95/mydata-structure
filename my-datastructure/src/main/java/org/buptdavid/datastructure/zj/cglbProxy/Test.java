package org.buptdavid.datastructure.zj.cglbProxy;

/**
 * @author jiezhou
 * @CalssName: Test
 * @Package org.buptdavid.datastructure.zj.cglbProxy
 * @Description:
 * @date 2020/6/6/15:06
 */
public class Test {

    @org.junit.Test
    public void test(){
        Hello hello = new Hello();
        Hello proxyInstance = (Hello) new CGLBProxy().getInstance(hello);
        proxyInstance.sayHello();


    }
}
