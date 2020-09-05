package org.buptdavid.datastructure.zj.design_mode.builder;

/**
 * @author jiezhou
 * @CalssName: Coke
 * @Package org.buptdavid.datastructure.zj.design_mode.builder
 * @Description: 可口可乐冷饮
 * @date 2020/4/21/12:20
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 2F;
    }
}
