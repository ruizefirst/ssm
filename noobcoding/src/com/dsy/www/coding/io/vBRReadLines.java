package com.dsy.www.coding.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 10, 2017 11:31:50 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)
 * @parameter
 * @since  
 * @return
 * 
 **/
public class vBRReadLines {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.println("Enter lines of text");
		System.out.println("Enter 'end' to quit.");
		do{
			str = br.readLine();//�ӿ���̨��ȡһ���ַ���
			System.out.println(str);
		}while(!str.equals("end"));
	}

}

