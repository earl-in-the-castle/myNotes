package com.lc.activemq1;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * 监听消息
 * @author 39054
 *
 */
public class Listener2 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("消费者2收到的消息："+((TextMessage) message).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
