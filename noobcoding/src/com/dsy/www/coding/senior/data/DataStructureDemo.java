package com.dsy.www.coding.senior.data;

import java.util.Enumeration;
import java.util.Vector;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 13, 2017 9:51:30 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)   �߼��̳̣�java���ݽṹ
 * @parameter
 * @since  
 * @return
 * java���߰��ṩ��ǿ������ݽṹ����java�е����ݽṹ��Ҫ�������¼��ֽӿں��ࣺ
 * 1��ö�٣�Enumeration��
 * 2��λ���ϣ�BitSet��
 * 3��������Vector�����ʹ�ͳ����ǳ����ƣ�����Vector�Ĵ�С�ܸ�����Ҫ��̬�ı仯��Ԫ��Ҳ��ͨ���������ʣ��ô�������ָ����С���������Ҫ��̬�仯��
 * 4��ջ��Stack������Vector��һ�����࣬��׼�ĺ���ȳ��ṹ
 * 5���ֵ䣨Dictionary������һ�������࣬�������˼�ӳ�䵽ֵ�����ݽṹ
 * 6����ϣ��HashTable��
 * 7�����ԣ�Properties��
 * ������Щ���Ǵ�ͳ�����ģ���java2��������һ���µļ��Ͽ�ܣ�Collection��
 * 
 * 
 * 
 * 
 * 
 **/
public class DataStructureDemo {
	public static void main(String args[]){
		Enumeration days;//ö������
		Vector  dayNames = new Vector();
		 dayNames.add("Sunday");
	     dayNames.add("Monday");
	     dayNames.add("Tuesday");
	     dayNames.add("Wednesday");
	     dayNames.add("Thursday");
	     dayNames.add("Friday");
	     dayNames.add("Saturday");
	     days = dayNames.elements();
	     while(days.hasMoreElements()){
	    	 System.out.println(days.nextElement());
	     }

	}
	
	
}

