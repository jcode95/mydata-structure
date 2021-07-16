package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 * @author jiezhou
 * @CalssName: DigestToFileDemo
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password
 * @Description: 1.9.5 获取文件消息摘要
 * @date 2021/7/16/10:17
 */
public class DigestToFileDemo {

    public static void main(String[] args) throws Exception {
        String input = "aa";
        String algorithm = "MD5";
        // sha1 可以实现秒传功能
        String sha1 = getDigestFile("E:\\BaiduNetdiskDownload\\navicat-keygen-for-x64(1).zip", "SHA-1");
        System.out.println(sha1);

        String sha512 = getDigestFile("E:\\BaiduNetdiskDownload\\navicat-keygen-for-x64(1).zip", "SHA-512");
        System.out.println(sha512);
        String md5 = getDigest("aa", "MD5");
        System.out.println(md5);

        String md51 = getDigest("aa ", "MD5");
        System.out.println(md51);
    }

    private static String getDigestFile(String filePath, String algorithm) throws Exception {

        FileInputStream fis = new FileInputStream(filePath);
        int len;
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        // 获取消息摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        // 获取消息摘要
        byte[] digest = messageDigest.digest(baos.toByteArray());
        System.out.println("密文的字节长度：" + digest.length);
        return toHex(digest);
    }

    private static String getDigest(String input, String algorithm) throws Exception {
        // 获取消息摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        byte[] digest = messageDigest.digest(input.getBytes());
        System.out.println("密文的字节长度：" + digest.length);
        return toHex(digest);
    }

    private static String toHex(byte[] digest) {
        System.out.println(new String(digest));
        // 消息摘要进行表示的时候，是用16进制进行表示
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            // 转成16进制
            String s = Integer.toHexString(b & 0xff);//不清楚 看 org.buptdavid.datastructure.zj.zookeeper_book_my.LeftOperation
            // 保持数据的完整性，前面不够的用0补齐
            if (s.length() == 1) {
                s = "0" + s;
            }
            sb.append(s);
        }
        System.out.println("16进制数据的长度:" + sb.toString().getBytes().length);
        return sb.toString();
    }


    /*
    *
    *   总结:
        MD5算法 : 摘要结果16个字节, 转16进制后32个字节
        SHA1算法 : 摘要结果20个字节, 转16进制后40个字节
        SHA256算法 : 摘要结果32个字节, 转16进制后64个字节
        SHA512算法 : 摘要结果64个字节, 转16进制后128个字节
    * */
}
