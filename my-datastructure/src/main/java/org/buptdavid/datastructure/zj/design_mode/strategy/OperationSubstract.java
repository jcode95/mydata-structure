package org.buptdavid.datastructure.zj.design_mode.strategy;

/**
 * @author jiezhou
 * @CalssName: OperationSubstract
 * @Package org.buptdavid.datastructure.zj.design_mode.strategy
 * @Description: 减
 * @date 2020/4/21/16:56
 */
public class OperationSubstract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1-num2;
    }
}
