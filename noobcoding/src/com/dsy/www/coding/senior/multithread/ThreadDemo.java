package com.dsy.www.coding.senior.multithread;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 14, 2017 9:29:48 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用) 通过继承Thread类创建线程
 * @parameter
 * @since  
 * @return
 * 线程的一些方法：http://www.runoob.com/java/java-multithreading.html
 * 
 * 创建线程的三种方式的对比
 * 1. 采用实现 Runnable、Callable 接口的方式创见多线程时，线程类只是实现了 Runnable 接口或 Callable 接口，还可以继承其他类。
 * 2. 使用继承 Thread 类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 即可获得当前线程。
 * 
 * 
 * 线程的几个主要概念 :
 * 线程同步
 * 线程间通信
 * 线程死锁
 * 线程控制：挂起、停止和恢复
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
			 //让线程睡一会儿
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

