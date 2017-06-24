package com.dsy.www.coding.senior.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 14, 2017 7:37:15 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  ���ʹ��и����� E-mail
 * @parameter
 * @since  
 * @return
 * 
 **/
public class SendFileEmail {
	 public static void main(String [] args)
	   {
	     
	      // �ռ��˵�������
	      String to = "abcd@gmail.com";
	 
	      // �����˵�������
	      String from = "web@gmail.com";
	 
	      // ָ�������ʼ�������Ϊ localhost
	      String host = "localhost";
	 
	      // ��ȡϵͳ����
	      Properties properties = System.getProperties();
	 
	      // �����ʼ�������
	      properties.setProperty("mail.smtp.host", host);
	 
	      // ��ȡĬ�ϵ� Session ����
	      Session session = Session.getDefaultInstance(properties);
	 
	      try{
	         // ����Ĭ�ϵ� MimeMessage ����
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From: ͷ��ͷ�ֶ�
	         message.setFrom(new InternetAddress(from));
	 
	         // Set To: ͷ��ͷ�ֶ�
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	 
	         // Set Subject: ͷ�ֶ�
	         message.setSubject("This is the Subject Line!");
	 
	         // ������Ϣ����
	         BodyPart messageBodyPart = new MimeBodyPart();
	 
	         // ��Ϣ
	         messageBodyPart.setText("This is message body");
	        
	         // ����������Ϣ
	         Multipart multipart = new MimeMultipart();
	 
	         // �����ı���Ϣ����
	         multipart.addBodyPart(messageBodyPart);
	 
	         // ��������
	         messageBodyPart = new MimeBodyPart();
	         String filename = "file.txt";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	 
	         // ����������Ϣ
	         message.setContent(multipart );
	 
	         //   ������Ϣ
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	}

