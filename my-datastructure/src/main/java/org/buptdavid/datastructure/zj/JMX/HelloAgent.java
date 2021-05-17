package org.buptdavid.datastructure.zj.JMX;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @author jiezhou
 * @CalssName: HelloAgent
 * @Package org.buptdavid.datastructure.zj.JMX
 * @Description: 定义agent层：
 * @date 2021/5/17/15:01
 */
public class HelloAgent {
    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("jmxBean:name=hello");
        mBeanServer.registerMBean(new Hello(),name);
//        Thread.sleep(60*60*1000);


        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adaptorServer = new HtmlAdaptorServer();
        mBeanServer.registerMBean(adaptorServer,adapterName);
        adaptorServer.start();
    }




    /*
    * 1、linux下利用JMX监控Tomcat
　　利用JMX监控Tomcat，就是相当于部署在tomcat上的应用作为服务端，也就是被管理资源的对象。然后通过程序或者jconsole远程连接到该应用上来。远程连接需要服务器端提供ip和port。如果需要加密访问的话，还需要配置用户名、密码等参数。
    CATALINA_ OPTS="*$CATALINA_ OPTS -Dcom.sun.management.jmxremote -Dava.misever.hostname=192.168.1.2 -Dcom.sun.management.jmxremote. port=8888 -Dcom.sun.management.jmxremote ssl=false -Dcom.sun.management.jmxremote.authenticate=false"

    主要是在tomcat下的文件catalina.sh中进行一些环境变量的配置配置：
    -Dcom.sun.management.jmxremote=true                 相关 JMX 代理侦听开关

    -Djava.rmi.server.hostname                                     服务器端的IP
    -Dcom.sun.management.jmxremote.port=29094             相关 JMX 代理侦听请求的端口

    -Dcom.sun.management.jmxremote.ssl=false              指定是否使用 SSL 通讯

    -Dcom.sun.management.jmxremote.authenticate=false     指定是否需要密码验证

    这样就可以通过客户端或者jconsole对tomcat进行监控。
    *
    *
    * */
}
