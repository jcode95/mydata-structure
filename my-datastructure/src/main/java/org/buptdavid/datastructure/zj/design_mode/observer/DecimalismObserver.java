package org.buptdavid.datastructure.zj.design_mode.observer;

/**
 * @author jiezhou
 * @CalssName: DecimalismObserver
 * @Package org.buptdavid.datastructure.zj.design_mode.observer
 * @Description: 十进制
 * @date 2020/4/21/18:48
 */
public class DecimalismObserver extends Observer{
    DecimalismObserver(Subject subject){
        super.subject=subject;
        super.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("我是十进制， state："+super.subject.getState());
    }
}
