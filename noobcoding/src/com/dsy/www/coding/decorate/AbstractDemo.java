package com.dsy.www.coding.decorate;
/**
 * ���󷽷���һ��û���κ�ʵ�ֵķ������÷����ľ���ʵ�����������ṩ
 * ���󷽷����ܱ�����Ϊfinal��static
 * �κμ̳г�������������ʵ�ָ�������г��󷽷������Ǹ���Ҳ�ǳ����ࡣ
 * ���һ�������ɸ����󷽷�����ô�����������Ϊ�����ࡣ�����಻�������󷽷���
 * ���󷽷��������ԷֺŽ�β��
 * */
public abstract class  AbstractDemo {
	//�����಻��ʵ����Ҳ����˵������new����ʵ����ֻ���������̳�
	abstract void m();
	public static void main(String args[]){
		new SubClass().m();
	}
}
class SubClass extends AbstractDemo{
	@Override
	void m() {
		// TODO Auto-generated method stub
		System.out.println("����·����·~~~~~");
	}
}
