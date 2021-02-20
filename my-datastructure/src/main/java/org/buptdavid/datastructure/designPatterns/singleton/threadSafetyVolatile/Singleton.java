package org.buptdavid.datastructure.designPatterns.singleton.threadSafetyVolatile;

/**
 * 高效的线程安全的单例模式实现类
 * @author weijielu
 *
 */
public class Singleton {
    private static volatile Singleton instance;
    
    private Singleton(){}
    
    public static Singleton getInstance(){
        /*双层检查不是绝对的安全，因为还有指令重排，所以必须加上volatile关键字禁止指令重排*/
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        
        return instance;
    }

}
