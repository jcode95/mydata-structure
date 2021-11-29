package org.buptdavid.datastructure.zj.java8.function;

/**
 * @author jiezhou
 * @CalssName: BranchHandle
 * @Package org.buptdavid.datastructure.zj.java8.function
 * @Description:
 * @date 2021/11/24/14:13
 */
@FunctionalInterface
public interface BranchHandle {

    void trueOrFalseHandle(Runnable r1,Runnable r2);

}
