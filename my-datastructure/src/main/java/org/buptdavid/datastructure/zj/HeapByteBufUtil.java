
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
        System.out.println(4 & 1);
        System.out.println((9 | 1) - 1);
        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        /*写成宏，方便移植
        #define setbit(x,y) x|=(1<<y) //将X的第Y位置1
        #define clrbit(x,y) x&=～(1<<y) //将X的第Y位清0*/
        int x = 3;
        int y=1;
        int r = x & ~(1 <<y);
        System.out.println("x:"+Integer.toBinaryString(x));
        System.out.println("1 << y: " + Integer.toBinaryString(1 << y));
        System.out.println("~(1 << y): " + Integer.toBinaryString(~(1 << y)));
        System.out.println("r: " + Integer.toBinaryString(r));
        System.out.println("x|=(1<<y)  " + Integer.toBinaryString(x|(1<<y)));


        int m = 34355, n = 35345;
        int tmp=m;
        for (int i = 0; i < m + "".length()-2; i++) {
            tmp &= ~(1 << i);
            if(tmp<=m){
                break;
            }

        }
        System.out.println("tmp = " + tmp);
    }
}
