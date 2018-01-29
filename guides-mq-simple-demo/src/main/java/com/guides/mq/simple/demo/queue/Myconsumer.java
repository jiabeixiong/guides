package com.guides.mq.simple.demo.queue;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * mq 消费者
 * @author yangming
 *
 */
public class Myconsumer {

	public static void main(String[] args) throws JMSException {
		QueueConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		QueueConnection conn = cf.createQueueConnection();
		conn.start();
		QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue("queue01");
		
		MessageConsumer consumer = session.createConsumer(destination);
		
		while(true) {
			Message message = consumer.receive();
			if(message == null) break;
			TextMessage tm = (TextMessage) message;
			System.out.println("接收到消息："+tm.getText());
		}
		
		
		consumer.close();
		
		session.close();
		
		conn.close();
		
		
	}

}
