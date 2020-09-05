package org.buptdavid.datastructure.zj.design_mode.bridge;

/**
 * @author jiezhou
 * @CalssName: DrawAPI
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape.adapter.bridge
 * @Description: 创建桥接实现接口。
 * @date 2020/4/21/15:12
 */
public interface DrawAPI {
    public void drawCircle(int radius, int x, int y);
}
