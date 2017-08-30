package com.lc.activemq1;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer {

	private static final String  USERNAME=ActiveMQConnection.DEFAULT_USER;
	private static final String  PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String  BORKERURL=ActiveMQConnection.DEFAULT_BROKER_URL;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;//���ӹ���
		Connection connection = null;//����
		Session session;//�Ự ���ܻ��߷�����Ϣ���߳�
		Destination destination;//��Ϣ��Ŀ�ĵ�
		MessageConsumer consumer;//��Ϣ������
		//ʵ�������ӹ���
		connectionFactory=new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BORKERURL);
        try {
			connection = connectionFactory.createConnection();
			connection.start();
			session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			destination=session.createTopic("FirstTopic");
			consumer=session.createConsumer(destination);
			consumer.setMessageListener(new Listener());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
