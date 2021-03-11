package org.buptdavid.datastructure.zj.design_mode.observer;

/**
 * @author jiezhou
 * @CalssName: ObserverPatternTest
 * @Package org.buptdavid.datastructure.zj.design_mode.observer
 * @Description: 测试（客户端Client）
 * @date 2020/4/21/18:26
 */
public class ObserverPatternTest {
    public static void main(String[] args) {
        Subject subject = new Subject();//创建主题

        new HexaObserver(subject);//创建一个具体的观察者
        new OctalObserver(subject);//创建一个具体的观察者
        new BinaryObserver(subject);//创建一个具体的观察者
        new DecimalismObserver(subject);//创建一个具体的观察者
        System.out.println("******************First state change: 15*****************");
        subject.setState(15);//设置状态并且通知给其他
        System.out.println("******************Second state change: 10****************");
        subject.setState(10);
    }
}
