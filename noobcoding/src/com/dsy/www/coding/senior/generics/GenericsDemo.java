package com.dsy.www.coding.senior.generics;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 1:49:31 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  泛型
 * @parameter
 * @since  
 * @return
 * 
 **/
public class GenericsDemo {
	public static void main(String args[]){
		
	}
}

class GenericMethodTest{
	public static void main(String args[]){
		//创建不同类型的数组
		Integer[] intArray ={1,2,3,4,5};
		Double[] doubleArray = {1.1,2.2,3.3,4.4};
		Character[] charArray = {'H','E','L','L','O'};
		
		System.out.println("整形数组元素为：");
		printArray(intArray);
		
		System.out.println("\n双精度数组元素为：");
		printArray(doubleArray);
		
		System.out.println("\n字符型数组元素为：");
		printArray(charArray);
	}
	//泛型本质是参数化类型，放在方法返回类型前
	public static <E> void printArray(E[] inputArray){
		//输出数组元素
		for(E element:inputArray){
			System.out.printf("%s",element);
		}
		System.out.println();
	}
}

