package com.lc.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSProducer {

	private static final String  USERNAME=ActiveMQConnection.DEFAULT_USER;
	private static final String  PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String  BORKERURL=ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final int messageNum=1;
	//private static Logger logger;
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;//连接工厂
		Connection connection = null;//连接
		Session session;//会话 接受或者发送消息的线程
		Destination destination;//消息的目的地
		MessageProducer messageProducer;//消息生产者
		//实例化连接工厂
		connectionFactory=new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD, JMSProducer.BORKERURL);
		
		try {
			
			connection =connectionFactory.createConnection();//通过连接工厂获取连接
			connection.start();//启动链接
			session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//获取会话
			destination=session.createQueue("FirstQueue4");//创建一个队列
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
				//TextMessage textMessage=session.createTextMessage("Active MQ发送的消息："+"hahaha");
				MapMessage mapMessage=session.createMapMessage();
				mapMessage.setString("1", "aaa");
				mapMessage.setString("2", "bbb");
				System.out.println("发送消息："+"Active MQ发送的消息："+i);
				messageProducer.send(mapMessage);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
