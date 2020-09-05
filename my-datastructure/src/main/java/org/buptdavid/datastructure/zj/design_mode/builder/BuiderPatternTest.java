package org.buptdavid.datastructure.zj.design_mode.builder;

/**
 * @author jiezhou
 * @CalssName: BuiderPatternTest
 * @Package org.buptdavid.datastructure.zj.design_mode.builder
 * @Description: 使用 MealBuider 来演示建造者模式（Builder Pattern）。
 * @date 2020/4/21/12:26
 */
public class BuiderPatternTest {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareNonVegMeal();
        meal.showItems();
        float cost = meal.getCost();
        System.out.println("总价格："+cost+"$");
        System.out.println("---------------------------------------------");
        Meal meal1 = mealBuilder.prepareVegMeal();
        meal1.showItems();
        float cost1 = meal1.getCost();
        System.out.println("总价格："+cost1+"$");
    }

}
