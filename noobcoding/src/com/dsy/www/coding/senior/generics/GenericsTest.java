package com.dsy.www.coding.senior.generics;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 2:28:43 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)类型通配符
 * @parameter
 * @since  
 * @return
 * 1、类型通配符一般是使用?代替具体的类型参数。例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。 
 * 2、类型通配符上限通过形如List<? extends Number>来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。
 * 3、类型通配符下限通过形如 List<? super Number>来定义，表示类型只能接受Number及其三层父类类型，如Objec类型的实例。
 * 
 * <? extends T>表示该通配符所代表的类型是T类型的子类。
 * <? super T>表示该通配符所代表的类型是T类型的父类。
 **/
public class GenericsTest {
	public static void main(String args[]){
		List<String> name = new ArrayList<String>();
		List<Integer> age = new ArrayList<Integer>();
		List<Number>  number = new ArrayList<Number>();
		name.add("icon");
		age.add(18);
		number.add(314);
		
	}
	
	public static void getData(List<?> data){
		System.out.println("data:"+data.get(0)); 
	}
	
	public static void getData1(List<? extends Number> data){
		System.out.println("data:"+data.get(0));
	}

}

