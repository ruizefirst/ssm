package com.dsy.www.coding.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 10, 2017 11:31:50 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)
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
			str = br.readLine();//从控制台读取一个字符串
			System.out.println(str);
		}while(!str.equals("end"));
	}

}

