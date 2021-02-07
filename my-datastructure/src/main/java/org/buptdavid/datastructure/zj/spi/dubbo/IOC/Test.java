//package org.buptdavid.datastructure.zj.spi.dubbo.IOC;
//
//import org.apache.dubbo.common.URL;
//import org.apache.dubbo.common.extension.ExtensionLoader;
//
//import java.sql.Driver;
//import java.util.HashMap;
//
///**
// * @author jiezhou
// * @CalssName: Test
// * @Package cor.my.spi.dubbo.IOC
// * @Description:
// * @date 2020/7/16/11:49
// */
//public class Test {
//
//    public static void main(String[] args) {
//
//        ExtensionLoader<Driver> extensionLoader = ExtensionLoader.getExtensionLoader(Driver.class);
//        Driver driverImpl = extensionLoader.getExtension("driverImpl");
//
//        HashMap<String, String> map = new HashMap<>();
//        map.put("type","red");
//        URL url = new URL("","",0,map);
//        driverImpl.driverSPIDubboIOC(url);
//
//
//    }
//}
