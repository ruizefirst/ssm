package com.dsy.www.coding.date;

import java.util.Calendar;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 9, 2017 1:38:46 AM
 * @version 1.0
 * @Description: TODO Calendar�ࣺ������β������úͻ�ȡ�������ݵ��ض������أ�����˵Сʱ���գ����߷���? ��������������ڵ���Щ���ּ��ϻ��߼�ȥֵ��? ����ʹ��Calendar ��
 * @parameter
 * @since  
 * @return
 * 
 **/
public class CalendarDemo {
	
	public static void main(String args[]){
		Calendar c = Calendar.getInstance();
		//����һ������2009��6��12�յ�Calendar����
		c.set(2009, 6 - 1, 12);
		
		
		
		System.out.println("---------------�ָ���---------------");
		Calendar c1 = Calendar.getInstance();
		// ������
		int year = c1.get(Calendar.YEAR);
		// ����·�
		int month = c1.get(Calendar.MONTH) + 1;
		// �������
		int date = c1.get(Calendar.DATE);
		// ���Сʱ
		int hour = c1.get(Calendar.HOUR_OF_DAY);
		// ��÷���
		int minute = c1.get(Calendar.MINUTE);
		// �����
		int second = c1.get(Calendar.SECOND);
		// ������ڼ���ע�⣨�����Date���ǲ�ͬ�ģ���1���������ա�2��������1��3�������ڶ����Դ����ƣ�
		int day = c1.get(Calendar.DAY_OF_WEEK);
		
	}

}

