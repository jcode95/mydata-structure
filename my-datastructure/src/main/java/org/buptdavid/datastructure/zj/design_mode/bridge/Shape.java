package org.buptdavid.datastructure.zj.design_mode.bridge;

/**
 * @author jiezhou
 * @CalssName: Shape
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape.adapter.bridge
 * @Description: 使用 DrawAPI 接口创建抽象类 Shape。
 * @date 2020/4/21/15:14
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();

}
