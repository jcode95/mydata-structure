package org.buptdavid.datastructure.zj.design_mode.builder;

/**
 * @author jiezhou
 * @CalssName: ColdDrink
 * @Package org.buptdavid.datastructure.zj.design_mode.builder
 * @Description: 冷饮
 * @date 2020/4/21/12:16
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
