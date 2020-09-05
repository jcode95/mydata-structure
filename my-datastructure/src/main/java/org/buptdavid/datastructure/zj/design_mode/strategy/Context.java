package org.buptdavid.datastructure.zj.design_mode.strategy;

/**
 * @author jiezhou
 * @CalssName: Context
 * @Package org.buptdavid.datastructure.zj.design_mode.strategy
 * @Description: 创建 Context 类
 * @date 2020/4/21/16:57
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
