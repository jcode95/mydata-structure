package org.buptdavid.datastructure.zj.shangguigu.netty;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @author jiezhou
 * @CalssName: DelayTask
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty
 * @Description: netty 实现延迟任务
 * @date 2022/6/2/13:50
 */
public class DelayTask {
    public static void main(String[] args) {
        nettyTask();

    }

    private static void nettyTask() {

        //创建延迟任务实例
        HashedWheelTimer wheelTimer = new HashedWheelTimer(3,//时间间隔
                TimeUnit.SECONDS, 100//时间轮中的槽数
        );
        //创建一个任务

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("执行任务 时间：" + System.currentTimeMillis() / 1000);
            }
        };

        //将任务添加到延迟队列中
        wheelTimer.newTimeout(timerTask, 0, TimeUnit.SECONDS);
    }


}
