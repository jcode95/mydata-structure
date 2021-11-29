package org.buptdavid.datastructure.zj.java8.function;

/**
 * @author jiezhou
 * @CalssName: VUtils
 * @Package org.buptdavid.datastructure.zj.java8.function
 * @Description:
 * @date 2021/11/24/14:04
 */
public class VUtils {

    public static ThrowExceptionFunction isTrue(boolean flg) {
        return (message -> {
            if (flg) {
                throw new RuntimeException(message);
            }
        });
    }


    public static BranchHandle isTrueOrFalseHandle(boolean b){
        return (trueHandle,falseHandle)->{
            if (b){
                trueHandle.run();
            }else {
                falseHandle.run();
            }
        };
    }
}
