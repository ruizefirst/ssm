package com.dsy.www.coding.decorate;
/**
 * 抽象方法是一种没有任何实现的方法，该方法的具体实现类由子类提供
 * 抽象方法不能被声明为final和static
 * 任何继承抽象类的子类必须实现父类的所有抽象方法，除非该类也是抽象类。
 * 如果一个类若干个抽象方法，那么该类必须声明为抽象类。抽象类不包含抽象方法。
 * 抽象方法的声明以分号结尾。
 * */
public abstract class  AbstractDemo {
	//抽象类不能实例化也就是说不能用new创建实例，只能用来被继承
	abstract void m();
	public static void main(String args[]){
		new SubClass().m();
	}
}
class SubClass extends AbstractDemo{
	@Override
	void m() {
		// TODO Auto-generated method stub
		System.out.println("阿拉路阿拉路~~~~~");
	}
}
