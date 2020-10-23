package org.buptdavid.datastructure.zj.zookeeper_book_my.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

public class UnsafeTest {




    public static void main(String[] args) {
        Unsafe unsafe=null;
//        try {
//            Unsafe unsafe = Unsafe.getUnsafe();
//            long value = unsafe.objectFieldOffset(AtomicLong.class.getDeclaredField("value"));
//            System.out.println(value);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
        try {
            String[] arr=new String[]{"你","2"};
            Field field = Unsafe.class.getDeclaredField("theUnsafe");//这里必须是theUnsafe，其他的名称会抛出  java.lang.NoSuchFieldException: 名称  异常
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            long valueOffset = unsafe.objectFieldOffset(AtomicLong.class.getDeclaredField("value"));
            System.out.println(valueOffset);
            System.out.println("-----------------------------------");
            int i = unsafe.arrayBaseOffset(arr.getClass());
            int i1 = unsafe.arrayIndexScale(arr.getClass());
            System.out.println(i);
            System.out.println(i1);
            System.out.println("main runing...");
            unsafe.park(false,1);//阻塞当前线程，false 0   代表一种值阻塞
            System.out.println("main run end ");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
