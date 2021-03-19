package org.buptdavid.datastructure.zj.thread.jvm;

/**
 * @author jiezhou
 * @CalssName: HelloJVM
 * @Package org.buptdavid.datastructure.zj.thread.jvm
 * @Description: jvm测试
 * @date 2021/2/28/12:24
 */
public class HelloJVM {
    /*
    * -XX:+PrintGCDetails -XX:SurvivorRatio=8 -Xms10m -Xmx10m
    *
    * */
    public Object instance = null;
//    private static final int _1MB = 1024 * 1024;
//    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        test1();
    }


    /**
     * eg:如何查看正在运行的java程序的jvm的参数值？
     * <p>
     * jps -l
     * ======================
     * 4832 sun.tools.jps.Jps
     * 9712 org.buptdavid.datastructure.zj.thread.jvm.HelloJVM
     * 10852 org.buptdavid.datastructure.zj.thread.DeadLock
     * <p>
     * jinfo 进程号
     * ===============================
     * Attaching to process ID 9712, please wait...
     * Debugger attached successfully.
     * Server compiler detected.
     * JVM version is 25.101-b13
     * Java System Properties:
     * <p>
     * java.runtime.name = Java(TM) SE Runtime Environment
     * java.vm.version = 25.101-b13
     * sun.boot.library.path = C:\Program Files\Java\jdk1.8.0_101\jre\bin
     * java.vendor.url = http://java.oracle.com/
     * java.vm.vendor = Oracle Corporation
     * path.separator = ;
     * file.encoding.pkg = sun.io
     * java.vm.name = Java HotSpot(TM) 64-Bit Server VM
     * sun.os.patch.level = Service Pack 1
     * sun.java.launcher = SUN_STANDARD
     * user.script =
     * user.country = CN
     * user.dir = F:\data_structure_java\datastructure-master\my-datastructure
     * java.vm.specification.name = Java Virtual Machine Specification
     * java.runtime.version = 1.8.0_101-b13
     * java.awt.graphicsenv = sun.awt.Win32GraphicsEnvironment
     * os.arch = amd64
     * java.endorsed.dirs = C:\Program Files\Java\jdk1.8.0_101\jre\lib\endorsed
     * line.separator =
     * <p>
     * java.io.tmpdir = C:\Users\zhoujie\AppData\Local\Temp\
     * java.vm.specification.vendor = Oracle Corporation
     * user.variant =
     * os.name = Windows 7
     * sun.jnu.encoding = GBK
     * java.library.path = C:\Program Files\Java\jdk1.8.0_101\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\S
     * ystem32\WindowsPowerShell\v1.0\;C:\Program Files\IDM Computer Solutions\UltraEdit;C:\Program Files\Java\jdk1.8.0_101\bin;D:\apache-maven-3.6.1-bin\apache-maven-3.6.1\bin;E:\projects\
     * MMOFile;D:\mysql-5.6.45-winx64\mysql-5.6.45-winx64\bin;F:\BaiduNetdiskDownload\netty-book-source\book\src\com\student\webscoket\server\protobuf;D:\nodejs;C:\Program Files\Java\java11
     * \bin;C:\Users\zhoujie\AppData\Local\BypassRuntm;D:\VS_Code\bin;C:\Users\zhoujie\AppData\Roaming\npm;.
     * java.specification.name = Java Platform API Specification
     * java.class.version = 52.0
     * sun.management.compiler = HotSpot 64-Bit Tiered Compilers
     * os.version = 6.1
     * user.home = C:\Users\zhoujie
     * user.timezone =
     * java.awt.printerjob = sun.awt.windows.WPrinterJob
     * file.encoding = UTF-8
     * java.specification.version = 1.8
     * user.name = zhoujie
     * java.class.path = C:\Program Files\Java\jdk1.8.0_101\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\access-
     * bridge-64.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\jacc
     * ess.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\nashorn.
     * jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunmsca
     * pi.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\javaws.jar;C:\
     * Program Files\Java\jdk1.8.0_101\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.
     * 0_101\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_101\jre\li
     * b\resources.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\rt.jar;F:\data_structure_java\datastructure-master\my-datastructure\target\classes;D:\maven-file\repository\com\google\guav
     * a\guava\19.0\guava-19.0.jar;D:\maven-file\repository\com\google\protobuf\protobuf-java\3.5.1\protobuf-java-3.5.1.jar;D:\maven-file\repository\junit\junit\4.11\junit-4.11.jar;D:\maven
     * -file\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\maven-file\repository\io\netty\netty-all\5.0.0.Alpha2\netty-all-5.0.0.Alpha2.jar;D:\maven-file\repository\org
     * \apache\pdfbox\pdfbox\2.0.4\pdfbox-2.0.4.jar;D:\maven-file\repository\com\alibaba\fastjson\1.2.24\fastjson-1.2.24.jar;D:\maven-file\repository\com\alibaba\dubbo\2.6.0\dubbo-2.6.0.jar
     * ;D:\maven-file\repository\org\springframework\spring-context\4.3.10.RELEASE\spring-context-4.3.10.RELEASE.jar;D:\maven-file\repository\org\springframework\spring-aop\4.3.10.RELEASE\s
     * pring-aop-4.3.10.RELEASE.jar;D:\maven-file\repository\org\springframework\spring-expression\4.3.10.RELEASE\spring-expression-4.3.10.RELEASE.jar;D:\maven-file\repository\org\springfra
     * mework\spring-beans\4.3.10.RELEASE\spring-beans-4.3.10.RELEASE.jar;D:\maven-file\repository\org\springframework\spring-web\4.3.10.RELEASE\spring-web-4.3.10.RELEASE.jar;D:\maven-file\
     * repository\org\javassist\javassist\3.20.0-GA\javassist-3.20.0-GA.jar;D:\maven-file\repository\org\jboss\netty\netty\3.2.5.Final\netty-3.2.5.Final.jar;D:\maven-file\repository\commons
     * -logging\commons-logging\1.2\commons-logging-1.2.jar;D:\maven-file\repository\org\apache\pdfbox\fontbox\2.0.11\fontbox-2.0.11.jar;D:\maven-file\repository\com\google\code\gson\gson\2
     * .2.4\gson-2.2.4.jar;D:\maven-file\repository\org\springframework\spring-core\5.1.9.RELEASE\spring-core-5.1.9.RELEASE.jar;D:\maven-file\repository\org\springframework\spring-jcl\5.1.9
     * .RELEASE\spring-jcl-5.1.9.RELEASE.jar;D:\maven-file\repository\org\springframework\spring-jdbc\5.0.5.RELEASE\spring-jdbc-5.0.5.RELEASE.jar;D:\maven-file\repository\org\springframewor
     * k\spring-tx\5.0.5.RELEASE\spring-tx-5.0.5.RELEASE.jar;D:\maven-file\repository\com\typesafe\akka\akka-actor_2.12\2.5.2\akka-actor_2.12-2.5.2.jar;D:\maven-file\repository\org\scala-la
     * ng\scala-library\2.12.2\scala-library-2.12.2.jar;D:\maven-file\repository\com\typesafe\config\1.3.1\config-1.3.1.jar;D:\maven-file\repository\org\scala-lang\modules\scala-java8-compa
     * t_2.12\0.8.0\scala-java8-compat_2.12-0.8.0.jar;D:\maven-file\repository\com\squareup\okhttp3\okhttp\3.11.0\okhttp-3.11.0.jar;D:\maven-file\repository\com\squareup\okio\okio\1.14.0\ok
     * io-1.14.0.jar;D:\maven-file\repository\org\apache\velocity\velocity\1.7\velocity-1.7.jar;D:\maven-file\repository\commons-collections\commons-collections\3.2.1\commons-collections-3.
     * 2.1.jar;D:\maven-file\repository\commons-lang\commons-lang\2.4\commons-lang-2.4.jar;D:\maven-file\repository\org\codehaus\groovy\groovy-all\2.4.7\groovy-all-2.4.7.jar;D:\maven-file\r
     * epository\cn\hutool\hutool-all\4.5.7\hutool-all-4.5.7.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2017.2.5\lib\idea_rt.jar
     * java.vm.specification.version = 1.8
     * sun.arch.data.model = 64
     * sun.java.command = org.buptdavid.datastructure.zj.thread.jvm.HelloJVM
     * java.home = C:\Program Files\Java\jdk1.8.0_101\jre
     * user.language = zh
     * java.specification.vendor = Oracle Corporation
     * awt.toolkit = sun.awt.windows.WToolkit
     * java.vm.info = mixed mode
     * java.version = 1.8.0_101
     * java.ext.dirs = C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext;C:\Windows\Sun\Java\lib\ext
     * sun.boot.class.path = C:\Program Files\Java\jdk1.8.0_101\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\sunrsasign
     * .jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_101\jre\lib\charsets.jar;C:\Program Files\J
     * ava\jdk1.8.0_101\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_101\jre\classes
     * java.vendor = Oracle Corporation
     * file.separator = \
     * java.vendor.url.bug = http://bugreport.sun.com/bugreport/
     * sun.io.unicode.encoding = UnicodeLittle
     * sun.cpu.endian = little
     * sun.desktop = windows
     * sun.cpu.isalist = amd64
     * VM Flags:
     * Non-default VM flags: -XX:CICompilerCount=3 -XX:InitialHeapSize=134217728 -XX:MaxHeapSize=2147483648 -XX:MaxNewSize=715653120 -XX:MinHeapDeltaBytes=524288 -XX:NewSize=44564480 -XX:Ol
     * dSize=89653248 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseFastUnorderedTimeStamps -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
     * Command line:  -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2017.2.5\lib\idea_rt.jar=53330:C:\Program Files\JetBrains\IntelliJ IDEA 2017.2.5\bin -Dfile.encoding=UTF-8
     * <p>
     * <p>
     * eg:如何查看正在运行的java程序的某一个jvm的参数值？
     * jinfo -flag 参数名 进程号
     * <p>
     * 如：
     * F:\data_structure_java\datastructure-master\my-datastructure>jinfo -flag PrintGCDetails 9712
     * -XX:-PrintGCDetails   （-XX 代表boolean类型，-PrintGCDetails 的 - 号代表没有添加，也就是false，+号就是添加，也就是true）
     */


    public static void test1() {
         /*1、直接赋值*/
//        String str = "abc";//直接赋值，这种方式创建的字符串对象，只会在常量池中。因为有"abc"这个字面量，创建对象str的时候,JVM会先去常量池中通过 equals(key) 方法，判断是否有相同的对象 。如果有则直接返回该对象在常量池中的引用；如果没有则会在常量池中创建一个新对象，再返回引用。
    /*2、New 一个对象*/
//        String str1 = new String("abc");//这种方式会保证字符串常量池和堆中都有这个对象.首先先去常量池中找是否有"abc"这个字符串， 没有就创建，最后返回堆内存中的对象引用。因为有"abc"这个字面量，所以会先检查字符串常量池中是否存在字符串"abc" 。如果不存在，先在字符串常量池里创建一个字符串对象；再去内存中创建一个字符串对象"abc"；存在的话，就直接去堆内存中创建一个字符串对象"abc"；最后，将内存中的引用返回
    /*3、 intern方法*/
//        String s1 = new String("abc"); String s2 = s1.intern();//String中的intern方法是一个 native 的方法，当调用 intern方法时，如果常量池已经包含一个等于此String对象的字符串，则返回池中的字符串。否则，将intern返回的引用指向当前字符串 s1(jdk1.6版本需要将 s1 复制到字符串常量池里)


//        String str = "abc";
//        String str1 = "abc";
//        System.out.println(str == str1);
//        System.out.println(str == str.intern());
        String str2 = new String("abc");
        String str3 = "abc";
        System.out.println(str3 == str2);
    }
}
