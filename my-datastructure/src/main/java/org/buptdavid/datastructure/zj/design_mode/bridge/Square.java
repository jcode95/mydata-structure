package org.buptdavid.datastructure.zj.design_mode.bridge;

/**
 * @author zhoujie
 * @CalssName: Square
 * @Package org.buptdavid.datastructure.zj.design_mode.bridge
 * @Description:正方形
 */
public class Square extends Shape{
    protected int x,y;

    public Square(DrawAPI drawAPI, int x, int y) {
        super(drawAPI);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.drawSquare(x,y);
    }
}
