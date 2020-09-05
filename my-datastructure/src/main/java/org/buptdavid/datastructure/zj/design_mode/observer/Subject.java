package org.buptdavid.datastructure.zj.design_mode.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * @author jiezhou
 * @CalssName: Subject
 * @Package org.buptdavid.datastructure.zj.design_mode.observer
 * @Description: 创建 Subject 类。Subject类是主题，它把所有对观察者对象的引用文件存在了一个聚集里，
 * 每个主题都可以有任何数量的观察者
 * @date 2020/4/21/18:19
 */
public class Subject {

    private List<Observer> observers= new ArrayList<Observer>();
    private int state;
    public int getState() {
        return state;
    }
    //设置状态（改变）
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    //添加
    public void attach(Observer observer){
        observers.add(observer);
    }
    //通知
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
