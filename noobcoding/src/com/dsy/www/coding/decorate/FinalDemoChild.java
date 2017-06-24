package com.dsy.www.coding.decorate;

public class FinalDemoChild extends FinalDemo{
	/* String finalMethod(){
		 System.out.println("覆写父类中的方法");
		 return "1";
	}*/
	/**
	 * final方法可以被子类继承，但不能被子类修改
	 * final类不能被继承
	 * 
	 * this关键字必须放在非静态方法里面
	 * this关键字代表自身，在程序中主要的使用用途有以下几个方面：
 	 * 使用this关键字引用成员变量
 	 * 使用this关键字在自身构造方法内部引用其它构造方法
 	 * 使用this关键字代表自身类的对象
	 * 使用this关键字引用成员方法
	 * 
	 * */
	public void getThis(){
		this.finalMethod();
	}
	public FinalDemoChild(String name){
		System.out.println("带参数的构造");
	}
	public FinalDemoChild(){
		System.out.println(this.finalMethod()+"who");
		System.out.println(super.finalMethod()+"where");
	}
	public static void main(String args[]){
		new FinalDemoChild().finalMethod();
	
	}
}
