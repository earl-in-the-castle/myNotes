package com.lc.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MapMessage;
/**
 * ������Ϣ
 * @author 39054
 *
 */
public class Listener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		
		
		try {
			
			System.out.println("�յ�����Ϣ��"+((MapMessage)message).getString("1"));
			System.out.println("�յ�����Ϣ��"+((MapMessage)message).getString("2"));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
