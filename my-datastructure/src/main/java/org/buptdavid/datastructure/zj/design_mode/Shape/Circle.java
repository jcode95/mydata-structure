package org.buptdavid.datastructure.zj.design_mode.Shape;

/**
 * @author jiezhou
 * @CalssName: Circle
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape
 * @Description: 圆
 * @date 2020/4/21/14:16
 */
public class Circle extends Shape{
    Circle(){
        super.type="Circle";
    }
    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
