package com.dsy.www.coding.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 10, 2017 11:11:50 AM
 * @version 1.0
 * @Description: TODO  ���տ���̨����  �����������̨
 * @parameter
 * @since  
 * @return
 * 
 **/
public class IODemo {
	public static char t;
	public static void main(String args[]) throws IOException{
		char c ;
		System.out.println(t);
		//ʹ��System.in ����BufferedReader
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����ַ�������'q' ���˳���");
		//��ȡ�ַ�
		do{
			c = (char)br.read();
			System.out.println(c);
		}while(c!='q');
		
	}

}

