package activemq;

import org.apache.activemq.ActiveMQConnection;

import javax.jms.*;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author jiezhou
 * @CalssName: ConsumerTest
 * @Package activemq
 * @Description:
 * @date 2021/4/2/18:14
 */
public class ConsumerDeliveryModeTopicTest {
    private static final String defaultURL = "tcp://" + "124.70.74.189" + ":" + "61616";
    private static final String defaultTopic_NAME = "topic001";

    public static void main(String[] args) throws URISyntaxException, JMSException, IOException {
        System.out.println("-----------ls-----------------");
        ActiveMQConnection connection = ActiveMQConnection.makeConnection(defaultURL);//创建连接
        connection.setClientID("ls");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//创建session
        Topic topic = session.createTopic(defaultTopic_NAME);//创建目的地（队列或者topic）
        TopicSubscriber subscriber = session.createDurableSubscriber(topic, "make...");//创建主题持久化订阅者
        connection.start();
        Message message = subscriber.receive();
        while (message!=null){
            TextMessage txmessage=(TextMessage)message;
            System.out.println("txmessage = " + txmessage.getText());
            message = subscriber.receive();
        }
    }



    /*
    topic模式：
    * 1、一定先要运行一下订阅者，类似于我订阅了这个主题，
    * 2、再运行生产者发送消息，如果订阅者在线就会收到消息，不在线下次上线时也会收到消息
    *
    *
    * 所谓的持久化和非持久化，就是说发送的消息在服务器宕机之后是否还存在，持久化的消息在服务器宕机之后还会存在，非持久化的消息在服务器宕机之后清空
    * （Queue和Topic默认都是持久化的）
    *
    * */
}
