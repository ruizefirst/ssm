package com.dsy.www.coding.decorate;

public class FinalDemoChild extends FinalDemo{
	/* String finalMethod(){
		 System.out.println("��д�����еķ���");
		 return "1";
	}*/
	/**
	 * final�������Ա�����̳У������ܱ������޸�
	 * final�಻�ܱ��̳�
	 * 
	 * this�ؼ��ֱ�����ڷǾ�̬��������
	 * this�ؼ��ִ��������ڳ�������Ҫ��ʹ����;�����¼������棺
 	 * ʹ��this�ؼ������ó�Ա����
 	 * ʹ��this�ؼ����������췽���ڲ������������췽��
 	 * ʹ��this�ؼ��ִ���������Ķ���
	 * ʹ��this�ؼ������ó�Ա����
	 * 
	 * */
	public void getThis(){
		this.finalMethod();
	}
	public FinalDemoChild(String name){
		System.out.println("�������Ĺ���");
	}
	public FinalDemoChild(){
		System.out.println(this.finalMethod()+"who");
		System.out.println(super.finalMethod()+"where");
	}
	public static void main(String args[]){
		new FinalDemoChild().finalMethod();
	
	}
}
