package com.dsy.www.coding.date;

import java.util.Date;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 9, 2017 1:32:29 AM
 * @version 1.0
 * @Description: TODO����ʱ���
 * @parameter
 * @since  
 * @return
 * 
 **/
public class DiffDemo {
	public static void main(String args[]){
		try{
			long start  = System.currentTimeMillis();
			System.out.println(new Date()+"\n");
			Thread.sleep(5*60*10);
			System.out.println(new Date()+"\n");
			long end = System.currentTimeMillis();
			long diff = end -start;
			System.out.println("Difference is:"+diff);
			
		}catch(Exception e){
			System.out.println("Got an exception ");
			//e.printStackTrace();
		}
		
	}

}

