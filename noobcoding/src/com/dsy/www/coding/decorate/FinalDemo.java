package com.dsy.www.coding.decorate;
/***
 *final 变量能被显式地初始化并且只能初始化一次。被声明为 final 的对象的引用不能指向不同的对象。 
 *但是 final 对象里的数据可以被改变。也就是说 final 对象的引用不能改变，但是里面的值可以改变。 
 *
 **/

public class FinalDemo {
	final int value = 10;
	public static final int BOXWIDTH= 6;
	static final String TITLE="Manager";
	
	public void changeValue(){
		value = 12;
	}
	//final 修饰方法，此方法不能被覆写
	 final String finalMethod(){
		int finalVar = 1;
		System.out.println("你不能修改我:"+finalVar);		
		return "你不能修改我:"+finalVar;
	}
}
