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
        String s2 = new StringBuilder("ja").append("va").toString();
//        String s2 = new String("java");
        String intern = s2.intern();//intern 方法会从字符串常量池中查询当前字符串是否存在，若不存在就会将当前字符串放入常量池中
        System.out.println(intern == s2);
        String s1 = new StringBuilder("go").append("od").toString();//只在堆里面存在字符串，常量池没有
//        String s11 = new String("good");//堆，常量池都有
//        String s12 = "good";
        String intern1 = s1.intern();//当调用该方法时，发现常量池没有good，所以在常量池里面放置一个字符串为“good”的字面量，并且返回堆的引用
        System.out.println(intern1 == s1);
       /* String s1 = "ab123" ;
        String s2 = new String( "ab123" ) ;
        System.out.println( s1 == s2 );
        String s3 = s2.intern() ;
        System.out.println( s1 == s3 ) ;*/
        String s5 = new String("Hello"); //先在常量池中创建，再在堆中创建，返回的数值s5是堆中的地址
        String s6 = s5.intern();         //返回的数值s6 ，能在常量池中查询到字符串就返回常量池中之前的地址，查询不到就找堆里面的返回堆里面的地址并把堆里面的字符串存入到常量池

        System.out.println(s5 == s6);  //输出false




    /*总结：
    * 简单点，也就是当调用intern方法时，找到就返回false，找不到就true
    *
    *
    * 找到就返回常量池的地址，找不到就返回堆的地址，并且吧字符串放入常量池
    * */
        /*测试  找到就返回常量池的地址，找不到就返回堆的地址，并且吧字符串放入常量池*/

        String s7 = new StringBuilder("zhou").append("jie").toString();//s7 是堆地址,常量池里面没有
        String s8=s7.intern();//调用之前常量池里面没有，调用之后把s7的字符串放入常量池里面，此时常量池里面有了，这里的s8是堆地址
        String s9 = s8.intern();//s9 这里就是常量池的地址
        System.out.println(" s8==s7 : " + (s8==s7));
        System.out.println(" s8==s9 : " + (s8==s9));
        System.out.println(" s7==s9 : " + (s7==s9));
        System.out.println("(s9==\"zhoujie\") = " + (s9 == "zhoujie"));


    }

    public synchronized void aa() throws InterruptedException {
        NotifyTest notifyTest = new NotifyTest();
        notifyTest.wait();
        notifyTest.notify();
    }

}
