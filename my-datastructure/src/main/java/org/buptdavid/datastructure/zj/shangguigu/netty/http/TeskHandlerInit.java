package org.buptdavid.datastructure.zj.shangguigu.netty.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author jiezhou
 * @CalssName: TestHandlerInit
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.http
 * @Description:
 * @date 2022/3/28/10:55
 */
public class TeskHandlerInit extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());
        pipeline.addLast("TaskHttpHandler",new TaskHttpHandler());
    }
}
