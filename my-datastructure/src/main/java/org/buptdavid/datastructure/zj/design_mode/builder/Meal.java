package org.buptdavid.datastructure.zj.design_mode.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: Meal
 * @Package org.buptdavid.datastructure.zj.design_mode.builder
 * @Description: 套餐
 * @date 2020/4/21/12:22
 */
public class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    /**
     * 获取套餐总价格
     * @return
     */
    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    /**
     * 打印套餐
     */
    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
