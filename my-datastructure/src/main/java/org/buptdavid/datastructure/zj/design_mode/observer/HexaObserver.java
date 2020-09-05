package org.buptdavid.datastructure.zj.design_mode.observer;

/**
 * @author jiezhou
 * @CalssName: HexaObserver
 * @Package org.buptdavid.datastructure.zj.design_mode.observer
 * @Description:
 * @date 2020/4/21/18:25
 */
public class HexaObserver extends Observer{
    public HexaObserver(Subject subject){
        super.subject = subject;
        super.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
