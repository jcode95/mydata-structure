package org.buptdavid.datastructure.zj.spi.javaspi.impl;


import org.buptdavid.datastructure.zj.spi.javaspi.MySPIJavaInterface;

/**
 * @author jiezhou
 * @CalssName: MySPIInterfaceBlueImpl
 * @Package cor.my.spi.impl
 * @Description:
 * @date 2020/7/16/10:39
 */
public abstract class MySPIInterfaceBlueImpl implements MySPIJavaInterface {
    int rid;
    @Override
    public void read() {

    }

    @Override
    public void blue() {
        System.out.println("blue....");
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
