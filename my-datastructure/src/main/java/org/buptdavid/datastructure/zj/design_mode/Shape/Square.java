package org.buptdavid.datastructure.zj.design_mode.Shape;

/**
 * @author jiezhou
 * @CalssName: Square
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape
 * @Description: 正方形
 * @date 2020/4/21/14:14
 */
public class Square extends Shape {
    Square(){
        super.type="Square";
    }
    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
