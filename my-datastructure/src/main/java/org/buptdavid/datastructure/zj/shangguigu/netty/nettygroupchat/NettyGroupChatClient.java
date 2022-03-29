package org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @author jiezhou
 * @CalssName: NettyGroupChatClient
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nettygroupchat
 * @Description:群聊系统客户端
 * @date 2022/3/29/20:39
 */
public class NettyGroupChatClient {

    public static void main(String[] args) {
        new NettyGroupChatClient().connect();
    }
    public void connect(){
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap=new Bootstrap();
        try {
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("StringEncoder",new StringEncoder());
                            pipeline.addLast("StringDecoder",new StringDecoder());
                            pipeline.addLast("GroupChatClientHandler",new GroupChatClientHandler());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8888).sync();

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String msg = scanner.nextLine();
                channelFuture.channel().writeAndFlush(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }

    }
}
