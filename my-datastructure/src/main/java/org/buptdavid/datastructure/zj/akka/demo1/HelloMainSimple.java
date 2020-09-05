package org.buptdavid.datastructure.zj.akka.demo1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

public class HelloMainSimple {

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("Hello", ConfigFactory.load("samplehello.conf"));
        ActorRef helloactor = actorSystem.actorOf(Props.create(HelloActor.class), "helloactor");//创建一个接收该对象管理的actor对象
        System.out.println("helloactor Actor path  "+helloactor.path());
    }

}
