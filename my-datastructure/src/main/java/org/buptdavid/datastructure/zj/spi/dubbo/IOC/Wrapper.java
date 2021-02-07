//package org.buptdavid.datastructure.zj.spi.dubbo.IOC;
//
//import org.apache.dubbo.common.URL;
//
///**
// * @author jiezhou
// * @CalssName: Wrapper
// * @Package cor.my.spi.dubbo.IOC
// * @Description:
// * @date 2020/7/16/11:47
// *
// * 包装类，一定要写一个如下的构造函数，否则就不叫包装类
// */
//public class Wrapper implements SPIDubboIOC{
//    private SPIDubboIOC spiDubboIOC;
//    public Wrapper(SPIDubboIOC spiDubboIOC){
//        this.spiDubboIOC=spiDubboIOC;
//    }
//
//    @Override
//    public void process(URL url) {
//        System.out.println("before...");
//        spiDubboIOC.process(url);
//        System.out.println("after...");
//    }
//}
