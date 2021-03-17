package activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;
import java.net.URISyntaxException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiezhou
 * @CalssName: ActivemqTest
 * @Package activemq
 * @Description: activemq测试
 * @date 2021/4/2/17:44
 */
public class ProducerTest {
    private static final String defaultURL = "tcp://" + "124.70.74.189" + ":" + "61616";
    private static final String defaultQueue_NAME = "queue001";
    static AtomicInteger i = new AtomicInteger(0);

    /*生产者*/
    public static void main(String[] args) throws JMSException, URISyntaxException, ExecutionException, InterruptedException {
        ActiveMQConnection connection = ActiveMQConnection.makeConnection(defaultURL);//创建连接
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//创建session   第一个参数是是否开启事务，false是不开启事务，true是开启事务   第二个参数  签收（自动签收，手动签收，允许重复签收消息）

        Destination destination = session.createQueue(defaultQueue_NAME);//创建目的地（队列或者topic）
        final MessageProducer producer = session.createProducer(destination);//创建生产者
//            producer.setDeliveryMode(DeliveryMode.PERSISTENT);//设置是否持久化
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> schedule = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                ActiveMQTextMessage message = new ActiveMQTextMessage();
                try {
                    message.setText("message--" + i.incrementAndGet());
                    message.setJMSDeliveryMode(DeliveryMode.PERSISTENT);//设置是否持久化,服务器宕机，消息还在，非持久化的，服务器宕机，消息丢失，（其实和zookeeper的数据节点一样，有临时节点和持久节点）
                    producer.send(message);
                    System.out.println("消息发送完成...");
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }, 1, 3, TimeUnit.SECONDS);

        //session.commit();//如果开启事务，需要再次提交才能提交的目的地里面，否则消费者消费不到未提交的消息
//        session.rollback();//回滚

        /**
         * public interface Session extends Runnable {
         *
         * 签收一般针对于消费者而言
         int AUTO_ACKNOWLEDGE = 1;  自动签收
         int CLIENT_ACKNOWLEDGE = 2; 手动签收
         int DUPS_OK_ACKNOWLEDGE = 3; 允许重复签收
         int SESSION_TRANSACTED = 0;
         *
         */
    }





}
