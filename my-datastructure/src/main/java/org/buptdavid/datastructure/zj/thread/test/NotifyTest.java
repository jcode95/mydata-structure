package org.buptdavid.datastructure.zj.thread.test;

/**
 * @author jiezhou
 * @CalssName: NotifyTest
 * @Package book.test
 * @Description: 查看notify或者notifyAll方法在字节码中的是否纯在mon
 * @date 2020/7/4/10:48
 */
public class NotifyTest {

    public static void main(String[] args) {
       /* try {
            NotifyTest notifyTest = new NotifyTest();
            notifyTest.wait();
            notifyTest.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
//        String s2 = new StringBuilder("ja").append("va").toString();
        String s2 = new String("java");
        String intern = s2.intern();//intern 方法会从字符串常量池中查询当前字符串是否存在，若不存在就会将当前字符串放入常量池中
        System.out.println(intern == s2);
        String s1 = new StringBuilder("go").append("od").toString();//只在堆里面存在字符串，常量池没有
//        String s1 = new String("good");//堆，常量池都有
//        String s1 = "good";
        String intern1 = s1.intern();
        System.out.println(intern1 == s1);
       /* String s1 = "ab123" ;
        String s2 = new String( "ab123" ) ;
        System.out.println( s1 == s2 );
        String s3 = s2.intern() ;
        System.out.println( s1 == s3 ) ;*/
        String s5 = new String("Hello"); //先在常量池中创建，再在堆中创建，返回的数值s5是堆中的地址
        String s6 = s5.intern();         //返回的数值s6 ，能在常量池中查询到字符串就返回常量池中的地址，查询不到就找堆里面的返回堆里面的地址并把对面的字符串存入到常量池

        System.out.println(s5 == s6);  //输出false






    }

    public synchronized void aa() throws InterruptedException {
        NotifyTest notifyTest = new NotifyTest();
        notifyTest.wait();
        notifyTest.notify();
    }

}
