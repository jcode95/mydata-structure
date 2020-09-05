package org.buptdavid.datastructure.zj.akka.demo3;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

import java.util.Random;

public class DeadMain {

    public static void customStrategy(ActorSystem system){
        ActorRef a = system.actorOf(Props.create(Supervisor.class), "Supervisor");
        a.tell(Props.create(RestartActor.class),ActorRef.noSender());
        ActorSelection selection = system.actorSelection("akka://deadwatch/user/Supervisor/restartActor");
        for (int i = 0; i < 1000; i++) {
            int i1 = new Random().nextInt(1000);
//            if(i1%2==0){
                selection.tell(RestartActor.Msg.RESTART,ActorRef.noSender());
//            }else{
//                selection.tell(RestartActor.Msg.DONE,ActorRef.noSender());
//            }

        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("deadwatch", ConfigFactory.load("samplehello.conf"));
        customStrategy(system);
    }
}
