package org.buptdavid.datastructure.zj;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author jiezhou
 * @CalssName: ReadFileNio
 * @Package org.buptdavid.datastructure.zj
 * @Description: NIo 来读取文件
 * @date 2021/6/4/15:20
 */
public class ReadFileNio {


    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("my-datastructure/src/nioFile", "rwd");
        FileChannel channel = file.getChannel();
        try {
            //定义一个缓冲buf
            ByteBuffer buffer = ByteBuffer.allocate(20);//堆内存
//        ByteBuffer.allocateDirect()//直接内存
            int i = channel.read(buffer);
            while (i != -1) {
                System.out.print("read...");
                buffer.flip();//刷新读下标和写下标
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.print(b);
                }
                System.out.println(" ");
                buffer.clear();//清空接受的数据
                i = channel.read(buffer);//再次读取
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            file.close();
            channel.close();
        }


    }
}
