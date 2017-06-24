package com.dsy.www.coding.abstracts;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 12, 2017 11:29:39 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  ������
 * @parameter
 * @since  
 * @return
 * 1����java�г������ʾ����һ�ּ̳й�ϵ��һ����ֻ�ܼ̳�һ�������࣬��һ�������ʵ�ֶ���ӿ�
 * 2�����󷽷�����������������һ���࣬�������һ������ĳ�Ա�������÷����ľ���ʵ������������ȷ������ô������ڸ����������÷���Ϊ���󷽷�
 * 3��Abstract�ؼ���ͬ�����������������󷽷������󷽷�ֻ����һ������������û�з����塣
 * 4�����󷽷�û�ж���,����������ֱ�Ӹ�һ���ֺţ������ǻ�����
 * 
 * �������󷽷�������������������
 * 1�����һ����������󷽷�����ô��������ǳ�����
 * 2���κ����������д����ĳ��󷽷���������������Ϊ������
 * ���̳г��󷽷������������д�÷��������򣬸�����Ҳ��������Ϊ�����ࡣ���գ�����������ʵ�ָó��󷽷������򣬴�����ĸ��ൽ���յ����඼��������ʵ��������
 * 
 * 
 * 
 * �������ܽ᣺
 * 1�������಻�ܱ�ʵ�����������ʵ�������ͻᱨ�������޷�ͨ����ֻ�г�����ķǳ���������Դ�������
 * 2���������в�һ���������󷽷��������г��󷽷�����ض��ǳ�����
 * 3��������ĳ��󷽷�ֻ�������������������壬���ǲ����������ľ���ʵ��Ҳ���Ƿ����ľ��幦�ܡ�
 * 4�����췽�����෽������static���εķ�������������Ϊ���󷽷�
 * 5��������������������������еĳ��󷽷��ľ���ʵ�֣����Ǹ�����Ҳ�ǳ����ࡣ
 **/
public class AbstractDemo {
	public static void main(String args[]){
		//���ǲ��������������󣨳����� ����ʵ������
/*		Employee e = new Employee("George W."+"Houston,TX",43);
		Employee ee; //�����ǿ��Ե�
		System.out.println("\n Call mailCheck using Employee reference--");*/
		
		
		//���Լ̳�
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



