package com.dsy.www.coding.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 10, 2017 11:11:50 AM
 * @version 1.0
 * @Description: TODO  接收控制台输入  并输出到控制台
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
		//使用System.in 创建BufferedReader
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入字符，按下'q' 键退出。");
		//读取字符
		do{
			c = (char)br.read();
			System.out.println(c);
		}while(c!='q');
		
	}

}

