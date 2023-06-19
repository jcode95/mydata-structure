package org.buptdavid.datastructure.zj.design_mode.bridge;

/**
 * @author jiezhou
 * @CalssName: RedCircle
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape.adapter.bridge
 * @Description: 创建实现了 DrawAPI 接口的实体桥接实现类(红色圆)。
 * @date 2020/4/21/15:12
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }

    @Override
    public void drawSquare(int x, int y) {

    }
}
