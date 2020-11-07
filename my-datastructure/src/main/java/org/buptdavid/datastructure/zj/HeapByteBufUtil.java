
package org.buptdavid.datastructure.zj;

/**
 * Utility class for heap buffers.
 */
final class HeapByteBufUtil {



    private HeapByteBufUtil() {
    }

    public static void main(String[] args) {
        /*
        *   010
            101

            & = 000 =0
            | = 111 =1*2^0+1*2^1+1*2^2=1+2+4=7
        * */

        /*
        *
        * 总结：
            | ：两个二进制对应位都为0时，结果等于0，否则结果等于1；

            & ：两个二进制的对应位都为1时，结果为1，否则结果等于0；

            ^ ：两个二进制的对应位相同，结果为0，否则结果为1。
        **/


        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(2 & 5);
        System.out.println(2 | 5);


    }
}
