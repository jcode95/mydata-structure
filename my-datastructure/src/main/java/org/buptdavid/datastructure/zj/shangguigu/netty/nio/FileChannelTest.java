package org.buptdavid.datastructure.zj.shangguigu.netty.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jiezhou
 * @CalssName: FileChannl
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nio
 * @Description: 文件channl 测试
 * @date 2021/12/21/16:53
 */
public class FileChannelTest {

    public static void main(String[] args) throws Exception {
        String str = "hello FileChannel";
        FileOutputStream fileOutputStream = new FileOutputStream("F://c.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        //重置一下标志位
        byteBuffer.flip();
        //将数据从buff 刷入到channel
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
