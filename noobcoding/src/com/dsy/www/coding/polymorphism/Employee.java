package com.dsy.www.coding.polymorphism;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 12, 2017 10:42:18 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  �鷽��
 * @parameter
 * @since  
 * @return
 * ��ʹ�ö�̬��ʽ���÷���ʱ�������ȼ�鸸�����Ƿ��и÷��������û�У�������������У���ȥ�����������ͬ��������
 * ��̬�ĺô�������ʹ���������õ���չ�������Զ�������Ķ������ͨ�ô���
 * 
 * ��������������д�ķ���ʱ�����õ�������ķ����������Ǹ����б���д�ķ�����
 * ��Ҫ���ø����б���д�ķ�������ʹ�ùؼ���super
 * 
 * 
 * ��дֻ��Է���������Ա���
 **/
public class Employee {
	
	private String name;
	private String address;
	private int number;
	public Employee(String name,String address,int number){
		System.out.println("Employee ���캯��");
		this.name = name;
		this.address = address;
		this.number = number;
	}
	
	public void mailCheck(){
		System.out.println("�ʼ�֧Ʊ����"+this.name+" "+this.address);
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
		System.out.println("Salary���mailCheck����");
		System.out.println("�ʼ�֧Ʊ����"+getName()+",����Ϊ��"+salary);
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
		System.out.println("���㹤�ʣ�������"+getName());
		return salary/52;
	}
}

