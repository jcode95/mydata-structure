package org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat;

import io.netty.channel.*;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @author jiezhou
 * @CalssName: MyServerHandler
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat
 * @Description:
 * @date 2022/3/29/23:13
 */
public class MyServerHandler extends ChannelHandlerAdapter {

    /**
     * @param ctx 上下文
     * @param evt 事件
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "空闲事件：" + eventType);

        }


    }


}
