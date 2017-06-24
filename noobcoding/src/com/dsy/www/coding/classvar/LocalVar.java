package com.dsy.www.coding.classvar;

public class LocalVar {
	int age;   //变量的优先级        局部变量>实例变量、类变量
	public void pupAge(){
		int age; //age 变量没有初始化，所以在编译时会出错
		age = age+7;
		System.out.println("小狗的年龄是："+age);
	}
	public static void main(String args[]){
		LocalVar lv = new LocalVar();
		lv.pupAge();
	}
}
