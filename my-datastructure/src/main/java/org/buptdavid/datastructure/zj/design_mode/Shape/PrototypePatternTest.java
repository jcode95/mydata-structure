package org.buptdavid.datastructure.zj.design_mode.Shape;

/**
 * @author jiezhou
 * @CalssName: PrototypePatternTest
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape
 * @Description: 测试(工厂模式)
 * @date 2020/4/21/14:24
 */
public class PrototypePatternTest {

    public static void main(String[] args) {

        ShapeCache.loadCache();
        assert false:"i am error";
        Shape shape = ShapeCache.getShape("1");
        System.out.println("Shape : " + shape.getType());
        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());
        Shape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());


    }
}


