package org.buptdavid.datastructure.zj.akka.demo2;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;


/**
 * 异步通信
 Actor 是被动的和消息驱动的。Actor 在收到消息前什么都不做。Actor 使用异步消息进行通信。
 这样可以确保发送者不会一直等待接收者处理他们的消息。相反，发件人将邮件放在收件人的邮箱之后，
 就可以自由地进行其他工作。Actor 的邮箱本质上是一个具有排序语义的消息队列。
 从同一个 Actor 发送的多条消息的顺序被保留，但可以与另一个 Actor 发送的消息交错。
 你可能想知道 Actor 在不处理消息的时候在做什么，比如，做什么实际的工作？实际上，
 它处于挂起状态，在这种状态下，它不消耗除内存之外的任何资源。同样，这也展示了 Actor 的轻量级和高效性。
 */
public class DeadMain {
    public static void main(String[] args) {
        /**
         *akka.actor.ActorSystem工厂在某种程度上类似于 Spring 的 BeanFactory，它是运行 Actor 的容器并管理他们的生命周期。
         */
        ActorSystem deadwatch = ActorSystem.create("deadwatch", ConfigFactory.load("samplehello.conf"));
        /**
         * actorOf工厂方法创建 Actor 并接受两个参数，一个名为props的配置对象和一个String类型的 Actor 名称。
         */
        ActorRef worker = deadwatch.actorOf(Props.create(MyWorker.class), "worker");
        deadwatch.actorOf(Props.create(WacthActor.class,worker),"watcher");//为MyWorker actor指定一个监视者  监视者就如同一个劳动监工，
        //一旦MyWorker出问题或者停止，监视者就会收到一个通知 onReceive()这个方法里面。
        /**
         * 要将消息放入 Actor 的邮箱，我们需要使用ActorRef的tell方法。
         */
        worker.tell(MyWorker.Msg.WORKING,ActorRef.noSender());
        worker.tell(MyWorker.Msg.DONE,ActorRef.noSender());
        worker.tell(MyWorker.Msg.CLOSE,ActorRef.noSender());
        worker.tell(PoisonPill.getInstance(),ActorRef.noSender());//停止Actor使用PoisonPill
    }
}
