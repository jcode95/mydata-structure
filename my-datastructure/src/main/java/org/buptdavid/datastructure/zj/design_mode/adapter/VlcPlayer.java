package org.buptdavid.datastructure.zj.design_mode.adapter;

/**
 * @author jiezhou
 * @CalssName: VlcPlayer
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape.adapter
 * @Description: Vc播放器
 * @date 2020/4/21/14:38
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
