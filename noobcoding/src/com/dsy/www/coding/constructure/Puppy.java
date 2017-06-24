package com.dsy.www.coding.constructure;

public class Puppy {
	//构造函数不能加返回类型 包括void
	public void Puppy(){
		
	}
	public Puppy(String name){
		System.out.println("小狗的名字叫"+name);
	}
	//若果有多个构造函数，调用默认构造时，必须要将默认构造函数声明
	public Puppy() {
	}
	public static void main(String args[]){
		new Puppy("tommy");
	}
}
