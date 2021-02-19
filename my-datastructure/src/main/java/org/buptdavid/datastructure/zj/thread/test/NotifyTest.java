package org.buptdavid.datastructure.zj.thread.test;

/**
 * @author jiezhou
 * @CalssName: NotifyTest
 * @Package book.test
 * @Description: 查看notify或者notifyAll方法在字节码中的是否纯在mon
 * @date 2020/7/4/10:48
 */
public  class NotifyTest {

    public static void main(String[] args) {
       /* try {
            NotifyTest notifyTest = new NotifyTest();
            notifyTest.wait();
            notifyTest.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        String s2 = new StringBuilder("ja").append("va").toString();
        String intern = s2.intern();//intern 方法会从字符串常量池中查询当前字符串是否存在，若不存在就会将当前字符串放入常量池中
        System.out.println(intern==s2);
        String s1 = new StringBuilder("go").append("oid").toString();
        String intern1 = s1.intern();
        System.out.println(intern1==s1);
       /* String s1 = "ab123" ;
        String s2 = new String( "ab123" ) ;
        System.out.println( s1 == s2 );
        String s3 = s2.intern() ;
        System.out.println( s1 == s3 ) ;*/

    }
    public synchronized void  aa() throws InterruptedException {
        NotifyTest notifyTest = new NotifyTest();
        notifyTest.wait();
        notifyTest.notify();
    }

}
