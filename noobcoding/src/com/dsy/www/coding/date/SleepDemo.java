package com.dsy.www.coding.date;

import java.util.Date;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 9, 2017 1:02:27 AM
 * @version 1.0
 * @Description: TODO休眠一段时间
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

