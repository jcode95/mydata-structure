package org.buptdavid.datastructure.zj;

/**
 * @author jiezhou
 * @CalssName: SynchronizedDemo
 * @Package org.buptdavid.datastructure.zj
 * @Description: 底层原理，使用javap -c 全类名来反编译
 * @date 2020/11/17/14:20
 */
public class SynchronizedDemo {
    public static void main(String[] args) {

    }

    public void process(){
        synchronized (this){
            System.out.println("process");
        }
    }

}
