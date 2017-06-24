package com.dsy.www.coding.method;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 10, 2017 10:30:11 AM
 * @version 1.0
 * @Description: TODO Java 允许定义这样的方法，它在对象被垃圾收集器析构(回收)之前调用，这个方法叫做 finalize( )，它用来清除回收对象。
 * @parameter
 * @since  
 * @return
 *   构造方法注意事项：
 *   1、构造方法名称与所在类名称相同，且无返回类型   void都不可以加，加上就不叫构造方法
 *   2、每个类都有一个默认构造方法
 *   3、一旦你定义了自己的构造方法，默认构造方法就失效
 **/
public class FinalizationDemo {
	
	public static void main(String args[]){
		Cake c1= new Cake(1);
		Cake c2= new Cake(2);
		Cake c3= new Cake(3);
		c2 = c3 = null;
		System.gc();//调用java垃圾收集器
	}
}

class Cake extends Object{
	private int id;
	
	public Cake(int id){
		this.id = id;
		System.out.println("Cake Object "+ id + "is created");
	}
	
	protected void finalize()throws java.lang.Throwable{
		super.finalize();//Object中方法，垃圾回收前调用做一些清理工作    垃圾回收调用System.gc();
		System.out.println("Cake Object "+ id +"is disposed");
	}
}

