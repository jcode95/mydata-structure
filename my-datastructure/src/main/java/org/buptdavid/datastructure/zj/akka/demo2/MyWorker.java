package org.buptdavid.datastructure.zj.akka.demo2;

import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyWorker extends UntypedAbstractActor{
    private final LoggingAdapter log= Logging.getLogger(getContext().system(),this);

    public  enum Msg{
        WORKING ,DONE,CLOSE
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("MyWorker is starting....");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("MyWorker is stoping....");
    }
    @Override
    public void onReceive(Object msg) throws Throwable {
        if(msg==Msg.WORKING){
//            System.out.println("I a workering ....");
            log.info("I a workering ....");
        }
        if (msg==Msg.DONE) {
//            System.out.println("Stop working ");
            log.info("Stop working ");
        }
        if(msg==Msg.CLOSE){
            log.info("I will shutdown...");
//            System.out.println("I will shutdown...");
            getSender().tell(Msg.CLOSE,getSelf());
            getContext().stop(getSelf());
        }else{
            unhandled(msg);
        }

    }
}
