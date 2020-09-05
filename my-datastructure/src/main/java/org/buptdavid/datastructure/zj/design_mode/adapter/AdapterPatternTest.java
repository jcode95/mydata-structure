package org.buptdavid.datastructure.zj.design_mode.adapter;

/**
 * @author jiezhou
 * @CalssName: AdapterPatternTest
 * @Package org.buptdavid.datastructure.zj.design_mode.builder.Shape.adapter
 * @Description: 测试
 * @date 2020/4/21/14:46
 */
public class AdapterPatternTest {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
