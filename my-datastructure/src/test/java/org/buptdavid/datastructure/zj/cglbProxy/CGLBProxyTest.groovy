package org.buptdavid.datastructure.zj.cglbProxy

class CGLBProxyTest {

    @org.junit.Test
    public void test() {
        Hello hello = new Hello();
        Hello proxyInstance = (Hello) new CGLBProxy().getInstance(hello);
        proxyInstance.sayHello();

        /*
        JDK动态代理和CGLIB字节码生成的区别？
        （1）JDK动态代理只能对实现了接口的类生成代理，而不能针对类。
        （2）CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法，因为是继承，所以该类或者方法最好不要生命成final。
        */
    }
}
