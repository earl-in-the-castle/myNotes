package com.lc.activemq3;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * ������Ϣ
 * @author 39054
 *
 */
public class Listener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("�յ�����Ϣ��"+((TextMessage) message).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
