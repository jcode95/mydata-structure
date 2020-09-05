package org.buptdavid.datastructure.designPatterns.singleton.staticInnerClass;

/**
 * @author jiezhou
 * @CalssName: Test
 * @Package org.buptdavid.datastructure.designPatterns.singleton
 * @Description:
 * @date 2020/5/27/16:50
 */
public class Test {

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        if(instance==instance1){
            System.out.println("=");
        }else{
            System.out.println("!=");
        }


    }
}
