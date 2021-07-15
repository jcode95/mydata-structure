package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password;

/**
 * @author jiezhou
 * @CalssName: KaiserDemo
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password
 * @Description: 凯撒位移加密
 * @date 2021/7/15/13:23
 */
public class KaiserDemo {

    public static void main(String[] args) {
        String input = "Hello world";
        // 往右边移动3位
        int key = 3;
        String sb = encryptKaiser(input, key);
        System.out.println("秘文："+sb);
        String s = decryptKaiser(sb, key);
        System.out.println("原文:"+s);
    }

    /**
     * 凯撒加密
     *
     * @param input
     * @param key
     * @return
     */
    private static String encryptKaiser(String input, int key) {
        StringBuilder sb = new StringBuilder();
        // 字符串转换成字节数组
        char[] chars = input.toCharArray();
        for (char c : chars) {
            int asciiCode = c;
            // 移动3位
            asciiCode = asciiCode + key;
            char newChar = (char) asciiCode;
            sb.append(newChar);
        }
        return sb.toString();
    }

    /**
     * 凯撒解密
     *
     * @param input 秘文
     * @param key
     * @return
     */
    private static String decryptKaiser(String input, int key) {
        char[] chars = input.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : chars) {
            c -= key;
            sb.append(c);
        }
        return sb.toString();

    }
}
