package org.buptdavid.datastructure.zj.shangguigu.netty.nio.groupchat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author jiezhou
 * @CalssName: ChatServer
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nio.gurpchat
 * @Description: nio 聊天系统 服务端
 * @date 2022/3/23/19:45
 */
public class ChatServer {

    private ServerSocketChannel listenChannel;

    private Selector selector;

    private static final int PORT = 6667;

    public ChatServer() {
        try {
            listenChannel = ServerSocketChannel.open();
            selector = Selector.open();
            listenChannel.configureBlocking(false);//设置为非阻塞
            listenChannel.socket().bind(new InetSocketAddress(PORT));//绑定端口
            //注册到selector ,监听链接事件
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void listen() {
        try {
            while (true) {
                int c = selector.select();
                if (c > 0) {
                    //有事件发生，处理事件
                    Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                    while (keyIterator.hasNext()) {
                        SelectionKey key = keyIterator.next();
                        if (key.isAcceptable()) {
                            //当是链接事件时
                            //取出当前的SocketChannel
                            SocketChannel sc = listenChannel.accept();
                            //设置非阻塞
                            sc.configureBlocking(false);
                            //注册到select。监听读事件
                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println("玩家："+sc.getRemoteAddress()+"  上线...");
                            //转发消息给其他玩家
                            String msg="玩家："+sc.getRemoteAddress()+"  上线...";
                            sendMsgOtherClients(msg,sc);
                        }
                        //如果是读事件
                        if(key.isReadable()){
                            //读取写在另一个方法里面
                            readDate(key);
                        }
                        //删除key,防止重复处理
                        keyIterator.remove();
                    }
                }else{
//                    System.out.println("等待...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readDate(SelectionKey key){
        //取到关联的Channel
        SocketChannel channel=null;
        try {
            //得到channel
            channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int c = channel.read(buffer);
            if(c>0){
                //吧缓冲区的数据转换为字符串
                String msg = new String(buffer.array());
                //输出该消息
                System.out.println("form  客户端： " + msg);
                //转发消息给其他玩家
                sendMsgOtherClients(msg,channel);
            }
        }catch (Exception e){
//            e.printStackTrace();
            try {
                String msg="玩家："+channel.getRemoteAddress()+"下线...";
                System.out.println("玩家："+channel.getRemoteAddress()+"下线...");
                //转发消息给其他玩家
                sendMsgOtherClients(msg,channel);
                //删除注册
                key.cancel();
                //关闭通道
                channel.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * 转发消息给其他玩家
     * @param msg 消息
     * @param self 自己
     */
    private void sendMsgOtherClients(String msg, SocketChannel self) {
//        System.out.println("服务器消息转发中..... ");
        try {
            for (SelectionKey key : selector.keys()) {//拿到所有注册到select上的客户端
                Channel channel = key.channel();
                //排除给自己发
                if (channel instanceof SocketChannel && channel != self) {
                    ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                    ((SocketChannel) channel).write(buffer);//吧数据从buff写入通道
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.listen();
    }
}
