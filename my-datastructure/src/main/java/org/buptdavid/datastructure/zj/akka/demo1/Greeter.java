package org.buptdavid.datastructure.zj.akka.demo1;

import akka.actor.UntypedAbstractActor;
import org.buptdavid.datastructure.zj.Demo2;

/**
 * 欢迎者
 */
public class Greeter extends UntypedAbstractActor{

    public enum Msg{
        GREET,DONE
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if(message==Msg.GREET){
            System.out.println("wo shi  Greeter 收到的 hello actor...");
            getSender().tell(Msg.DONE,getSelf());
        }else {
            unhandled(message);
        }

    }
}
