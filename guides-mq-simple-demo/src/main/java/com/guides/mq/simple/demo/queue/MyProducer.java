package com.guides.mq.simple.demo.queue;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;


/**
 * mq 生产者
 * @author yangming
 *
 */
public class MyProducer {

	public static void main(String[] args) throws JMSException {
		
		QueueConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		
		QueueConnection conn = cf.createQueueConnection();
		
		QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue("queue01");// 消息目的地
		
		MessageProducer producer = session.createProducer(destination);
		ActiveMQTextMessage message = new ActiveMQTextMessage();
		message.setText("this is msg context 2 .");
		producer.send(message);
//		session.commit();
		
		producer.close();// 关闭  
        session.close();  
        conn.close();  
		
		
		
	}

}
