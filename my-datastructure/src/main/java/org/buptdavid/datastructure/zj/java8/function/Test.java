package org.buptdavid.datastructure.zj.java8.function;

/**
 * @author jiezhou
 * @CalssName: Test
 * @Package org.buptdavid.datastructure.zj.java8.function
 * @Description:
 * @date 2021/11/24/14:06
 */
public class Test {


    public static void main(String[] args) {

        VUtils.isTrue(true).throwMessage("我要抛出异常了！！！");
        VUtils.isTrueOrFalseHandle(true);

    }

}
