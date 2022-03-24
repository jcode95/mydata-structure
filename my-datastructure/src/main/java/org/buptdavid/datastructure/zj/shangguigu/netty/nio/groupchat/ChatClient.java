package org.buptdavid.datastructure.zj.shangguigu.netty.nio.groupchat;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author jiezhou
 * @CalssName: ChatClient
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nio.groupchat
 * @Description: nio 聊天系统客户端
 * @date 2022/3/24/13:37
 */
public class ChatClient {

    private static final int PORT = 6667;
    private static final String HOST = "127.0.0.1";
    private SocketChannel listenChannel;
    private Selector selector;

    private String USRERNAME = null;

    public ChatClient() {
        try {
            listenChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            selector = Selector.open();
            listenChannel.configureBlocking(false);//设置为非阻塞
            //注册到selector ,监听读事件
            listenChannel.register(selector, SelectionKey.OP_READ);
            USRERNAME = listenChannel.getLocalAddress().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void sendMsg(String msg) {
        try {
            msg = USRERNAME + "说：" + msg;
            ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
            listenChannel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readMsg() {
        try {
            int read = selector.select();//如果有可用的通道
            if (read > 0) {
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    if (key.isReadable()) {
                        //得到key对应的通道
                        SocketChannel channel = (SocketChannel) key.channel();
                        //创建一个byteBuffer
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //吧数据从通道读入bytebuffer
                        channel.read(buffer);
                        System.out.println(new String(buffer.array()));
                    }
                }
            } else {
//                System.out.println(" 无可用通道...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        //读取
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    chatClient.readMsg();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        //输入
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String msg = scanner.nextLine();
            chatClient.sendMsg(msg);
        }

    }
}
