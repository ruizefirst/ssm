package com.dsy.www.coding.senior.data;

import java.util.Enumeration;
import java.util.Vector;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 9:51:30 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)   高级教程：java数据结构
 * @parameter
 * @since  
 * @return
 * java工具包提供了强大的数据结构。在java中的数据结构主要包括以下几种接口和类：
 * 1、枚举（Enumeration）
 * 2、位集合（BitSet）
 * 3、向量（Vector）：和传统数组非常相似，但是Vector的大小能根据需要动态的变化，元素也能通过索引访问（好处，不用指定大小，会根据需要动态变化）
 * 4、栈（Stack）：是Vector的一个子类，标准的后进先出结构
 * 5、字典（Dictionary）：是一个抽象类，它定义了键映射到值的数据结构
 * 6、哈希表（HashTable）
 * 7、属性（Properties）
 * 以上这些类是传统遗留的，在java2中引入了一种新的集合框架（Collection）
 * 
 * 
 * 
 * 
 * 
 **/
public class DataStructureDemo {
	public static void main(String args[]){
		Enumeration days;//枚举类型
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

