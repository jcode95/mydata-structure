package org.buptdavid.datastructure.zj.design_mode.strategy;

/**
 * @author jiezhou
 * @CalssName: OperationAdd
 * @Package org.buptdavid.datastructure.zj.design_mode.strategy
 * @Description: 加。
 * @date 2020/4/21/16:55
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
