package com.dsy.www.coding.classvar;

public class LocalVarInit {
	//age��һ���ֲ�������������pupAge()�����У���������������������������
	public void pupAge(){
		int age = 0; //�ֲ�����û��Ĭ��ֵ  �����󣬱����ʼ������ʹ��
		age = age+7;
		System.out.println("С���������ǣ�"+age);
	}
	public static void main(String args[]){
		LocalVarInit lv = new LocalVarInit();
		lv.pupAge();
	}

}
