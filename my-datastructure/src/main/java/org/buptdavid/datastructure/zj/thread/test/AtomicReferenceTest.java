package org.buptdavid.datastructure.zj.thread.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author jiezhou
 * @CalssName: Atomic
 * @Package org.buptdavid.datastructure.zj.thread
 * @Description: cas 的 ABA问题的解决  普通原子引用(不能解决ABA问题),版本号（时间戳）的原子引用，能解决ABA问题
 * @date 2021/2/20/10:40
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        AtomicReference atomicReference = new AtomicReference();//普通原子引用
//        atomicReference.set();

//        AtomicStampedReference  版本号（时间戳）的原子引用，这个更加强大
    }
}
