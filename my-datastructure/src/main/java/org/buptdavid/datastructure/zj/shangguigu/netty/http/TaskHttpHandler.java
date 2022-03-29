package org.buptdavid.datastructure.zj.shangguigu.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URL;


/**
 * @author jiezhou
 * @CalssName: TaskHttpHandler
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.http
 * @Description:
 * @date 2022/3/28/11:10
 */
public class TaskHttpHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        String msg = "服务器返回消息 ";
        if (httpObject instanceof HttpRequest) {

            //过滤消息
            HttpRequest httpRequest = (HttpRequest) httpObject;
            /*URL url = new URL(httpRequest.uri());
            if ("".equals(url.getPath())) {
                System.out.println("消息过滤...");
                return;
            }*/

            //构建消息返回游览器
            ByteBuf byteBuf = Unpooled.copiedBuffer(msg.getBytes(CharsetUtil.UTF_8));
            //构造http相应httpResponse DefaultFullHttpResponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes() + "");
            ctx.writeAndFlush(response);
        }


    }

}
