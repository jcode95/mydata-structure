package org.buptdavid.datastructure.zj.design_mode.bridge;

/**
 * @author jiezhou
 * @CalssName: GreenCircle
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape.adapter.bridge
 * @Description: 绿色圆
 * @date 2020/4/21/15:13
 */
public class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
