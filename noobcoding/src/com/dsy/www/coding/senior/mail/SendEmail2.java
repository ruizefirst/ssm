package com.dsy.www.coding.senior.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 14, 2017 7:39:36 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)
 * @parameter
 * @since  
 * @return
 * // ��Ҫ�û��������ʼ�����ʵ��
 * //�ļ��� SendEmail2.java
 * //��ʵ����QQ����Ϊ��������Ҫ��qq��̨����
 **/
public class SendEmail2 {
	 public static void main(String [] args)
	   {
	      // �ռ��˵�������
	      String to = "xxx@qq.com";
	 
	      // �����˵�������
	      String from = "xxx@qq.com";
	 
	      // ָ�������ʼ�������Ϊ smtp.qq.com
	      String host = "smtp.qq.com";  //QQ �ʼ�������
	 
	      // ��ȡϵͳ����
	      Properties properties = System.getProperties();
	 
	      // �����ʼ�������
	      properties.setProperty("mail.smtp.host", host);
	 
	      properties.put("mail.smtp.auth", "true");
	      // ��ȡĬ��session����
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	        public PasswordAuthentication getPasswordAuthentication()
	        {
	         return new PasswordAuthentication("xxx@qq.com", "qq��������"); //�������ʼ��û���������
	        }
	       });
	 
	      try{
	         // ����Ĭ�ϵ� MimeMessage ����
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From: ͷ��ͷ�ֶ�
	         message.setFrom(new InternetAddress(from));
	 
	         // Set To: ͷ��ͷ�ֶ�
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	 
	         // Set Subject: ͷ��ͷ�ֶ�
	         message.setSubject("This is the Subject Line!");
	 
	         // ������Ϣ��
	         message.setText("This is actual message");
	 
	         // ������Ϣ
	         Transport.send(message);
	         System.out.println("Sent message successfully....from w3cschool.cc");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }

}

