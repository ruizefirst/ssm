package com.dsy.www.coding.polymorphism;
/** 
 * @author 作者 :Apollo  江湖人称：无名   、独孤求败
 * @date 创建时间：Jun 12, 2017 5:24:48 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  多态
 * @parameter
 * @since  
 * @return
 * 当使用多态的方法调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误；如果有，再去调用子类的同名方法。
 * 多态的好处：可以使程序有良好的扩展性，并可以对所有类的对象做通用处理。
 * 
 * 
 * 多态的实现方式：
 * 1、重写
 * 2、接口
 * 3、抽象类和抽象方法
 **/
public class PolymorphismDemo {
	public static void main(String args[]){
		show(new Cat());			// 以 Cat 对象调用 show 方法
		show(new Dog());		// 以 Dog 对象调用 show 方法
		Animal a = new Cat();// 向上转型 
		a.eat();		 // 调用的是 Cat 的 eat
		Cat c = (Cat)a;	// 向下转型
		c.work();		// 调用的是 Cat 的 catchMouse

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
		System.out.println("吃鱼");
	}
	public void work(){
		System.out.println("抓老鼠");
	}
	
}
class Dog extends Animal{
	public void eat(){
		System.out.println("吃骨头");
	}
	public void work(){
		System.out.println("看家");
	}
}

