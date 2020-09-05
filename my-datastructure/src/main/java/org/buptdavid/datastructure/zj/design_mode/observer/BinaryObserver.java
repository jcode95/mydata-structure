package org.buptdavid.datastructure.zj.design_mode.observer;

/**
 * @author jiezhou
 * @CalssName: BinaryObserver
 * @Package org.buptdavid.datastructure.zj.design_mode.observer
 * @Description: 创建实体观察者类。
 * @date 2020/4/21/18:22
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }
}
