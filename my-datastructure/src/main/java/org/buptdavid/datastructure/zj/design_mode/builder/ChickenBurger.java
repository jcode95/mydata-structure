package org.buptdavid.datastructure.zj.design_mode.builder;

/**
 * @author jiezhou
 * @CalssName: ChickenBurger
 * @Package org.buptdavid.datastructure.zj.design_mode.builder
 * @Description: 鸡肉汉堡包
 * @date 2020/4/21/12:18
 */
public class ChickenBurger  extends Burger{
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 5F;
    }
}
