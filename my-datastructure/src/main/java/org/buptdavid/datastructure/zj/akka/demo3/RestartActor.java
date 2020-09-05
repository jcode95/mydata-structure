package org.buptdavid.datastructure.zj.akka.demo3;

import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.Optional;


public class RestartActor extends UntypedAbstractActor{
    private LoggingAdapter log= Logging.getLogger(getContext().system(),this);
    public enum Msg{
        DONE,RESTART
    }

    @Override
    public void preStart() throws Exception {
//        System.out.println("preStart hashCode :"+this.hashCode());
        log.info("preStart hashCode :"+this.hashCode());
    }

    @Override
    public void postStop() throws Exception {
//        System.out.println("postStop  hashCode :"+this.hashCode());
        log.info("postStop  hashCode :"+this.hashCode());
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        super.postRestart(reason);
//        System.out.println("postRestart  hashCode :"+this.hashCode());
        log.info("postRestart  hashCode :"+this.hashCode());
    }

    @Override
    public void preRestart(Throwable reason, Optional message) throws Exception {
//        System.out.println("preRestart  hashCode :"+this.hashCode());
        log.info("preRestart  hashCode :"+this.hashCode());
    }

    public void onReceive(Object message) throws Throwable {
//        System.out.println("postRestart  hashCode :"+this.hashCode());
        log.info("postRestart  hashCode :"+this.hashCode());
        if(message ==Msg.DONE){
            getContext().stop(getSelf());
        }else if(message ==Msg.RESTART){
            throw new NumberFormatException("NumberFormatException 执行了。 。。。。。。。。。。。。");
        }
        unhandled(message);
    }
}
