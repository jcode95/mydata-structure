package org.buptdavid.datastructure.zj.akka.demo1;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class HelloActor extends UntypedAbstractActor{
    ActorRef greeterRef;
    @Override
    public void preStart() throws Exception { //是Akka的回调方法，在Actor启动前会被Akka调用，完成一些初始化操作
        greeterRef = getContext().actorOf(Props.create(Greeter.class), "greeter");
        System.out.println("Greeter Actor Path :"+greeterRef.path());
        greeterRef.tell(Greeter.Msg.GREET,getSelf());
    }
    @Override
    public void onReceive(Object msg) throws Throwable {//消息处理函数
        if(msg==Greeter.Msg.DONE){
            greeterRef.tell(Greeter.Msg.GREET,getSelf());
            getContext().stop(getSelf());//让自己停止
        }else{
            unhandled(msg);
        }
    }
}
