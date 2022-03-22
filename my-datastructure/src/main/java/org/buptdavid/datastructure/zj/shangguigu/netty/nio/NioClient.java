package org.buptdavid.datastructure.zj.shangguigu.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author jiezhou
 * @CalssName: NioClient
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nio
 * @Description:
 * @date 2022/3/22/22:19
 */
public class NioClient {

    public static void main(String[] args) throws Exception {
        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();

        //设置为非阻塞
        socketChannel.configureBlocking(false);
        //地址
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6666);

        if(!socketChannel.connect(address)){
            while (!socketChannel.finishConnect()){
                System.out.println("因为链接需要时间，客户端不会阻塞，可以做其他工作...");
            }
        }


        String str="hello ,Nio";

        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        socketChannel.write(byteBuffer);//写入到socketChannel

        System.in.read();//线程阻塞在这



    }




}
