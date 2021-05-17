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
}
