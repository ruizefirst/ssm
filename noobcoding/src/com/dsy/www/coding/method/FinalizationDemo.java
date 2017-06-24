package com.dsy.www.coding.method;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 10, 2017 10:30:11 AM
 * @version 1.0
 * @Description: TODO Java �����������ķ��������ڶ��������ռ�������(����)֮ǰ���ã������������ finalize( )��������������ն���
 * @parameter
 * @since  
 * @return
 *   ���췽��ע�����
 *   1�����췽��������������������ͬ�����޷�������   void�������Լӣ����ϾͲ��й��췽��
 *   2��ÿ���඼��һ��Ĭ�Ϲ��췽��
 *   3��һ���㶨�����Լ��Ĺ��췽����Ĭ�Ϲ��췽����ʧЧ
 **/
public class FinalizationDemo {
	
	public static void main(String args[]){
		Cake c1= new Cake(1);
		Cake c2= new Cake(2);
		Cake c3= new Cake(3);
		c2 = c3 = null;
		System.gc();//����java�����ռ���
	}
}

class Cake extends Object{
	private int id;
	
	public Cake(int id){
		this.id = id;
		System.out.println("Cake Object "+ id + "is created");
	}
	
	protected void finalize()throws java.lang.Throwable{
		super.finalize();//Object�з�������������ǰ������һЩ������    �������յ���System.gc();
		System.out.println("Cake Object "+ id +"is disposed");
	}
}

