package org.buptdavid.datastructure.zj.design_mode.bridge;

/**
 * @author jiezhou
 * @CalssName: Circle
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape.adapter.bridge
 * @Description: 圆
 * @date 2020/4/21/15:15
 */
public class Circle extends Shape{
    private int x, y, radius;

    protected Circle(int x,int y,int radius,DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        super.drawAPI.drawCircle(radius,x,y);
    }
}
