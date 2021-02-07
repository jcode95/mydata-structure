package org.buptdavid.datastructure.zj.spi.javaspi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 初始化会加载所有实现类，耗时，所有dubbo会对spi进行扩展
 */
public class Test {

    public static void main(String[] args) {
        ServiceLoader<MySPIJavaInterface> loader = ServiceLoader.load(MySPIJavaInterface.class);
        Iterator<MySPIJavaInterface> iterator = loader.iterator();
        while (iterator.hasNext()){
            MySPIJavaInterface my = iterator.next();
            my.blue();
            my.read();
        }
    }


}