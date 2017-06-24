package com.dsy.www.coding.classvar;
/**
 * 对于此Demo:
 * 一个静态变量也叫类变量，一个实例变量
 * 静态变量/类变量 ：不管创建多少个对象，静态变量/类变量只有一份儿 ，共享的
 * 实例变量：每次创建对象都会分配一个random
 * 
 * 输出结果为：3 3  
 *         4 3
 *         
 *         
 *注：实例变量在整个类内部都是可访问的，而不管实例变量声明在类的哪个位置即使是类的尾部也无所谓
 * */
public class VarDemo {
	private static int staticInt = 2;
	private int random = 2;
	
	public VarDemo(){
		staticInt++;
		random++;
		System.out.println("staticInt:"+staticInt+"random:"+random);
	}
	
	public static void main(String args[]){
		 VarDemo vd1 = new VarDemo();
		 VarDemo vd2 = new VarDemo();
	}

}
