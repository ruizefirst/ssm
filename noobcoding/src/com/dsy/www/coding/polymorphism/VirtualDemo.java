package com.dsy.www.coding.polymorphism;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 12, 2017 10:59:06 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  �����鷽��
 * @parameter
 * @since  
 * @return
 * 
 **/
public class VirtualDemo {
	public static void main(String args[]){
		Salary salary = new Salary("Ա�� A", "����", 3,3600.00);
		Employee employee = new Salary("Ա��B","����",2,2400);
		System.out.println("ʹ��Salary�����õ���mailCheck--");
		salary.mailCheck();
		System.out.println("\nʹ��Employee�����õ���mailCheck--");
		employee.mailCheck();
	}

}

