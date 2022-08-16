package org.buptdavid.datastructure.zj.zuo_shen.位运算;

/**
 * @author root
 * @CalssName: 异或
 * @Package org.buptdavid.datastructure.zj.zuo_shen.位运算
 * @Description:异或
 * @date 2022/8/15/15:47
 */
public class Xor {
    public static void main(String[] args) {
        exchange();

    }

    /**
     * 交换值
     */
    private static void exchange() {
        /**
         * ^ 不同为1,相同为0是异或的逻辑关系
         * 甲^甲=0   ,前提是内存是两块，不能是一块 比如数组，交换i位置和j位置的值，如果i位置和i位置异或，会变成0 的  也就是地址不能相同，相同会看成 是自己跟自己异或会等于0
         */
        int a = 100;
        int b = 20;
        //交换a b的值
        a = a ^ b;//a=a^b
        b = a ^ b;//b=a^b^b  由于自己异或自己=0 任何数异或0=它自己（a^0=a） 所以 b=a;
        a = a ^ b;//a=a^b^a  异或满足交换律，所以a=a^a^b=0^b=b;

        System.out.println("b = " + b);
        System.out.println("a = " + a);
//        findQiShu();
    }

    /**
     * 1) 在一个数字序列中，有一个数出现了奇数次，其他数都出现了偶数次，找到这个奇数次的数
     * 2) 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，寻找这两个奇数次的数
     */
    public static void findQiShu() {
        //第一问
//        int[] arr = new int[]{
//                1, 2, 3, 4, 5, 1, 2, 3, 5
//        };
//        int result = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            result ^= arr[i];
//        }
//        System.out.println("result = " + result);


        //第二问
        int[] arr2 = new int[]{
                1, 2, 3, 4, 5, 1, 2, 3, 5, 4, 4, 2
        };
        int eor = arr2[0];
        for (int i = 1; i < arr2.length; i++) {
            eor ^= arr2[i];
        }
        int rightOne = eor & (~eor + 1);
        int eor2 = 0;
        for (int i : arr2) {
            if ((i & rightOne) != 0) {//这里==1 是有错误，视频里面说可以等于1是错误
                eor2 ^= i;
            }
        }
        System.out.println("b = " + eor2);
        int a = eor ^ eor2;
        System.out.println("a = " + a);

    }

}
