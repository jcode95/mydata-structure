package org.buptdavid.datastructure.zj.cglbProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jiezhou
 * @CalssName: CGLBProxy
 * @Package org.buptdavid.datastructure.zj.cglbProxy
 * @Description:
 * @date 2020/6/6/14:58
 */
public class CGLBProxy implements MethodInterceptor{

    private Object target;

    public Object getInstance(Object target){
        this.target=target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    //回调方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是cglb动态代理" );
        //反射方法前调用
        System.out.println("before ---> invokesuper()");
        Object retureObject = methodProxy.invokeSuper(o, objects);
        //反射方法后调用
        System.out.println("after ---> invokesuper()");
        return retureObject;

    }
}
