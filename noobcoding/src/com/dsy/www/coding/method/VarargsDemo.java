package com.dsy.www.coding.method;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 10, 2017 9:54:42 AM
 * @version 1.0
 * @Description: TODO JDK 1.5 开始，Java支持传递同类型的可变参数给一个方法。
 * @parameter
 * @since  
 * @return
 * 
 **/
public class VarargsDemo {
	public static void main(String args[]){
		//调用可变参数的方法
		printMax(34,3,3,2,56.5);
		printMax(new double[]{1,2,3});
	}
	public static void printMax(double... numbers){
		if(numbers.length==0){
			System.out.println("No arguments passed");
			return ;
		}
		double result = numbers[0];
		for(int i = 0 ;i < numbers.length; i++){
			if(numbers[i] > result){
				result = numbers[i];
			}
		}
		System.out.println("The max values is "+result);
	}
	

}

