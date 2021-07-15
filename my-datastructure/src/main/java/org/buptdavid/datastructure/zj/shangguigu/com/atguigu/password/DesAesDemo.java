package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author jiezhou
 * @CalssName: DesAesDemo
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password
 * @Description: des加密算法
 * @date 2021/7/15/13:36
 */
public class DesAesDemo {


    public static void main(String[] args) throws Exception {
        // 原文
        String input = "硅谷";
        // des加密必须是8位
        String key = "12345678";
        // 算法
        String algorithm = "DES";
        String transformation = "DES";
        String encryptDESString = encryptDES(input, key, algorithm, transformation);
        System.out.println("加密:" + encryptDESString);
        String s = decryptDES(encryptDESString, key, algorithm, transformation);
        System.out.println("解密:" + s);


    }

    /**
     *  使用DES解密
     * @param encryptDESString  密文
     * @param key
     * @param algorithm
     * @param transformation
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    private static String decryptDES(String encryptDESString, String key, String algorithm, String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 1、获取Cipher对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 2、指定密钥规则
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        cipher.init(Cipher.DECRYPT_MODE, sks);
        // 3、解密，上面使用的base64编码，下面直接用密文
        byte[] bytes = cipher.doFinal(Base64.decode(encryptDESString));
        //  因为是明文，所以直接返回
        String s = new String(bytes);
        System.out.println("原文  = " + s);
        return s;
    }

    /**
     * 使用DES加密数据
     * @param input 原文
     * @param key
     * @param algorithm
     * @param transformation
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    private static String encryptDES(String input, String key, String algorithm, String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // Cipher：密码，获取加密对象
        // transformation:参数表示使用什么类型加密
        Cipher cipher = Cipher.getInstance(transformation);
        // 指定秘钥规则
        // 第一个参数表示：密钥，key的字节数组
        // 第二个参数表示：算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        // 对加密进行初始化
        // 第一个参数：表示模式，有加密模式和解密模式
        // 第二个参数：表示秘钥规则
        cipher.init(Cipher.ENCRYPT_MODE,sks);
        // 进行加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        // 打印字节，因为ascii码有负数，解析不出来，所以乱码
//        for (byte b : bytes) {
//            System.out.println(b);
//        }
        // 打印密文
        System.out.println(new String(bytes));

        String encode = Base64.encode(bytes);
        System.out.println("encode = " + encode);
        return encode;
    }
}
