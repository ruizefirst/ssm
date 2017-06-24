package com.dsy.www.coding.over;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 12, 2017 3:45:30 PM
 * @version 1.0
 * @Description: 
 * @parameter
 * @since  
 * @return
 * 1、重写是子类对父类的允许访问的方法的实现过程进行重新编写，返回值和形参都不能改变。即外壳不变，核心重写！
 * 2、重写的好处：子类可以根据需要，定义特定于自己的行为。也就是说子类能够根据需要实现父类的方法。
 * 3、重写方法不能抛出新的检查异常或者比被重写方法申明更加宽泛的异常。例如：父类的一个方法申明了一个检查异常IOException,
 * 但是在重写这个方法的时候不能抛出Exception异常，因为Exception是IOException的父类，只能抛出IOException的子类异常。
 * 4、在面向对象原则里，重写意味着可以重写任何现有方法。
 * 
 * 
 * 方法重写的规则：
 * 1、参数列表必须完全与被重写方法的相同（参数列表相同）
 * 2、返回类型必须完全与被重写方法的返回类型相同（返回类型相同）
 * 3、访问权限不能比父类中被重写的方法的访问权限更低。例如：父类方法被声明为public，则子类中重写该方法就不能声明为protected（访问权限不能低于父类方法）
 * 4、父类的成员方法只能被它的子类重写
 * 5、声明为final的方法不能被重写
 * 6、声明为static的方法不能被重写，但是能够被再次声明（静态方法不能被重写）
 * 7、重写的方法能够抛出任何     非强制性异常     ，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常或者比被重写方法声明的更广泛的强制性异常。
 * 8、构造方法不能被重写
 * 9、如果不能继承一个方法，则不能重写这个方法
 * 
 **/
public class OverrideDemo {
	public static void main(String args[]){
		Animal a = new Animal();
		Animal b = new Dog();//此对象看不到bark方法
		Dog d = new Dog();
		a.move();
		b.move();
		d.bark();
		b.getOne();//执行的还是父类中的方法，不是子类中的
		a.getOne();//执行的是父类中的
	}
	
}
class Animal{
	public void move(){
		System.out.println("动物可以移动");
	}
	public static void getOne(){
		System.out.println("此方法为静态方法");
	}
}
class Dog extends Animal{
	public void move(){
		System.out.println("狗可以跑和走");
	}
	public void bark(){
		System.out.println("狗可以吠叫");
	}
	//虽说能被声明，但是重写是无效的
	public static void getOne(){
		System.out.println("此方法为重写的静态方法，能否执行？");
	}
}

