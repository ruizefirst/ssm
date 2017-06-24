package com.dsy.www.coding.classvar;

public class LocalVarInit {
	//age是一个局部变量。定义在pupAge()方法中，它的作用域就限制在这个方法中
	public void pupAge(){
		int age = 0; //局部变量没有默认值  声明后，必须初始化才能使用
		age = age+7;
		System.out.println("小狗的年龄是："+age);
	}
	public static void main(String args[]){
		LocalVarInit lv = new LocalVarInit();
		lv.pupAge();
	}

}
