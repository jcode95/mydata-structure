package org.buptdavid.datastructure.zj.thread.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author jiezhou
 * @CalssName: TimerTaskDemo
 * @Package book.test
 * @Description:
 * @date 2020/7/4/10:13
 */
public class TimerTaskDemo {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTaskTest(),1000,2000);//启动之后1秒钟开始执行，间隔2秒执行一次
    }

    static class TimerTaskTest extends TimerTask{
        
        @Override
        public void run() {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("当前时间："+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(now));
        }
    }


}
