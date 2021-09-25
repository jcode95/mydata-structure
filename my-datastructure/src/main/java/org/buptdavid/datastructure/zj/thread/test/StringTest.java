package org.buptdavid.datastructure.zj.thread.test;

/**
 * @author jiezhou
 * @CalssName: StringTest
 * @Package org.buptdavid.datastructure.zj.thread.test
 * @Description:
 * @date 2021/9/25/11:01
 */
public class StringTest {

    public static void main(String[] args) {
        StringBuffer stringBuilder = new StringBuffer();
        stringBuilder.append(1);

        String string = stringBuilder.toString();

        String s="";
        s=s+"sc";



    }

    /*
    * F:\software\Java8\jdk1.8.0_281\bin\javap.exe -c org.buptdavid.datastructure.zj.thread.test.StringTest
Compiled from "StringTest.java"
public class org.buptdavid.datastructure.zj.thread.test.StringTest {
  public org.buptdavid.datastructure.zj.thread.test.StringTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class java/lang/StringBuffer
       3: dup
       4: invokespecial #3                  // Method java/lang/StringBuffer."<init>":()V
       7: astore_1
       8: aload_1
       9: iconst_1
      10: invokevirtual #4                  // Method java/lang/StringBuffer.append:(I)Ljava/lang/StringBuffer;
      13: pop
      14: aload_1
      15: invokevirtual #5                  // Method java/lang/StringBuffer.toString:()Ljava/lang/String;
      18: astore_2
      19: ldc           #6                  // String
      21: astore_3
      22: new           #7                  // class java/lang/StringBuilder
      25: dup
      26: invokespecial #8                  // Method java/lang/StringBuilder."<init>":()V
      29: aload_3
      30: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      33: ldc           #10                 // String sc
      35: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      38: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      41: astore_3
      42: return
}

        Process finished with exit code 0

        String  +   底层使用的是StringBuilder .append()方法

    *
    * */
}
