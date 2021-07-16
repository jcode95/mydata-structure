package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author jiezhou
 * @CalssName: DigestDemo1
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password
 * @Description: 1.9.2 获取字符串消息摘要
 * @date 2021/7/15/16:27
 */
public class DigestDemo1 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 原文
        String input = "aa";
        // 算法
        String algorithm = "MD5";

        // 获取数字摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        // 获取消息数字摘要的字节数组
        byte[] digest = messageDigest.digest(input.getBytes());
        System.out.println(new String(digest));//会出现乱码。需要base64（apache 的） 来处理
        // base64编码
        System.out.println(Base64.encode(digest));

    }
}
