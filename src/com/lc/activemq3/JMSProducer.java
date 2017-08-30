package com.lc.activemq3;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

public class JMSProducer {

	private static final String  USERNAME=ActiveMQConnection.DEFAULT_USER;
	private static final String  PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String  BORKERURL="failover://tcp://123.206.176.229:61616";
	private static final int messageNum=1;
	//private static Logger logger;
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;//���ӹ���
		Connection connection = null;//����
		Session session;//�Ự ���ܻ��߷�����Ϣ���߳�
		Destination destination;//��Ϣ��Ŀ�ĵ�
		MessageProducer messageProducer;//��Ϣ������
		//ʵ�������ӹ���
		connectionFactory=new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BORKERURL);
		
		try {
			
			connection =connectionFactory.createConnection();//ͨ�����ӹ�����ȡ����
			connection.start();//��������
			session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//��ȡ�Ự
			destination=session.createQueue("FirstQueue");//����һ������
			messageProducer=session.createProducer(destination);
			sendMeaasge(session, messageProducer);
			session.commit();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(connection!=null){
				try {
					connection.close();
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
	}
	
	public static void sendMeaasge(Session session,MessageProducer messageProducer){
		for (int i = 0; i < JMSProducer.messageNum; i++) {
			try {
				TextMessage textMessage=session.createTextMessage("Active MQ���͵���Ϣ��"+"�����д���");
				System.out.println("������Ϣ��"+"Active MQ���͵���Ϣ��"+i);
				messageProducer.send(textMessage);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
