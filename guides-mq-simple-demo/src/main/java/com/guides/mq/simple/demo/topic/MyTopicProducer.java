package com.guides.mq.simple.demo.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

public class MyTopicProducer {

	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory cf = new  ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection conn = cf.createConnection();
		
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createTopic("topic01");
		
		MessageProducer producer = session.createProducer(destination);
		
		ActiveMQTextMessage message = new ActiveMQTextMessage();
		message.setText(" this is topic message  ");
		
		producer.send(message);
		
		producer.close();
		
		session.close();
		
		
		conn.close();
		
		
	}

}
