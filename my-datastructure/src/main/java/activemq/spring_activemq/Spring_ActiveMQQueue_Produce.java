package activemq.spring_activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Message;

/**
 * @author jiezhou
 * @CalssName: Spring_ActiveMQQueue_Produce
 * @Package activemq.spring_activemq
 * @Description: spring整合的actvicemq   生产者
 * @date 2021/3/12/17:17
 */
@Component("springMqQP")
public class Spring_ActiveMQQueue_Produce {

    @Autowired
    private static JmsTemplate template;

    public void process() {
        template.send(session->{
            Message message = session.createTextMessage("----spring整合activemq----");
            return message;
        });
        System.out.println("生产者发送消息完成！");

    }

    public static void main(String[] args) {
        //加载spring文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("activemq-spring.xml");
        Spring_ActiveMQQueue_Produce spring_activeMQQueue_produce = applicationContext.getBean("springMqQP", Spring_ActiveMQQueue_Produce.class);
        spring_activeMQQueue_produce.process();
    }










}
