package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password;

/**
 * ByteBit
 *
 * @Author:
 * @CreateTime: 2020-03-17
 * @Description:
 */
public class ByteBit {
    public static void main(String[] args) {
        String a = "a";
        byte[] bytes = a.getBytes();
        for (byte b : bytes) {
            int c=b;
            // 打印发现byte实际上就是ascii码
            System.out.println(c);

            // 我们在来看看每个byte对应的bit，byte获取对应的bit
            String s = Integer.toBinaryString(c);
            System.out.println(s);
        }
    }
}