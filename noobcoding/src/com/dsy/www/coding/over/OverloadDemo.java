package com.dsy.www.coding.over;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 12, 2017 4:46:24 PM
 * @version 1.0
 * @Description: TODO  重载
 * @parameter
 * @since  
 * @return
 * 方法的重写（override）和重载（overload）是java多态性的不同表现，重写是父类与子类之间多态性的一种表现，重载可以理解成多台的具体表现形式
 * 重写和重载的区别：
 * 区别点                               重载方法                              重写方法
 * 参数列表                           必须修改                              一定不能修改
 * 返回类型                           可以修改                              一定不能修改
 * 异常                                   可以修改                              可以减少或删除，一定不能抛出新的或者更广的异常
 * 访问                                   可以修改                               一定不能做更严格的限制（可以降低限制）
 * 
 * 重载是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同
 * 每个重载的方法都必须有一个独一无二的参数类型列表
 * 最常用的地方就是构造方法的重载
 * 
 * 重载的规则：
 * 1、被重载的方法必须改变参数列表（参数个数或类型或顺序不一样）
 * 2、被重载的方法可以改变返回类型
 * 3、被重载的方法可以修改访问修饰符
 * 4、被重载的方法可以声明新的或更广的检查异常
 * 5、方法能够在同一个类中或者在一个子类中被重载                                        理解的不能了
 * 6、返回类型不能作为重载的依据
 * 
 **/
public class OverloadDemo {
	public int test(){
		System.out.println("test1");
		return 	1;
	}
	public void test(int a){
		System.out.println("test2");
	}
	//以下两个方法参数类型顺序不同
	public String test(int a,String s){
		System.out.println("test3");
		return "returntest3";
	}
	public String test(String s,int a){
		System.out.println("test4");
		return "retruntest4";
	}
/*	public void test(String s,int a){
		System.out.println("test4");
		return "retruntest4";
	}*///返回类型不能作为重载的依据
	public static void main(String args[]){
		OverloadDemo old = new OverloadDemo();
		System.out.println(old.test());
		old.test(1);
		System.out.println(old.test(1, "test3"));
		System.out.println(old.test("test4", 1));
	}
}

