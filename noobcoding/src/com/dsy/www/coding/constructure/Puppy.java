package com.dsy.www.coding.constructure;

public class Puppy {
	//���캯�����ܼӷ������� ����void
	public void Puppy(){
		
	}
	public Puppy(String name){
		System.out.println("С�������ֽ�"+name);
	}
	//�����ж�����캯��������Ĭ�Ϲ���ʱ������Ҫ��Ĭ�Ϲ��캯������
	public Puppy() {
	}
	public static void main(String args[]){
		new Puppy("tommy");
	}
}
