package activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiezhou
 * @CalssName: ActivemqTest
 * @Package activemq
 * @Description: 持久化的topic测试
 * @date 2021/4/2/17:44
 */
public class ProducerDeliveryModeTopicTest {
    private static final String defaultURL = "tcp://" + "124.70.74.189" + ":" + "61616";
    private static final String defaultTopic_NAME = "topic001";
    static AtomicInteger i = new AtomicInteger(0);

    /*生产者*/
    public static void main(String[] args) throws JMSException, URISyntaxException, ExecutionException, InterruptedException {
        ActiveMQConnection connection = ActiveMQConnection.makeConnection(defaultURL);//创建连接

        Session session = connection.createSession(false, 1);//创建session

        Destination destination = session.createTopic(defaultTopic_NAME);//创建目的地（队列或者topic）
        MessageProducer producer = session.createProducer(destination);//创建生产者
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//设置是否持久化
        connection.start();
        for (int j = 0; j < 4; j++) {
            ActiveMQTextMessage message = new ActiveMQTextMessage();
            message.setText("message--" + i.incrementAndGet());
//          message.setJMSDeliveryMode(DeliveryMode.PERSISTENT);//设置是否持久化,服务器宕机，消息还在，非持久化的，服务器宕机，消息丢失，（其实和zookeeper的数据节点一样，有临时节点和持久节点）
            producer.send(message);
        }
        session.close();
        connection.close();
        producer.close();
        System.out.println("消息发送完成...");
    }

}
