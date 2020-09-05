package org.buptdavid.datastructure.zj.design_mode.strategy;

/**
 * @author jiezhou
 * @CalssName: OperationMultiply
 * @Package org.buptdavid.datastructure.zj.design_mode.strategy
 * @Description: 乘
 * @date 2020/4/21/16:56
 */
public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1*num2;
    }
}
