package org.buptdavid.datastructure.zj.shangguigu.netty.websocket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.EventExecutorGroup;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiezhou
 * @CalssName: MyWebSocketHandler
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.websocket
 * @Description:
 * @date 2022/3/31/11:14
 */
public class MyWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("服务器收到消息:" + msg.text());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String s="服务器回送消息："+msg.text()+"时间："+dateFormat.format(new Date());
        ctx.channel().writeAndFlush(new TextWebSocketFrame(s));
    }


}
