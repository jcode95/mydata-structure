package org.buptdavid.datastructure.zj.design_mode.builder;

/**
 * @author jiezhou
 * @CalssName: VegBurger
 * @Package org.buptdavid.datastructure.zj.design_mode.builder
 * @Description: 植物蛋白汉堡
 * @date 2020/4/21/12:17
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 10;
    }
}
