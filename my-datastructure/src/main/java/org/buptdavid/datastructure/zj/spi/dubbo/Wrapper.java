//package org.buptdavid.datastructure.zj.spi.dubbo;
//
///**
// * @author jiezhou
// * @CalssName: Wrapper
// * @Package cor.my.spi.dubbo
// * @Description: 包装类（dubbo的aop）
// * @date 2020/7/16/11:19
// * 需要吧包装类也提交到文件当中 文件名： cor.my.spi.dubbo.MySPIDubboInterface
// */
//public class Wrapper implements MySPIDubboInterface{
//    private MySPIDubboInterface mySPIDubboInterface;
//
//    public Wrapper(MySPIDubboInterface mySPIDubboInterface){
//        this.mySPIDubboInterface=mySPIDubboInterface;
//    }
//
//    @Override
//    public void read() {
//        System.out.println("  read   before....");
//        mySPIDubboInterface.read();
//        System.out.println("  read   after....");
//    }
//
//    @Override
//    public void blue() {
//        System.out.println("  blue   before....");
//        mySPIDubboInterface.blue();
//        System.out.println("  blue   after....");
//    }
//}
