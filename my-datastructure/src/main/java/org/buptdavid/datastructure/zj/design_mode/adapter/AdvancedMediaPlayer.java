package org.buptdavid.datastructure.zj.design_mode.adapter;

/**
 * @author jiezhou
 * @InterfaceName: AdvancedMediaPlayer
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape.adapter
 * @Description: 更高级的媒体播放器
 * @date 2020/4/21/14:37
 */
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
