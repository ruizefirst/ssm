package com.dsy.www.coding.decorate;
/**
 * synchronized ���η���synchronized�ؼ��������ķ���ͬһʱ��ֻ�ܱ�һ���̷߳��ʡ�synchronized���η�����Ӧ�����ĸ��������η���
 * 
 * 
 * */
public class Other {
	/**synchronized public/private/protected/friendly(default)*/
	public synchronized void showDeatils(){
		System.out.println("�˷���ͬһʱ��ֻ�ܱ�һ���̷߳���");
	}
	
	/**transient���η�����transient���εĶ���ͱ��������ᱻ��������л�*/
	public transient int limit = 5;// �����־û�
	public int b;//�־û�
	
}


/***
 * ͨ������£���һ���̵߳��� run() �������� Runnable �������̣߳�������һ���̵߳��� stop() ������ ��� ��һ�� �л������� active ֵ��ʹ�ã���ô�� �ڶ��� �� active ֵΪ false ʱѭ������ֹͣ�� 
 * �������ϴ���������ʹ���� volatile ���� active�����Ը�ѭ����ֹͣ��
 * (��Ҫ�����˽⡤����������)
 * */
class MyRunnable implements Runnable{
	private volatile boolean active;
	public void run(){
		active = true;
		while(active){//��һ��
			//����
		}
	}
	public void stop(){
		active = false;//�ڶ���
	}
}
