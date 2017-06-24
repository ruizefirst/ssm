package com.dsy.www.coding.polymorphism;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 12, 2017 10:42:18 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  虚方法
 * @parameter
 * @since  
 * @return
 * 当使用多态方式调用方法时，首先先检查父类中是否有该方法，如果没有，则编译错误；如果有，再去掉调用子类的同名方法。
 * 多态的好处：可以使程序有良好的扩展，并可以对所有类的对象进行通用处理
 * 
 * 当子类对象调用重写的方法时，调用的是子类的方法，而不是父类中被重写的方法。
 * 想要调用父类中被重写的方法必须使用关键字super
 * 
 * 
 * 重写只针对方法，不针对变量
 **/
public class Employee {
	
	private String name;
	private String address;
	private int number;
	public Employee(String name,String address,int number){
		System.out.println("Employee 构造函数");
		this.name = name;
		this.address = address;
		this.number = number;
	}
	
	public void mailCheck(){
		System.out.println("邮寄支票给："+this.name+" "+this.address);
	}
	
	public String toString(){
		return name+" "+address+" "+number;
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
	private double salary;
	public Salary(String name, String address, int number,double salary) {
		super(name, address, number);
		setSalary(salary);
		// TODO Auto-generated constructor stub
		
	}
	public void mailCheck(){
		System.out.println("Salary类的mailCheck方法");
		System.out.println("邮寄支票给："+getName()+",工资为："+salary);
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
		System.out.println("计算工资，付给："+getName());
		return salary/52;
	}
}

