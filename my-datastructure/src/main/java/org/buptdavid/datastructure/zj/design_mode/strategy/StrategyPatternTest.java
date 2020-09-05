package org.buptdavid.datastructure.zj.design_mode.strategy;

/**
 * @author jiezhou
 * @CalssName: StrategyPatternTest
 * @Package org.buptdavid.datastructure.zj.design_mode.strategy
 * @Description: 测试
 * @date 2020/4/21/16:58
 */
public class StrategyPatternTest {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
