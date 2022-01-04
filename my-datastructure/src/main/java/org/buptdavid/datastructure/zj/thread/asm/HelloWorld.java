package org.buptdavid.datastructure.zj.thread.asm;

/**
 * @author jiezhou
 * @CalssName: HelloWorld
 * @Package org.buptdavid.datastructure.zj.thread.asm
 * @Description:ASM字节码插桩详解
 * @date 2021/12/30/15:16
 */
public class HelloWorld {

    public void sayHello() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
