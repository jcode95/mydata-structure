package org.buptdavid.datastructure.zj.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {
    private Object object;
    public ProxyHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        method.invoke(object,args);
        System.out.println("After invoke " + method.getName());
        return null;
    }


    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        final HelloInterface hello = new Hello();
        final HelloInterface1 hello1 = new Hello1();
//        InvocationHandler handler = new ProxyHandler(hello);
//
//        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
//        proxyHello.sayHello();
        HelloInterface sayhello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), new Class[]{HelloInterface.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("rerer");
                        method.invoke(hello, args);
//                        method.invoke(hello1,args);
                        return null;
                    }
                });
        sayhello.sayHello();
    }
}
