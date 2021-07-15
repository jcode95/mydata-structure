package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password;

/**
 * @author jiezhou
 * @CalssName: AsciiDemo
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password
 * @Description: ASCII编码
 * @date 2021/7/15/13:21
 */
public class AsciiDemo {
    public static void main(String[] args) {
//        char a = 'A';
//        int b = a;
//        System.out.println(b);
        String a = "AaZ";
        // 获取ascii码，需要把字符串转成字符
        char[] chars = a.toCharArray();
        for (char c : chars) {
            int asciiCode = c;
            System.out.println(asciiCode);
        }
    }
}
