package com.dsy.www.coding.classvar;

public class LocalVar {
	int age;   //���������ȼ�        �ֲ�����>ʵ�������������
	public void pupAge(){
		int age; //age ����û�г�ʼ���������ڱ���ʱ�����
		age = age+7;
		System.out.println("С���������ǣ�"+age);
	}
	public static void main(String args[]){
		LocalVar lv = new LocalVar();
		lv.pupAge();
	}
}
