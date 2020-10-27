
package org.buptdavid.datastructure.zj;

/**
 * Utility class for heap buffers.
 */
final class HeapByteBufUtil {

    static byte getByte(byte[] memory, int index) {
        return memory[index];
    }

    static short getShort(byte[] memory, int index) {
        return (short) (memory[index] << 8 | memory[index + 1] & 0xFF);
    }

    static short getShortLE(byte[] memory, int index) {
        return (short) (memory[index] & 0xff | memory[index + 1] << 8);
    }

    static int getUnsignedMedium(byte[] memory, int index) {
        return  (memory[index]     & 0xff) << 16 |
                (memory[index + 1] & 0xff) <<  8 |
                memory[index + 2] & 0xff;
    }

    static int getUnsignedMediumLE(byte[] memory, int index) {
        return  memory[index]     & 0xff         |
                (memory[index + 1] & 0xff) <<  8 |
                (memory[index + 2] & 0xff) << 16;
    }

    static int getInt(byte[] memory, int index) {
        return  (memory[index]     & 0xff) << 24 |
                (memory[index + 1] & 0xff) << 16 |
                (memory[index + 2] & 0xff) <<  8 |
                memory[index + 3] & 0xff;
    }

    static int getIntLE(byte[] memory, int index) {
        return  memory[index]      & 0xff        |
                (memory[index + 1] & 0xff) << 8  |
                (memory[index + 2] & 0xff) << 16 |
                (memory[index + 3] & 0xff) << 24;
    }

    static long getLong(byte[] memory, int index) {
        return  ((long) memory[index]     & 0xff) << 56 |
                ((long) memory[index + 1] & 0xff) << 48 |
                ((long) memory[index + 2] & 0xff) << 40 |
                ((long) memory[index + 3] & 0xff) << 32 |
                ((long) memory[index + 4] & 0xff) << 24 |
                ((long) memory[index + 5] & 0xff) << 16 |
                ((long) memory[index + 6] & 0xff) <<  8 |
                (long) memory[index + 7] & 0xff;
    }

    static long getLongLE(byte[] memory, int index) {
        return  (long) memory[index]      & 0xff        |
                ((long) memory[index + 1] & 0xff) <<  8 |
                ((long) memory[index + 2] & 0xff) << 16 |
                ((long) memory[index + 3] & 0xff) << 24 |
                ((long) memory[index + 4] & 0xff) << 32 |
                ((long) memory[index + 5] & 0xff) << 40 |
                ((long) memory[index + 6] & 0xff) << 48 |
                ((long) memory[index + 7] & 0xff) << 56;
    }

    static void setByte(byte[] memory, int index, int value) {
        memory[index] = (byte) value;
    }

    static void setShort(byte[] memory, int index, int value) {
        memory[index]     = (byte) (value >>> 8);
        memory[index + 1] = (byte) value;
    }

    static void setShortLE(byte[] memory, int index, int value) {
        memory[index]     = (byte) value;
        memory[index + 1] = (byte) (value >>> 8);
    }

    static void setMedium(byte[] memory, int index, int value) {
        memory[index]     = (byte) (value >>> 16);
        memory[index + 1] = (byte) (value >>> 8);
        memory[index + 2] = (byte) value;
    }

    static void setMediumLE(byte[] memory, int index, int value) {
        memory[index]     = (byte) value;
        memory[index + 1] = (byte) (value >>> 8);
        memory[index + 2] = (byte) (value >>> 16);
    }

    static void setInt(byte[] memory, int index, int value) {
        memory[index]     = (byte) (value >>> 24);
        memory[index + 1] = (byte) (value >>> 16);
        memory[index + 2] = (byte) (value >>> 8);
        memory[index + 3] = (byte) value;
    }

    static void setIntLE(byte[] memory, int index, int value) {
        memory[index]     = (byte) value;
        memory[index + 1] = (byte) (value >>> 8);
        memory[index + 2] = (byte) (value >>> 16);
        memory[index + 3] = (byte) (value >>> 24);
    }

    static void setLong(byte[] memory, int index, long value) {
        memory[index]     = (byte) (value >>> 56);
        memory[index + 1] = (byte) (value >>> 48);
        memory[index + 2] = (byte) (value >>> 40);
        memory[index + 3] = (byte) (value >>> 32);
        memory[index + 4] = (byte) (value >>> 24);
        memory[index + 5] = (byte) (value >>> 16);
        memory[index + 6] = (byte) (value >>> 8);
        memory[index + 7] = (byte) value;
    }

    static void setLongLE(byte[] memory, int index, long value) {
        memory[index]     = (byte) value;
        memory[index + 1] = (byte) (value >>> 8);
        memory[index + 2] = (byte) (value >>> 16);
        memory[index + 3] = (byte) (value >>> 24);
        memory[index + 4] = (byte) (value >>> 32);
        memory[index + 5] = (byte) (value >>> 40);
        memory[index + 6] = (byte) (value >>> 48);
        memory[index + 7] = (byte) (value >>> 56);
    }

    private HeapByteBufUtil() { }

    public static void main(String[] args) {
        byte[] bytes=new byte[]{1,2,3,4,5};
        short shortLE = getShortLE(bytes, 2);
        System.out.println(shortLE);

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
        System.out.println(2&5);
        System.out.println(2|5);


    }
}
