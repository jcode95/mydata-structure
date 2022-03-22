package org.buptdavid.datastructure.zj.shangguigu.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author jiezhou
 * @CalssName: NioServer
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nio
 * @Description:
 * @date 2022/3/22/13:20
 */
public class NioServer {
    public static void main(String[] args) throws Exception {
        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //create Selector
        Selector selector = Selector.open();
        //bind port 6666 在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //吧serverSocketChannel 注册到Selector 监听连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //循环等待客户端连接
        while (true){
            //等待一秒，无事件发生，返回
            if(selector.select(1000)==0){
                System.out.println("服务器等待1秒，无连接");
                continue;
            }
            //>0  就获取关注的事件的到相关SelectionKey的有事件发生的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //根据selectionKey 对应的通道发生的事件做相应的处理
                if (selectionKey.isAcceptable()) {

                    //连接事件、给该客户端生成一个SockChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端链接成功...生成一个socketChannel"+socketChannel.getLocalAddress());
                    socketChannel.configureBlocking(false);//设置为非阻塞模型
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));



                }

                if(selectionKey.isReadable()){//发生op_read
                    //通过key，反向获取到对应channel
                    SocketChannel channel = (SocketChannel)selectionKey.channel();
                    ByteBuffer buffer= (ByteBuffer) selectionKey.attachment();
                    channel.read(buffer);
                    System.out.println("form 客户端 = " + new String(buffer.array()));
                }

                //手动从集合中移除当前的selectionKey,防止重复操作
                iterator.remove();
            }
        }

    }
}
