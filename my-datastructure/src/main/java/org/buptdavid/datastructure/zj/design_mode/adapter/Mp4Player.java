package org.buptdavid.datastructure.zj.design_mode.adapter;

/**
 * @author jiezhou
 * @CalssName: Mp4Player
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape.adapter
 * @Description: Mp4播放器
 * @date 2020/4/21/14:39
 */
public class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
