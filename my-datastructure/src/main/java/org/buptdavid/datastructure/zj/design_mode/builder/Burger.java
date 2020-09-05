package org.buptdavid.datastructure.zj.design_mode.builder;

/**
 * @author jiezhou
 * @CalssName: Burger
 * @Package org.buptdavid.datastructure.zj.design_mode.builder
 * @Description: 汉堡
 * @date 2020/4/21/12:11
 */
public abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
