package org.buptdavid.datastructure.zj.design_mode.builder;

/**
 * @author jiezhou
 * @CalssName: Pepsi
 * @Package org.buptdavid.datastructure.zj.design_mode.builder
 * @Description: 百事可乐冷饮
 * @date 2020/4/21/12:20
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 2.5F;
    }
}
