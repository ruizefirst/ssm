package com.dsy.www.coding.over;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 12, 2017 4:46:24 PM
 * @version 1.0
 * @Description: TODO  ����
 * @parameter
 * @since  
 * @return
 * ��������д��override�������أ�overload����java��̬�ԵĲ�ͬ���֣���д�Ǹ���������֮���̬�Ե�һ�ֱ��֣����ؿ������ɶ�̨�ľ��������ʽ
 * ��д�����ص�����
 * �����                               ���ط���                              ��д����
 * �����б�                           �����޸�                              һ�������޸�
 * ��������                           �����޸�                              һ�������޸�
 * �쳣                                   �����޸�                              ���Լ��ٻ�ɾ����һ�������׳��µĻ��߸�����쳣
 * ����                                   �����޸�                               һ�����������ϸ�����ƣ����Խ������ƣ�
 * 
 * ��������һ�������棬����������ͬ����������ͬ���������Ϳ�����ͬҲ���Բ�ͬ
 * ÿ�����صķ�����������һ����һ�޶��Ĳ��������б�
 * ��õĵط����ǹ��췽��������
 * 
 * ���صĹ���
 * 1�������صķ�������ı�����б��������������ͻ�˳��һ����
 * 2�������صķ������Ըı䷵������
 * 3�������صķ��������޸ķ������η�
 * 4�������صķ������������µĻ����ļ���쳣
 * 5�������ܹ���ͬһ�����л�����һ�������б�����                                        ���Ĳ�����
 * 6���������Ͳ�����Ϊ���ص�����
 * 
 **/
public class OverloadDemo {
	public int test(){
		System.out.println("test1");
		return 	1;
	}
	public void test(int a){
		System.out.println("test2");
	}
	//��������������������˳��ͬ
	public String test(int a,String s){
		System.out.println("test3");
		return "returntest3";
	}
	public String test(String s,int a){
		System.out.println("test4");
		return "retruntest4";
	}
/*	public void test(String s,int a){
		System.out.println("test4");
		return "retruntest4";
	}*///�������Ͳ�����Ϊ���ص�����
	public static void main(String args[]){
		OverloadDemo old = new OverloadDemo();
		System.out.println(old.test());
		old.test(1);
		System.out.println(old.test(1, "test3"));
		System.out.println(old.test("test4", 1));
	}
}

