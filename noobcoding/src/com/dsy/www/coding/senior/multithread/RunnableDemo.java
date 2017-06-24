package com.dsy.www.coding.senior.multithread;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 14, 2017 9:17:23 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)   实现Runnable接口创建线程并让其执行
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
			//让线程睡眠一会儿
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

