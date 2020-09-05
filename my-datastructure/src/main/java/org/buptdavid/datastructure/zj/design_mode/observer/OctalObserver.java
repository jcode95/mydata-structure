package org.buptdavid.datastructure.zj.design_mode.observer;

/**
 * @author jiezhou
 * @CalssName: OctalObserver
 * @Package org.buptdavid.datastructure.zj.design_mode.observer
 * @Description:
 * @date 2020/4/21/18:24
 */
public class OctalObserver extends Observer{
    public OctalObserver(Subject subject){
        super.subject = subject;
        super.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
