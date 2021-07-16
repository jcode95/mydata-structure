package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.io.FileUtils;

import javax.crypto.Cipher;
import java.io.File;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author jiezhou
 * @CalssName: RSAdemo
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password
 * @Description: 1.10.1 生成公钥和私钥
 * @date 2021/7/16/11:02
 */
public class RSAdemo {


    public static void main(String[] args) throws Exception {
        String input = "硅谷";
        // 加密算法
        String algorithm = "RSA";
        /*//  创建密钥对生成器对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 生成私钥
        PrivateKey privateKey = keyPair.getPrivate();
        // 生成公钥
        PublicKey publicKey = keyPair.getPublic();
        // 获取私钥字节数组
        byte[] privateKeyEncoded = privateKey.getEncoded();
        // 获取公钥字节数组
        byte[] publicKeyEncoded = publicKey.getEncoded();
        // 对公私钥进行base64编码
        String privateKeyString = Base64.encode(privateKeyEncoded);
        String publicKeyString = Base64.encode(publicKeyEncoded);
        // 打印私钥
        System.out.println(privateKeyString);
        // 打印公钥
        System.out.println(publicKeyString);


        //===============加密===================
        // 创建加密对象
        // 参数表示加密算法
        Cipher cipher = Cipher.getInstance(algorithm);
        // 初始化加密
        // 第一个参数:加密的模式
        // 第二个参数：使用私钥进行加密
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        // 私钥加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        System.out.println(Base64.encode(bytes));

        //===============解密===================
        // 私钥进行解密
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        // 对密文进行解密，不需要使用base64，因为原文不会乱码
        byte[] bytes1 = cipher.doFinal(bytes);
        System.out.println(new String(bytes1));*/


//        生成密钥对并保存在本地文件中
        generateKeyToFile(algorithm, "a.pub", "a.pri");

        PrivateKey prikey = getPrivateKey("a.pri", algorithm);
        PublicKey publicKey = getPublicKey("a.pub", algorithm);
        String s = encryptRSA(algorithm, prikey, input);
        String yanwen = decryptRSA(algorithm, publicKey, s);
        System.out.println("yanwen = " + yanwen);
    }

    /**
     * 生成密钥对并保存在本地文件中
     *
     * @param algorithm : 算法
     * @param pubPath   : 公钥保存路径
     * @param priPath   : 私钥保存路径
     * @throws Exception
     */
    private static void generateKeyToFile(String algorithm, String pubPath, String priPath) throws Exception {
        // 获取密钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 获取密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 获取公钥
        PublicKey publicKey = keyPair.getPublic();
        // 获取私钥
        PrivateKey privateKey = keyPair.getPrivate();
        // 获取byte数组
        byte[] publicKeyEncoded = publicKey.getEncoded();
        byte[] privateKeyEncoded = privateKey.getEncoded();
        // 进行Base64编码
        String publicKeyString = Base64.encode(publicKeyEncoded);
        String privateKeyString = Base64.encode(privateKeyEncoded);
        // 保存文件
        FileUtils.writeStringToFile(new File(pubPath), publicKeyString, Charset.forName("UTF-8"));
        FileUtils.writeStringToFile(new File(priPath), privateKeyString, Charset.forName("UTF-8"));
    }

    /**
     * 读取私钥
     *
     * @param priPath
     * @param algorithm
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String priPath, String algorithm) throws Exception {
        // 将文件内容转为字符串
        String privateKeyString = FileUtils.readFileToString(new File(priPath), Charset.defaultCharset());
        // 获取密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        // 构建密钥规范 进行Base64解码
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.decode(privateKeyString));
        // 生成私钥
        return keyFactory.generatePrivate(spec);

    }

    /**
     * 读取公钥
     * @param pulickPath
     * @param algorithm
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String pulickPath,String algorithm) throws Exception{
        // 将文件内容转为字符串
        String publicKeyString = FileUtils.readFileToString(new File(pulickPath), Charset.defaultCharset());
        // 获取密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        // 构建密钥规范 进行Base64解码
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decode(publicKeyString));
        // 生成公钥
        return keyFactory.generatePublic(spec);
    }


    /**
     * 使用密钥加密数据
     *
     * @param algorithm      : 算法
     * @param input          : 原文
     * @param key            : 密钥
     * @return : 密文
     * @throws Exception
     */
    public static String encryptRSA(String algorithm,Key key,String input) throws Exception{
        // 创建加密对象
        // 参数表示加密算法
        Cipher cipher = Cipher.getInstance(algorithm);
        // 初始化加密
        // 第一个参数:加密的模式
        // 第二个参数：使用私钥进行加密
        cipher.init(Cipher.ENCRYPT_MODE,key);
        // 私钥加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        // 对密文进行Base64编码
        return Base64.encode(bytes);
    }

    /**
     * 解密数据
     *
     * @param algorithm      : 算法
     * @param encrypted      : 密文
     * @param key            : 密钥
     * @return : 原文
     * @throws Exception
     */
    public static String decryptRSA(String algorithm,Key key,String encrypted) throws Exception{
        // 创建加密对象
        // 参数表示加密算法
        Cipher cipher = Cipher.getInstance(algorithm);
        // 私钥进行解密
        cipher.init(Cipher.DECRYPT_MODE,key);
        // 由于密文进行了Base64编码, 在这里需要进行解码
        byte[] decode = Base64.decode(encrypted);
        // 对密文进行解密，不需要使用base64，因为原文不会乱码
        byte[] bytes1 = cipher.doFinal(decode);
        return new String(bytes1);

    }

}
