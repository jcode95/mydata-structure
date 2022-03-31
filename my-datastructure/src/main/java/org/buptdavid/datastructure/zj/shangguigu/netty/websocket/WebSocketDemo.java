package org.buptdavid.datastructure.zj.shangguigu.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat.MyServerHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author jiezhou
 * @CalssName: WebSocketDemo
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.websocket
 * @Description: netty 实现 websocket 测试
 * @date 2022/3/31/11:06
 */
public class WebSocketDemo {

    public static void main(String[] args) throws Exception {

        EventLoopGroup boos = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boos, work)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new HttpServerCodec());
                            pipeline.addLast(new HttpObjectAggregator(1024));//幁
                            pipeline.addLast(new ChunkedWriteHandler());//块
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));
                            //加入对空闲检测的进一步处理的handler
                            pipeline.addLast(new MyWebSocketHandler());
                        }
                    });
            ChannelFuture future = bootstrap.bind(7000).sync();
            future.channel().closeFuture().sync();
        } finally {
            work.shutdownGracefully();
            boos.shutdownGracefully();
        }


    }
}
