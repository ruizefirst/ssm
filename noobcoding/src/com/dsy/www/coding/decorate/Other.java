package com.dsy.www.coding.decorate;
/**
 * synchronized 修饰符：synchronized关键字声明的方法同一时间只能被一个线程访问。synchronized修饰符可以应用于四个访问修饰符。
 * 
 * 
 * */
public class Other {
	/**synchronized public/private/protected/friendly(default)*/
	public synchronized void showDeatils(){
		System.out.println("此方法同一时间只能被一个线程访问");
	}
	
	/**transient修饰符：由transient修饰的对象和变量将不会被虚拟机序列化*/
	public transient int limit = 5;// 不被持久化
	public int b;//持久化
	
}


/***
 * 通常情况下，在一个线程调用 run() 方法（在 Runnable 开启的线程），在另一个线程调用 stop() 方法。 如果 第一行 中缓冲区的 active 值被使用，那么在 第二行 的 active 值为 false 时循环不会停止。 
 * 但是以上代码中我们使用了 volatile 修饰 active，所以该循环会停止。
 * (需要深入了解······)
 * */
class MyRunnable implements Runnable{
	private volatile boolean active;
	public void run(){
		active = true;
		while(active){//第一行
			//代码
		}
	}
	public void stop(){
		active = false;//第二行
	}
}
