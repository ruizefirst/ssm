package com.dsy.www.coding.method;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 10, 2017 9:54:42 AM
 * @version 1.0
 * @Description: TODO JDK 1.5 ��ʼ��Java֧�ִ���ͬ���͵Ŀɱ������һ��������
 * @parameter
 * @since  
 * @return
 * 
 **/
public class VarargsDemo {
	public static void main(String args[]){
		//���ÿɱ�����ķ���
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

