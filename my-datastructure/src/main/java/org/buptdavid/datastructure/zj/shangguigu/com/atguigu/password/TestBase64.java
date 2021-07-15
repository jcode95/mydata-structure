package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * @author jiezhou
 * @CalssName: TestBase64
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.password
 * @Description: 1.6.4 base64补等号测试
 * @date 2021/7/15/13:53
 */
public class TestBase64 {

    public static void main(String[] args) {
        //  1：MQ== 表示一个字节，不够三个字节，所以需要后面通过 == 号补齐
        System.out.println(Base64.encode("1".getBytes()));
        System.out.println(Base64.encode("12".getBytes()));
        System.out.println(Base64.encode("123".getBytes()));
//        // 硅谷:中文占6个字节，6 * 8 = 48 ，刚刚好被整除，所以没有等号
        System.out.println(Base64.encode("硅谷".getBytes()));
    }
}
