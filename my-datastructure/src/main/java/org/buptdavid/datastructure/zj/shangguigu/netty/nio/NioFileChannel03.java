package org.buptdavid.datastructure.zj.shangguigu.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jiezhou
 * @CalssName: NioFileChannel03
 * @Package org.buptdavid.datastructure.zj.shangguigu.netty.nio
 * @Description:
 * @date 2022/3/21/21:47
 */
public class NioFileChannel03 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("F://c.txt");
        FileChannel channel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("F://c1.txt");
        FileChannel channel02 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {//未知文件大小，所以while循环
            byteBuffer.clear();
            int read = channel01.read(byteBuffer);//从channel读取到 byteBuffer
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            channel02.write(byteBuffer);//从byteBuffer读入到 channel
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
