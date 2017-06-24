package com.dsy.www.coding.senior.generics;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 13, 2017 2:28:43 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)����ͨ���
 * @parameter
 * @since  
 * @return
 * 1������ͨ���һ����ʹ��?�����������Ͳ��������� List<?> ���߼�����List<String>,List<Integer> ������List<��������ʵ��>�ĸ��ࡣ 
 * 2������ͨ�������ͨ������List<? extends Number>�����壬��˶������ͨ�������ֵ����Number�����²��������͡�
 * 3������ͨ�������ͨ������ List<? super Number>�����壬��ʾ����ֻ�ܽ���Number�������㸸�����ͣ���Objec���͵�ʵ����
 * 
 * <? extends T>��ʾ��ͨ����������������T���͵����ࡣ
 * <? super T>��ʾ��ͨ����������������T���͵ĸ��ࡣ
 **/
public class GenericsTest {
	public static void main(String args[]){
		List<String> name = new ArrayList<String>();
		List<Integer> age = new ArrayList<Integer>();
		List<Number>  number = new ArrayList<Number>();
		name.add("icon");
		age.add(18);
		number.add(314);
		
	}
	
	public static void getData(List<?> data){
		System.out.println("data:"+data.get(0)); 
	}
	
	public static void getData1(List<? extends Number> data){
		System.out.println("data:"+data.get(0));
	}

}

