package com.dsy.www.coding.instance;

public class Puppy {
	int puppyAge;      //���еı���Ϊ��Ա�����������еı���Ϊ�ֲ�������static�����ı���Ϊ�����
	public Puppy(String name){
		//������캯������һ������
		System.out.println("С���������ǣ�"+name);
	}
	
	public void setAge(int age){
		puppyAge = age;
	}
	
	public int getAge(){
		System.out.println("С��������Ϊ��"+puppyAge);
		return puppyAge;
	}
	
	public static void main(String args[]){
		/*��������*/
		Puppy puppy = new Puppy("tommy");
		/*ͨ���������趨age*/
		puppy.setAge(2);
		/*������һ��������ȡage*/
		puppy.getAge();
		/*��Ҳ�����������������ʳ�Ա����*/
		System.out.println("����ֵΪ��"+puppy.puppyAge);
	}
}
