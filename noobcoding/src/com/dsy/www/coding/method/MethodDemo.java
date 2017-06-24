package com.dsy.www.coding.method;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 9, 2017 8:14:58 PM
 * @version 1.0
 * @Description: TODO 
 * @parameter
 * @since  
 * @return
 * 
 **/
public class MethodDemo {
	public static void main(String args[]){
		System.out.println(max(5,18));
		printGrade(90);
	}
	//两个数返回最大的
	public static int max(int num1,int num2){
		int result;
		if(num1>num2)
			result = num1;
		else
			result = num2;
		return result;
	}
	
	public static void printGrade(double score){
		if(score>=90){
			System.out.println("A");
		}else if (score>=80){
			System.out.println("B");
		}else if(score>=70){
			System.out.println("C");
		}else if(score>=60){
			System.out.println("D");
		}else{
			System.out.println("F");
		}
	}

}

