package com.dsy.www.coding.senior.multithread;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 14, 2017 9:17:23 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)   ʵ��Runnable�ӿڴ����̲߳�����ִ��
 * @parameter
 * @since  
 * @return
 * 
 **/
public class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;
	
	RunnableDemo(String name){
		threadName = name;
		System.out.println("Creating "+threadName);
	}
	
	public void run(){
		System.out.println("Runing "+threadName);
		
		for(int i = 4 ;i > 0 ;i--){
			System.out.println("Thread:"+threadName+","+i);
			//���߳�˯��һ���
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("Thread "+threadName+"interrupted.");
				e.printStackTrace();
			}
		}
		System.out.println("Thread "+threadName+" exiting.");
	}
	
	public void start(){
		System.out.println("Starting "+threadName);
		if(t==null){
			t = new Thread(this,threadName);
			t.start();
		}
		
	}
	
	public static void main(String args[]){
		RunnableDemo R1 = new RunnableDemo("Thread-1");
		R1.start();
		RunnableDemo R2 = new RunnableDemo("Thread-2");
		R2.start();
	}
}

