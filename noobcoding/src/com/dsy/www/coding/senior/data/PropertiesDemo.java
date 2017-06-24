package com.dsy.www.coding.senior.data;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 10:32:38 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  Porperties属性
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
	    	str = (String)itr.next();//输出内容无序
	    	System.out.println("The Capital of "+str+" is "+capitals.getProperty(str)+".");
	    }
	    System.out.println();
	    
	    //look for state not in list  --specify default
	    str = capitals.getProperty("Florida","Not Found");//没有的话 可以用Not Found 填充
	    System.out.println("The capital of Florida is "+str+".");
	}
}

