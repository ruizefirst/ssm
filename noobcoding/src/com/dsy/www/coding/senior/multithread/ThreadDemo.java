package com.dsy.www.coding.senior.multithread;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 14, 2017 9:29:48 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������) ͨ���̳�Thread�ഴ���߳�
 * @parameter
 * @since  
 * @return
 * �̵߳�һЩ������http://www.runoob.com/java/java-multithreading.html
 * 
 * �����̵߳����ַ�ʽ�ĶԱ�
 * 1. ����ʵ�� Runnable��Callable �ӿڵķ�ʽ�������߳�ʱ���߳���ֻ��ʵ���� Runnable �ӿڻ� Callable �ӿڣ������Լ̳������ࡣ
 * 2. ʹ�ü̳� Thread ��ķ�ʽ�������߳�ʱ����д�򵥣������Ҫ���ʵ�ǰ�̣߳�������ʹ�� Thread.currentThread() ������ֱ��ʹ�� this ���ɻ�õ�ǰ�̡߳�
 * 
 * 
 * �̵߳ļ�����Ҫ���� :
 * �߳�ͬ��
 * �̼߳�ͨ��
 * �߳�����
 * �߳̿��ƣ�����ֹͣ�ͻָ�
 **/

public class ThreadDemo extends Thread{
	 private Thread t;
	 private String threadName;
	 
	 ThreadDemo(String name){
		 threadName = name;
		 System.out.println("Creating "+threadName);
	 }
	 
	 public void run(){
		 System.out.println("Running "+threadName);
		 for(int i = 4;i>0;i--){
			 System.out.println("Thread:"+threadName+","+i);
			 //���߳�˯һ���
			 try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("Thread "+threadName+" interrupted.");
				e.printStackTrace();
			}
		 }
		 System.out.println("Thread "+threadName+" exiting.");
	 }
	 
	 public void start(){
		 System.out.println("Starting "+threadName);
		 if(t == null){
			 t = new Thread(this,threadName);
			 t.start();
		 }
	 }
	 
	 public static void main(String args[]){
		 ThreadDemo t1 = new ThreadDemo("Thread--1");
		 t1.start();
		 
		 ThreadDemo t2 = new ThreadDemo("Thread--2");
		 t2.start();
	 }
	 
}

