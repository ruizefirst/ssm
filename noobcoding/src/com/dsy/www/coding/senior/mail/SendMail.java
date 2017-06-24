package com.dsy.www.coding.senior.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 13, 2017 11:12:35 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������) �����ʼ�
 * @parameter
 * @since  
 * @return
 * �˳��򱨴� ����ʱ����׷��
 * javax.mail.MessagingException: Could not connect to SMTP host: localhost, port: 25;
 * nested exception is:
 *	java.net.ConnectException: Connection refused: connect
 **/
public class SendMail {
	public static void main(String args[]){
		//�ռ��˵�������
		String to = "ruizefirst@163.com";
		//�����˵�������
		String from = "476388956@qq.com";
		//ָ�������ʼ�������Ϊlocalhost
		String host = "localhost";
		//��ȡϵͳ����
		Properties properties = System.getProperties();
		//�����ʼ�������
		properties.setProperty("mail.smtp.host", host);
		
		//��ȡĬ��session����
		Session session = Session.getDefaultInstance(properties);
		 try{
			 //����Ĭ�ϵ�MimeMessage����
			 MimeMessage  message = new MimeMessage(session);
			 
			 //Set From :ͷ��ͷƬ��
			 message.setFrom(new InternetAddress(from));
			 //Set to :ͷ��ͷ�ֶ�
			 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			 
			 //set Subject:ͷ��ͷƬ��
			 message.setSubject("This is the Subject Line!");
			 
			 //������Ϣ��
			 message.setText("This is actual message");
			 
			 //������Ϣ
			 Transport.send(message);
			 System.out.println("Sent message successfully...");
		 }catch(MessagingException mex){
			 mex.printStackTrace();
		 }
		
	}
	
}

