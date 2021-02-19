package org.buptdavid.datastructure.zj.zookeeper_book_my;

/**
 * 左移
 */
public class LeftOperation {

    public static void main(String[] args) {
        int a = -7;
        System.out.println("移位前：a=" + Integer.toBinaryString(a));
        int b = a << 2;
        System.out.println("向左移动2位后：a=" + Integer.toBinaryString(b));
        int c = a / 4;
        System.out.println(a);
        System.out.println(b);
        int d = -7;
        int e = 7;
        System.out.println("d:" + Integer.toBinaryString(d));
        System.out.println("e:" + Integer.toBinaryString(e));

        /***
         * 在计算机中都是用补码去表示（我们看的时候也是用补码去换算的）
         *  负数的补码=反码+1
         *
         *  左移几位就是乘2的几次方，右移就是除以2的几次方
         *
         * 11111111111111111111111111111001   -7的补码
         * 00000000000000000000000000000111   7的原码
         * 01111111111111111111111111111000   7的反码
         * 00000000000000000000000000000111   7的补码（补码换算：（对于负数；来说  原码取反+1 ， 最高位用1表示就ok了） 正数补码与原码相同，这是规定）
         *
         * 11111111111111111111111111111001   -7的补码，也就是程序输出的（程序输出的都是补码）
         *
         * 00000000000000000000000000000110
         * 00000000000000000000000000000111     1+1*2+1*4=7
         * 10000000000000000000000000000111    -7的原码
         * 11111111111111111111111111111000    -7的反码
         * 11111111111111111111111111111001   -7的补码，也就是程序输出的（程序输出的都是补码，对于负数；来说  原码取反+1 ， 最高位用1表示就ok了）正数补码与原码相同，这是规定
         *
         *
         *
         * >>>表示不带符号向右移动二进制数，移动后前面统统补0；两个箭头表示带符号移动，

         没有<<<这种运算符，因为左移都是补零，没有正负数的区别。

         如 -12 的二进制为：1111  1111  1111  1111  1111  1111  1111  0100；

         -12 >> 3 即带符号右移3位（右移之后再最高位补符号（负数补1，正数补0）），结果是：1111  1111  1111  1111  1111  1111  1111  1110，十进制为： -2；

         -12 >>> 3 就是无符号右移三位，前面补零，为：0001  1111  1111  1111  1111  1111  1111  1110，十进制为：536870910。
         *
         */


    }

    public String ss() {
        String localIpChange = "2143243";
        String str = null;
        if (localIpChange != null) {
            str = localIpChange;
        }
        do {
//            return str;
            str = "sdasd";
        } while (str != null);
        return "可试看20分钟";
    }
}
