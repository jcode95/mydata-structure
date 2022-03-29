package org.buptdavid.datastructure.zj.shangguigu.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author jiezhou
 * @CalssName: TestHttpServer
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.http
 * @Description: netty 做 http 服务器
 * @date 2022/3/28/10:55
 */
public class TeskHttpServer {
    public static void main(String[] args) throws Exception {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(boss, work).channel(NioServerSocketChannel.class)
                    .childHandler(new TeskHandlerInit());
            ChannelFuture future = serverBootstrap.bind(6668).sync();
            future.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }

    }
}
