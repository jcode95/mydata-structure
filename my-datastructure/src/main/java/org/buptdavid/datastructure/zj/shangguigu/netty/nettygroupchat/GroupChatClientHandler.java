package org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author jiezhou
 * @CalssName: GroupChatClientHandler
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat
 * @Description:
 * @date 2022/3/29/20:47
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().writeAndFlush("我是：" + ctx.channel().localAddress());
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        //打印打控制台
        System.out.println(msg);
    }
}
