package com.dsy.www.coding.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 10, 2017 6:11:33 PM
 * @version 1.0
 * @Description: TODO д���ļ�   ������
 * @parameter
 * @since  
 * @return
 * 
 **/
public class FileStreamTest2 {
	public static void main(String args[]) throws IOException{
		File f = new File("a.txt");
		FileOutputStream fos = new FileOutputStream(f);
		//����FileOutputStream �����ļ������ڻ��Զ�����
		
		OutputStreamWriter writer = new OutputStreamWriter(fos,"UTF-8");
		//����OutputStreamWriter ���󣬲�������ָ�����룬Ĭ��Ϊ����ϵͳĬ�ϱ��룬windows����gbk
		writer .append("��������");
		//д�뵽������
		writer.append("\r\n");
		//����
		writer.append("English");
		//ˢ�»���壬д�뵽�ļ�����������Ѿ�û��д��������ˣ�ֱ��closeҲ��д��
		writer.close();
		//�ر�д������ͬʱ��ѻ���������д���ļ������������ע�͵�
		fos.close();
		//�ر���������ͷ�ϵͳ��Դ
		
		FileInputStream fip = new FileInputStream(f);
		//����FileInputStream����
		
		InputStreamReader reader = new InputStreamReader(fip,"UTF-8");
		//����InputStreamReader���󣬱�����д����ͬ
		
		StringBuffer sb = new StringBuffer();
		while(reader.ready()){
			sb.append((char)reader.read());
			//ת��char�ӵ�StringBuffer������
		}
		System.out.println(sb.toString());
		reader.close();
		//�رն�ȡ��
		fip.close();
		//�ر����������ͷ�ϵͳ��Դ
		
		
		
	}

}

