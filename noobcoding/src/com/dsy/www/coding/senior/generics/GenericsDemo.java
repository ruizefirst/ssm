package com.dsy.www.coding.senior.generics;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 13, 2017 1:49:31 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  ����
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
		//������ͬ���͵�����
		Integer[] intArray ={1,2,3,4,5};
		Double[] doubleArray = {1.1,2.2,3.3,4.4};
		Character[] charArray = {'H','E','L','L','O'};
		
		System.out.println("��������Ԫ��Ϊ��");
		printArray(intArray);
		
		System.out.println("\n˫��������Ԫ��Ϊ��");
		printArray(doubleArray);
		
		System.out.println("\n�ַ�������Ԫ��Ϊ��");
		printArray(charArray);
	}
	//���ͱ����ǲ��������ͣ����ڷ�����������ǰ
	public static <E> void printArray(E[] inputArray){
		//�������Ԫ��
		for(E element:inputArray){
			System.out.printf("%s",element);
		}
		System.out.println();
	}
}

