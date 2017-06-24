package com.dsy.www.coding.decorate;

/**
 *java�������η���Java֧��4�ֲ�ͬ�ķ���Ȩ�ޡ�
 *Ĭ�ϵģ�Ҳ��Ϊ default����ͬһ���ڿɼ�����ʹ���κ����η���
 *˽�еģ��� private ���η�ָ������ͬһ���ڿɼ���
 *���еģ��� public ���η�ָ������������ɼ���
 *�ܱ����ģ��� protected ���η�ָ������ͬһ���ڵ������������ɼ�
 * 	
 *���η�                 ��ǰ��                  ͬһ����                 ������                 ������
 *public    Y         Y          Y         Y 
 *protected Y         Y          Y         N 
 *default   Y         Y          N         N 
 *private   Y         N          N         ˵N 
 *
 * �ӿ��еı�������ʽ����Ϊ public static final
 * �ӿ���ķ���Ĭ������·��ʵ�Ȩ��Ϊpublic
 * protected �������η�����������ͽӿڣ������ͳ�Ա�����ܹ�����Ϊ protected�����ǽӿڵĳ�Ա�����ͳ�Ա������������Ϊ protected
 * */


/***
 *���ʿ��ƺͼ̳�
 *����������Ϊpublic�ķ����������б���Ϊpublic
 *����������Ϊprotected�ķ�����������Ҫô����Ϊprotected,Ҫô����Ϊpublic,��������Ϊprivate
 *����������Ϊprivate�ķ��������ܹ����̳�
 * */
public class ControlDecorate {
	int k;
	ControlDecorate(){
		System.out.println("-----0");
	};
	//�����
	{
		int i = 0;
		int j = 0;
		k++;
		System.out.println(++i+j+++"=="+k);
	}
	//��̬�����
	static{
		System.out.println("---1");
	}
	public static void main(String args[]){
		//ִ�����ȼ� ����̬�����>�����>���캯��
		new ControlDecorate();
	}
}
class InstanceCounter{
	private static int numInstances = 0;
	protected static int getCount(){
		return numInstances;
	}
	private static void addInstance(){
		numInstances++;
	}
	InstanceCounter(){
		InstanceCounter.addInstance();
	}
	public static void main(String args[]){
		System.out.println("Starting with "+InstanceCounter.getCount()+" instance");
		for(int i=0;i<500;i++){
			new InstanceCounter();
		}
		System.out.println("Created "+InstanceCounter.getCount()+" instances");
		
	}
}
