package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author jiezhou
 * @CalssName: AesDemo
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password
 * @Description: 1.6.5 AES加密解密
 * @date 2021/7/15/13:58
 */
public class AesDemo {
    public static void main(String[] args) throws Exception {
        // DES加密算法,key的大小必须是8个字节
        String input = "硅谷";
        // AES加密算法，比较高级，所以key的大小必须是16个字节
        String key = "1234567812345678";
        String transformation = "AES";
        // 指定获取密钥的算法
        String algorithm = "AES";
        // 先测试加密，然后在测试解密
        String encryptDES = encryptAES(input, key, transformation, algorithm);
        System.out.println("加密:" + encryptDES);
        String s = dncryptAES(encryptDES, key, transformation, algorithm);
        System.out.println("解密:" + s);
    }

    /**
     * AES 解密
     *
     * @param encryptDES
     * @param key
     * @param transformation
     * @param algorithm
     * @return
     */
    private static String dncryptAES(String encryptDES, String key, String transformation, String algorithm) throws Exception {
        // 1,获取Cipher对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 指定密钥规则
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        cipher.init(Cipher.DECRYPT_MODE, sks);
        // 3. 解密
        byte[] bytes = cipher.doFinal(Base64.decode(encryptDES));

        return new String(bytes);

    }

    /**
     * AES 加密
     *
     * @param input
     * @param key
     * @param transformation
     * @param algorithm
     * @return
     */
    private static String encryptAES(String input, String key, String transformation, String algorithm) throws Exception {
        // 获取加密对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 创建加密规则
        // 第一个参数key的字节
        // 第二个参数表示加密算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        // ENCRYPT_MODE：加密模式
        // DECRYPT_MODE: 解密模式
        // 初始化加密模式和算法
        cipher.init(Cipher.ENCRYPT_MODE, sks);
        // 加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        // 输出加密后的数据
        String encode = Base64.encode(bytes);
        return encode;
    }


}
