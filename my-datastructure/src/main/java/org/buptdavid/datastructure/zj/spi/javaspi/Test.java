package org.buptdavid.datastructure.zj.spi.javaspi;

import java.text.SimpleDateFormat;
import java.util.Date;
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
            String name = my.getClass().getName();
            name=name.substring(name.lastIndexOf(".")+1);
            my.blue();
            my.read();
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        System.out.println("date = " + date);
    }


}