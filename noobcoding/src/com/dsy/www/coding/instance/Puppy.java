package com.dsy.www.coding.instance;

public class Puppy {
	int puppyAge;      //类中的变量为成员变量，方法中的变量为局部变量，static声明的变量为类变量
	public Puppy(String name){
		//这个构造函数仅有一个参数
		System.out.println("小狗的名字是："+name);
	}
	
	public void setAge(int age){
		puppyAge = age;
	}
	
	public int getAge(){
		System.out.println("小狗的年龄为："+puppyAge);
		return puppyAge;
	}
	
	public static void main(String args[]){
		/*创建对象*/
		Puppy puppy = new Puppy("tommy");
		/*通过方法来设定age*/
		puppy.setAge(2);
		/*调用另一个方法获取age*/
		puppy.getAge();
		/*你也可以像下面这样访问成员变量*/
		System.out.println("变量值为："+puppy.puppyAge);
	}
}
