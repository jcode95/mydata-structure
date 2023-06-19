package org.buptdavid.datastructure.zj.design_mode.bridge;

/**
 * @author zhoujie
 * @CalssName: RedSquare
 * @Package org.buptdavid.datastructure.zj.design_mode.bridge
 * @Description:
 */
public class RedSquare implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {

    }

    @Override
    public void drawSquare(int x, int y) {
        System.out.println("Drawing Square[ color: red,x: " + x + ", " + y + "]");
    }
}
