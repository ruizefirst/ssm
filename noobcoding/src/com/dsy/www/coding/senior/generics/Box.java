package com.dsy.www.coding.senior.generics;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 13, 2017 2:21:50 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  ������
 * @parameter
 * @since  
 * @return
 * 
 **/
public class Box<T> {
	private T t;
	public void add(T t){
		this.t = t;
	}
	public T get(){
		return t;
	}
	
	public static void main(String args[]){
		Box<Integer> integerBox = new Box<Integer>();
		Box<String>  stringBox = new Box<String>();
		integerBox.add(new Integer(10));
		stringBox.add(new String("����̳�"));
		System.out.printf("����ֵΪ��%d\n\n",integerBox.get());
		System.out.printf("�ַ���Ϊ��%s\n",stringBox.get());
	}

}

