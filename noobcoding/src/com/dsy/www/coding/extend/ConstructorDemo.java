package com.dsy.www.coding.extend;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 12, 2017 3:05:17 PM
 * @version 1.0
 * @Description: TODO 
 * @parameter
 * @since  
 * @return
 * 1�����಻�ܼ̳и���Ĺ��죬���Ǹ���Ĺ��������в����ģ������������Ĺ���������ʾ��ͨ��super�ؼ��ֵ��ø���Ĺ������������ʵ��Ĳ����б�
 * 2������������޲ι���������������Ĺ���������super���ø��๹�������Ǳ���ģ����û��ʹ��super�ؼ��֣�ϵͳ���Զ����ø�����޲ι�����
 **/
public class ConstructorDemo {
	public static void main(String args[]){
		SubClassAgain  sc = new SubClassAgain();
		SubClassAgain sc2 = new SubClassAgain(200);
	}
}

class SuperClassAgain {
	private int n;
	SuperClassAgain(){
		System.out.println("SuperClass()");
	}
	SuperClassAgain(int n){
		System.out.println("SuperClass(int n)");
		this.n = n;
	}
	
}

class SubClassAgain extends SuperClassAgain{
	private int n;
	SubClassAgain(){
		super(300);
		System.out.println("SubClassAgain()");
	}
	public SubClassAgain(int n){
		System.out.println("SubClassAgain(int n)"+n);
		this.n = n;
	}
	
}

