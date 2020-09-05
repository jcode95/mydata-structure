package org.buptdavid.datastructure.zj.design_mode.Shape;

/**
 * @author jiezhou
 * @CalssName: Rectangle
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape
 * @Description: 长方形
 * @date 2020/4/21/14:13
 */
public class Rectangle extends Shape{
    Rectangle(){
        super.type="Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
