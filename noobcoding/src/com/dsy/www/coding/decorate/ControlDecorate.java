package com.dsy.www.coding.decorate;

/**
 *java访问修饰符：Java支持4种不同的访问权限。
 *默认的，也称为 default，在同一包内可见，不使用任何修饰符。
 *私有的，以 private 修饰符指定，在同一类内可见。
 *共有的，以 public 修饰符指定，对所有类可见。
 *受保护的，以 protected 修饰符指定，对同一包内的类和所有子类可见
 * 	
 *修饰符                 当前类                  同一包内                 子孙类                 其他包
 *public    Y         Y          Y         Y 
 *protected Y         Y          Y         N 
 *default   Y         Y          N         N 
 *private   Y         N          N         说N 
 *
 * 接口中的变量被隐式声明为 public static final
 * 接口里的方法默认情况下访问的权限为public
 * protected 访问修饰符不能修饰类和接口，方法和成员变量能够声明为 protected，但是接口的成员变量和成员方法不能声明为 protected
 * */


/***
 *访问控制和继承
 *父类中声明为public的方法在子类中必须为public
 *父类中声明为protected的方法在子类中要么声明为protected,要么声明为public,不能声明为private
 *父类中声明为private的方法，不能够被继承
 * */
public class ControlDecorate {
	int k;
	ControlDecorate(){
		System.out.println("-----0");
	};
	//代码块
	{
		int i = 0;
		int j = 0;
		k++;
		System.out.println(++i+j+++"=="+k);
	}
	//静态代码块
	static{
		System.out.println("---1");
	}
	public static void main(String args[]){
		//执行优先级 ：静态代码块>代码块>构造函数
		new ControlDecorate();
	}
}
class InstanceCounter{
	private static int numInstances = 0;
	protected static int getCount(){
		return numInstances;
	}
	private static void addInstance(){
		numInstances++;
	}
	InstanceCounter(){
		InstanceCounter.addInstance();
	}
	public static void main(String args[]){
		System.out.println("Starting with "+InstanceCounter.getCount()+" instance");
		for(int i=0;i<500;i++){
			new InstanceCounter();
		}
		System.out.println("Created "+InstanceCounter.getCount()+" instances");
		
	}
}
