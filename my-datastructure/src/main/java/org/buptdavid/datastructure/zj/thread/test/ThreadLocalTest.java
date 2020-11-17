package org.buptdavid.datastructure.zj.thread.test;

/**
 * 父线程的ThreadLocal里面的值子线程获取不到演示,如果换成InheritableThreadLocal
 * 就成功子线程也能获取父线程传过来的ThreadLocal的值
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        new ParamentThread().start();
    }


    public static class ParamentThread extends Thread{
        InheritableThreadLocal<String> paramentThreadLocal=new InheritableThreadLocal();
//        ThreadLocal<String> paramentThreadLocal=new ThreadLocal();
        @Override
        public void run() {
            paramentThreadLocal.set("paramentThreadLocal");
//            super.run();
            System.out.println("I am is ParamentThread:  "+paramentThreadLocal.get());
            ChindThread chindThread=new ChindThread(paramentThreadLocal);
            new Thread(chindThread).start();
        }
    }

    public static class ChindThread implements Runnable{
        InheritableThreadLocal<String> chindThreadLocal=null;
//        ThreadLocal<String> chindThreadLocal=null;
        public ChindThread(InheritableThreadLocal<String> paramentThreadLocal){
            this.chindThreadLocal=paramentThreadLocal;
        }
        /*public ChindThread(ThreadLocal<String> paramentThreadLocal){
            this.chindThreadLocal=paramentThreadLocal;
        }*/
        @Override
        public void run() {
           if(chindThreadLocal==null){
               System.out.println("chindThreadLocal==null");
           }else{
               System.out.println("chindThreadLocal!=null:  "+chindThreadLocal.get());
           }
        }
    }
}
