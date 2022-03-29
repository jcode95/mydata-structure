package org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author jiezhou
 * @CalssName: GroupChatHandler
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat
 * @Description:
 * @date 2022/3/29/20:11
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {
    //管理所有的channel
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        channelGroup.forEach(e -> {
            if (e != ctx.channel()) {
                e.writeAndFlush("[客户端 说]: " + msg);
            }
        });
    }

    //活跃
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        channelGroup.writeAndFlush("[客户端] " + ctx.channel().remoteAddress() + " 上线...");
    }

    //不活跃
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    }

    //读取事件

    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        channelGroup.writeAndFlush("[客户端] " + ctx.channel().remoteAddress() + " 下线...");

    }

    //报错会走这个
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    //channel 加入首先会走这个方法
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    }
}
