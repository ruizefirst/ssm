package com.dsy.www.coding.classvar;
/**
 * ���ڴ�Demo:
 * һ����̬����Ҳ���������һ��ʵ������
 * ��̬����/����� �����ܴ������ٸ����󣬾�̬����/�����ֻ��һ�ݶ� �������
 * ʵ��������ÿ�δ������󶼻����һ��random
 * 
 * ������Ϊ��3 3  
 *         4 3
 *         
 *         
 *ע��ʵ���������������ڲ����ǿɷ��ʵģ�������ʵ����������������ĸ�λ�ü�ʹ�����β��Ҳ����ν
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
