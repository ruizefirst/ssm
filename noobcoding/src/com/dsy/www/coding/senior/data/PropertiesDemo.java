package com.dsy.www.coding.senior.data;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 13, 2017 10:32:38 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  Porperties����
 * @parameter
 * @since  
 * @return
 * 
 **/
public class PropertiesDemo {
	public static void main(String argsp[]){
		Properties capitals = new Properties();
		Set states;
		String str;
		capitals.put("Illinois", "Springfield");
	    capitals.put("Missouri", "Jefferson City");
	    capitals.put("Washington", "Olympia");
	    capitals.put("California", "Sacramento");
	    capitals.put("Indiana", "Indianapolis");
	    
	    //Show all states and capitals in hashtable
	    states = capitals.keySet();
	    Iterator itr = states.iterator();
	    while(itr.hasNext()){
	    	str = (String)itr.next();//�����������
	    	System.out.println("The Capital of "+str+" is "+capitals.getProperty(str)+".");
	    }
	    System.out.println();
	    
	    //look for state not in list  --specify default
	    str = capitals.getProperty("Florida","Not Found");//û�еĻ� ������Not Found ���
	    System.out.println("The capital of Florida is "+str+".");
	}
}

