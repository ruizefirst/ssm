package com.dsy.www.coding.senior.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 14, 2017 10:12:28 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)
 * @parameter
 * @since  
 * @return
 * ʹ��Callable+FutureTask��ȡִ�н��
 **/
public class Test2 {
	 public static void main(String[] args) {
	        //��һ�ַ�ʽ
	        ExecutorService executor = Executors.newCachedThreadPool();
	        Task task = new Task();
	        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
	        executor.submit(futureTask);
	        executor.shutdown();
	          
	        //�ڶ��ַ�ʽ��ע�����ַ�ʽ�͵�һ�ַ�ʽЧ�������Ƶģ�ֻ����һ��ʹ�õ���ExecutorService��һ��ʹ�õ���Thread
	        /*Task task = new Task();
	        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
	        Thread thread = new Thread(futureTask);
	        thread.start();*/
	          
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e1) {
	            e1.printStackTrace();
	        }
	          
	        System.out.println("���߳���ִ������");
	          
	        try {
	            System.out.println("task���н��"+futureTask.get());
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } catch (ExecutionException e) {
	            e.printStackTrace();
	        }
	          
	        System.out.println("��������ִ�����");
	    }
	}
	class Task2 implements Callable<Integer>{
	    public Integer call() throws Exception {
	        System.out.println("���߳��ڽ��м���");
	        Thread.sleep(3000);
	        int sum = 0;
	        for(int i=0;i<100;i++)
	            sum += i;
	        return sum;
	    }
}

