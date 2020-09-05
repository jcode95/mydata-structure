package org.buptdavid.datastructure.zj.design_mode.observer;

/**
 * @author jiezhou
 * @CalssName: Observer
 * @Package org.buptdavid.datastructure.zj.design_mode.observer
 * @Description: 创建 Observer 类 Observer类是抽象观察者，为所有的具体观察者定义一个接口，在得到主题的通知时更新自己。
 * @date 2020/4/21/18:21
 */
public abstract class Observer {
    protected Subject subject;
    //更新
    public abstract void update();
}
