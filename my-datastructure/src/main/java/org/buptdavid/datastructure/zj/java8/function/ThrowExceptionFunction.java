package org.buptdavid.datastructure.zj.java8.function;

/**
 * @author jiezhou
 * @InterfaceName: ThrowExceptionFunction
 * @Package org.buptdavid.datastructure.zj.java8.function
 * @Description: 抛出异常接口
 * @date 2021/11/24/14:02
 */
@FunctionalInterface
public interface ThrowExceptionFunction {
    void throwMessage(String message);
}
