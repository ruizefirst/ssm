package com.dsy.www.coding.decorate;
/***
 *final �����ܱ���ʽ�س�ʼ������ֻ�ܳ�ʼ��һ�Ρ�������Ϊ final �Ķ�������ò���ָ��ͬ�Ķ��� 
 *���� final ����������ݿ��Ա��ı䡣Ҳ����˵ final ��������ò��ܸı䣬���������ֵ���Ըı䡣 
 *
 **/

public class FinalDemo {
	final int value = 10;
	public static final int BOXWIDTH= 6;
	static final String TITLE="Manager";
	
	public void changeValue(){
		value = 12;
	}
	//final ���η������˷������ܱ���д
	 final String finalMethod(){
		int finalVar = 1;
		System.out.println("�㲻���޸���:"+finalVar);		
		return "�㲻���޸���:"+finalVar;
	}
}
