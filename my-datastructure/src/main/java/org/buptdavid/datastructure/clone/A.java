package org.buptdavid.datastructure.clone;

import java.io.Serializable;

/**
 * @author jiezhou
 * @CalssName: A
 * @Package org.buptdavid.datastructure.clone
 * @Description:
 * @date 2020/6/23/17:11
 */
public class A implements Cloneable,Serializable{

    private String ss;

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
