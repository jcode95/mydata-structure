package org.buptdavid.datastructure.zj.akka.demo2;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class WacthActor extends UntypedAbstractActor{
   private final LoggingAdapter log= Logging.getLogger(getContext().system(),this);


    public WacthActor(ActorRef ref) {
        getContext().watch(ref);
    }

    public void onReceive(Object msg) throws Throwable {
        if(msg instanceof Terminated){
            System.out.println(String.format("%s has terminarted,shutting down system",((Terminated) msg).getActor().path()));
        }else {
            unhandled(msg);
        }
    }
}
