package org.buptdavid.datastructure.zj.shangguigu.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jiezhou
 * @CalssName: NioFileChannel02
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nio
 * @Description:
 * @date 2022/3/21/21:27
 */
public class NioFileChannel02 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("F://c.txt");
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileChannel channel = fileInputStream.getChannel();
        channel.read(byteBuffer);
        System.out.println(" "+new String(byteBuffer.array()));

    }
}
