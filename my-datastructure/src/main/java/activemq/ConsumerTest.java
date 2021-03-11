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
public class ConsumerTest {
    private static final String defaultURL = "tcp://" + "124.70.74.189" + ":" + "61616";
    private static final String defaultQueue_NAME = "queue001";

    public static void main(String[] args) throws URISyntaxException, JMSException, IOException {
        ActiveMQConnection connection = ActiveMQConnection.makeConnection(defaultURL);//创建连接
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//创建session  第一个参数是是否开启事务，false 不开启，true开启，如果消费者开启了事务，就必须要commit，否则会出现消息重复消费（activemq服务器不认为消费者消费了，所以会出现重复消费情况）

        Destination destination = session.createQueue(defaultQueue_NAME);//创建目的地（队列或者topic）
        MessageConsumer consumer = session.createConsumer(destination);//创建消费者
        /*while (true){
            TextMessage message = (TextMessage) consumer.receive();//会永远阻塞等待消息，加参数的 receive(long var1)  时间到了还没有消息就会结束阻塞。
            if(message==null){
                break;
            }else {
                String text = message.getText();
                System.out.println("text = " + text);
            }
        }
        //关闭连接和session
        session.close();
        connection.close();*/


        MessageListener messageListener = new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message != null && message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = null;
                    try {
                        text = textMessage.getText();
                        System.out.println("text = " + text);
                        //如果创建session时参数是CLIENT_ACKNOWLEDGE（手动签收），则需要手动签收，不然会出现重复消费消息的情况，如果是AUTO_ACKNOWLEDGE（自动签收），则不要任何处理就签收
//                        textMessage.acknowledge();//手动签收
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        consumer.setMessageListener(messageListener);
//        session.commit();//当创建session时开启了事务，必须要手动commit，否则会出现消息重复消费情况
//        session.rollback();

        System.in.read();
        consumer.close();
        session.close();
        connection.close();

        /**
         * public interface Session extends Runnable {
         *
         * 签收一般针对于消费者而言
         int AUTO_ACKNOWLEDGE = 1;  自动签收
         int CLIENT_ACKNOWLEDGE = 2; 手动签收
         int DUPS_OK_ACKNOWLEDGE = 3; 允许重复签收
         int SESSION_TRANSACTED = 0;
         *
         *
         *当事务和签收同时起作用时，事务>签收
         * 事务开启条件下
         *     commit提交，手动签收如果不acknowledge() ，也不会重复消费消息（也就是commit会默认帮你签收）
         *     commit未提交，即使acknowledge() 了,也会出现重复消费消息
         *  总结：
         *          一句话，在事务未开启时，acknowledge()方法就会起作用
         *          在事务开启时，一切以commit() 为准。acknowledge()方法不会起作用
         *
         *
         *
         *
         * 题：
         *      怎么保证mq的消息可靠性？
         *          1、持久性
         *          2、事务
         *          3、集群
         */
    }
}
