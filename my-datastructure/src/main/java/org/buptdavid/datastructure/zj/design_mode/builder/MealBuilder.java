package org.buptdavid.datastructure.zj.design_mode.builder;

/**
 * @author jiezhou
 * @CalssName: MealBuilder
 * @Package org.buptdavid.datastructure.zj.design_mode.builder
 * @Description: 创建套餐
 * @date 2020/4/21/12:24
 */
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());//植物蛋白汉堡
        meal.addItem(new Coke());//可口可乐冷饮
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());//鸡肉汉堡
        meal.addItem(new Pepsi());//百事可乐冷饮
        return meal;
    }
}
