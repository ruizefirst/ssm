package com.dsy.www.coding.date;

import java.util.Date;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 9, 2017 1:02:27 AM
 * @version 1.0
 * @Description: TODO����һ��ʱ��
 * @parameter
 * @since  
 * @return
 * 
 **/
public class SleepDemo {
	public static void main(String args[]){
		try{
			System.out.println(new Date()+"\n");
			Thread.sleep(1000*3);
			System.out.println(new Date()+"\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

