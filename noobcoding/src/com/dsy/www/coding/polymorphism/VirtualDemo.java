package com.dsy.www.coding.polymorphism;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 12, 2017 10:59:06 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  测试虚方法
 * @parameter
 * @since  
 * @return
 * 
 **/
public class VirtualDemo {
	public static void main(String args[]){
		Salary salary = new Salary("员工 A", "北京", 3,3600.00);
		Employee employee = new Salary("员工B","北京",2,2400);
		System.out.println("使用Salary的引用调用mailCheck--");
		salary.mailCheck();
		System.out.println("\n使用Employee的引用调用mailCheck--");
		employee.mailCheck();
	}

}

