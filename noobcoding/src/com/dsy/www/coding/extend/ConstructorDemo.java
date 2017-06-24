package com.dsy.www.coding.extend;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 12, 2017 3:05:17 PM
 * @version 1.0
 * @Description: TODO 
 * @parameter
 * @since  
 * @return
 * 1、子类不能继承父类的构造，但是父类的构造器带有参数的，则必须在子类的构造器中显示的通过super关键字调用父类的构造器并配以适当的参数列表
 * 2、如果父类有无参构造器，则在子类的构造器中用super调用父类构造器不是必须的，如果没有使用super关键字，系统会自动调用父类的无参构造器
 **/
public class ConstructorDemo {
	public static void main(String args[]){
		SubClassAgain  sc = new SubClassAgain();
		SubClassAgain sc2 = new SubClassAgain(200);
	}
}

class SuperClassAgain {
	private int n;
	SuperClassAgain(){
		System.out.println("SuperClass()");
	}
	SuperClassAgain(int n){
		System.out.println("SuperClass(int n)");
		this.n = n;
	}
	
}

class SubClassAgain extends SuperClassAgain{
	private int n;
	SubClassAgain(){
		super(300);
		System.out.println("SubClassAgain()");
	}
	public SubClassAgain(int n){
		System.out.println("SubClassAgain(int n)"+n);
		this.n = n;
	}
	
}

