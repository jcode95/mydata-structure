//package org.buptdavid.datastructure.zj.spi.dubbo.IOC;
//
//
//import java.sql.Driver;
//
///**
// * @author jiezhou
// * @CalssName: DriverImpl
// * @Package cor.my.spi.dubbo.IOC
// * @Description:
// * @date 2020/7/16/11:57
// */
//public class DriverImpl implements Driver {
//
//    private SPIDubboIOC spiDubboIOC;
//
//    /**
//     * Dubbo使用的是set方法进行依赖注入，如果不提供set方法就会报null指针
//     *
//     * @param spiDubboIOC
//     */
//    public void setSpiDubboIOC(SPIDubboIOC spiDubboIOC) {
//        this.spiDubboIOC = spiDubboIOC;
//    }
//
//    @Override
//    public void driverSPIDubboIOC(URL url) {
//        spiDubboIOC.process(url);
//    }
//}
