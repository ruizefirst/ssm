package com.dsy.www.coding.senior.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 11:12:35 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用) 发送邮件
 * @parameter
 * @since  
 * @return
 * 此程序报错 ，有时间在追究
 * javax.mail.MessagingException: Could not connect to SMTP host: localhost, port: 25;
 * nested exception is:
 *	java.net.ConnectException: Connection refused: connect
 **/
public class SendMail {
	public static void main(String args[]){
		//收件人电子邮箱
		String to = "ruizefirst@163.com";
		//发件人电子邮箱
		String from = "476388956@qq.com";
		//指定发送邮件的主机为localhost
		String host = "localhost";
		//获取系统属性
		Properties properties = System.getProperties();
		//设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		
		//获取默认session对象
		Session session = Session.getDefaultInstance(properties);
		 try{
			 //创建默认的MimeMessage对象
			 MimeMessage  message = new MimeMessage(session);
			 
			 //Set From :头部头片段
			 message.setFrom(new InternetAddress(from));
			 //Set to :头部头字段
			 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			 
			 //set Subject:头部头片段
			 message.setSubject("This is the Subject Line!");
			 
			 //设置消息体
			 message.setText("This is actual message");
			 
			 //发送消息
			 Transport.send(message);
			 System.out.println("Sent message successfully...");
		 }catch(MessagingException mex){
			 mex.printStackTrace();
		 }
		
	}
	
}

