package org.buptdavid.datastructure.zj.akka.demo3;

import akka.actor.*;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * 父Actor,作为所有的子Actor的监督者
 */
public class Supervisor extends UntypedAbstractActor {

    /**
    *   定义一个OneForOneStrategy的监督策略，这个监督策略运行Actor在遇到错误之后，
     *   在一分钟内进行3次重试，如果超过这个频率，就会直接杀死Actor
    * */
    //OneForOneStrategy监督策略
    private static SupervisorStrategy strategy=new OneForOneStrategy(3,
            Duration.create(1, TimeUnit.MINUTES),
            new Function<Throwable, SupervisorStrategy.Directive>() {
                public SupervisorStrategy.Directive apply(Throwable t) throws Exception {
                    if(t instanceof ArithmeticException){
                        System.out.println("meet ArithmeticException ,just resume");
                        return SupervisorStrategy.resume();//继续，不做任何处理
                    }else if(t instanceof NumberFormatException){
                        System.out.println("meet NumberFormatException ,just restart");
                        return SupervisorStrategy.restart();//进行actor 的重启
                    }else if(t instanceof IllegalArgumentException){
                        System.out.println("meet IllegalArgumentException ,just stop");
                        return SupervisorStrategy.stop();//直接停止Actor
                    }else{
                        //没有在这个函数的出现的异常，直接向上抛出，由顶级的Actor 去处理
                        return  SupervisorStrategy.escalate();
                    }

                }
            });

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    public void onReceive(Object message) throws Throwable {
        if(message instanceof Props){
            //新建一个名为restartActor的子Actor，这个子Actor就由当前的Supervisor进行监督了
            //当Supervisor接收一个 Pops对象时，就会根据这个Props配置生成一个restartActor
            ActorRef restartActor = getContext().actorOf((Props) message, "restartActor");
            System.out.println("restartActor Actor path  :"+restartActor.path());
        }else {
            unhandled(message);
        }

    }
}
