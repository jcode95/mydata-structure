package org.buptdavid.datastructure.zj.design_mode.adapter;

/**
 * @author jiezhou
 * @CalssName: MediaAdapter
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape.adapter
 * @Description: 创建实现了 MediaPlayer 接口的适配器类。
 * @date 2020/4/21/14:40
 */
public class MediaAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMusicPlayer;

    MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer=new VlcPlayer();
        }else if (audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer=new Mp4Player();
        }
    }
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
