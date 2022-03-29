package org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author jiezhou
 * @CalssName: NettyGroupChatServer
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat
 * @Description: netty 聊天群聊系统服务端
 * @date 2022/3/29/19:59
 */
public class NettyGroupChatServer {

    private static final int PORT = 9999;

    public void run() {
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, work)
                    .channel(NioServerSocketChannel.class)
                    .childOption(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("StringDecoder", new StringDecoder())
                                    .addLast("StringDecoder", new StringDecoder())
                                    .addLast("GroupChatServerHandler", new GroupChatServerHandler());
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap.bind(PORT).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new NettyGroupChatServer().run();
    }


}
