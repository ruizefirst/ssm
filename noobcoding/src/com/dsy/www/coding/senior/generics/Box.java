package com.dsy.www.coding.senior.generics;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 2:21:50 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  泛型类
 * @parameter
 * @since  
 * @return
 * 
 **/
public class Box<T> {
	private T t;
	public void add(T t){
		this.t = t;
	}
	public T get(){
		return t;
	}
	
	public static void main(String args[]){
		Box<Integer> integerBox = new Box<Integer>();
		Box<String>  stringBox = new Box<String>();
		integerBox.add(new Integer(10));
		stringBox.add(new String("菜鸟教程"));
		System.out.printf("整型值为：%d\n\n",integerBox.get());
		System.out.printf("字符串为：%s\n",stringBox.get());
	}

}

