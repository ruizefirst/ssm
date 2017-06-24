package com.dsy.www.coding.polymorphism;
/** 
 * @author ���� :Apollo  �����˳ƣ�����   ���������
 * @date ����ʱ�䣺Jun 12, 2017 5:24:48 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  ��̬
 * @parameter
 * @since  
 * @return
 * ��ʹ�ö�̬�ķ������÷���ʱ�����ȼ�鸸�����Ƿ��и÷��������û�У�������������У���ȥ���������ͬ��������
 * ��̬�ĺô�������ʹ���������õ���չ�ԣ������Զ�������Ķ�����ͨ�ô���
 * 
 * 
 * ��̬��ʵ�ַ�ʽ��
 * 1����д
 * 2���ӿ�
 * 3��������ͳ��󷽷�
 **/
public class PolymorphismDemo {
	public static void main(String args[]){
		show(new Cat());			// �� Cat ������� show ����
		show(new Dog());		// �� Dog ������� show ����
		Animal a = new Cat();// ����ת�� 
		a.eat();		 // ���õ��� Cat �� eat
		Cat c = (Cat)a;	// ����ת��
		c.work();		// ���õ��� Cat �� catchMouse

	}
	public static void show(Animal a){
		a.eat();
		if(a instanceof Cat){
			Cat  c = (Cat)a;
			c.work();
		}else if(a instanceof Dog){
			Dog c = (Dog)a;
			c.work();
		}
		
	}
}
abstract class  Animal{
	abstract void eat();
}
class Cat extends Animal{
	public void eat(){
		System.out.println("����");
	}
	public void work(){
		System.out.println("ץ����");
	}
	
}
class Dog extends Animal{
	public void eat(){
		System.out.println("�Թ�ͷ");
	}
	public void work(){
		System.out.println("����");
	}
}

