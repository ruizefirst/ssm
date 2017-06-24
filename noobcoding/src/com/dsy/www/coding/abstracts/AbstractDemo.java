package com.dsy.www.coding.abstracts;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 12, 2017 11:29:39 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  抽象类
 * @parameter
 * @since  
 * @return
 * 1、在java中抽象类表示的是一种继承关系，一个类只能继承一个抽象类，而一个类可以实现多个接口
 * 2、抽象方法，如果你想设计这样一个类，该类包含一个特殊的成员方法，该方法的具体实现由它的子类确定，那么你可以在父类中声明该方法为抽象方法
 * 3、Abstract关键字同样可以用来声明抽象方法，抽象方法只包含一个方法名，而没有方法体。
 * 4、抽象方法没有定义,方法名后面直接跟一个分号，而不是花括弧
 * 
 * 声明抽象方法会造成以下两个结果：
 * 1、如果一个类包含抽象方法，那么该类必须是抽象类
 * 2、任何子类必须重写父类的抽象方法，或者声明自身为抽象类
 * （继承抽象方法的子类必须重写该方法，否则，该子类也必须声明为抽象类。最终，必须有子类实现该抽象方法，否则，从最初的父类到最终的子类都不能用来实例化对象）
 * 
 * 
 * 
 * 抽象类总结：
 * 1、抽象类不能被实例化，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象
 * 2、抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类
 * 3、抽象类的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。
 * 4、构造方法，类方法（用static修饰的方法）不能声明为抽象方法
 * 5、抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。
 **/
public class AbstractDemo {
	public static void main(String args[]){
		//这是不允许，会引发错误（抽象类 不能实例化）
/*		Employee e = new Employee("George W."+"Houston,TX",43);
		Employee ee; //声明是可以的
		System.out.println("\n Call mailCheck using Employee reference--");*/
		
		
		//测试继承
		Salary s = new Salary("Mohd Mohtashim","Ambehta,UP",3,3600.00);
		Employee em = new Salary("John Adams","Boston,MA",2,2400.00);
		System.out.println("Call mailCheck using Salary reference--");
		s.mailCheck();
		
		System.out.println("\n Call mailCheck using Employee reference--");
		em.mailCheck();
	}

}

abstract class Employee{
	private String name;
	private String address;
	private int number;
	public Employee(String name,String address,int number){
		System.out.println("Constructing an Employee");
		this.name = name;
		this.address = address;
		this.number = number;
	}
	
	public double computePay(){
		System.out.println("Inside Employee computePay");
		return 0.0;
	}
	public void mailCheck(){
		System.out.println("Mailing a check to "+this.name+" "+this.address);
	}
	public String toString(){
		return name+" "+address + " "+ number;
	}
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String newAddress){
		address = newAddress;
	}
	public int getNumber(){
		return number;
	}
}

class Salary extends Employee{
	private double salary ;//Annual salary
	public Salary(String name ,String address,int number,double salary){
		super(name,address,number);
		setSalary(salary);
	}
	public void mailCheck(){
		System.out.println("Within mailCheck of Salary class");
		System.out.println("Mailing check to "+getName()+"with salary"+salary);
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double newSalary){
		if(newSalary>=0){
			salary = newSalary;
		}
	}
	public double computePay(){
		System.out.println("Computing salary pay for "+getName());
		return salary/52;
	}
}



