package com.dsy.www.coding.senior.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 14, 2017 10:11:38 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)
 * @parameter
 * @since  
 * @return
 * ʹ��Callable+Future��ȡִ�н��
 **/
public class Test1 {
	 public static void main(String[] args) {
	        ExecutorService executor = Executors.newCachedThreadPool();
	        Task task = new Task();
	        Future<Integer> result = executor.submit(task);
	        executor.shutdown();
	          
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e1) {
	            e1.printStackTrace();
	        }
	          
	        System.out.println("���߳���ִ������");
	          
	        try {
	            System.out.println("task���н��"+result.get());
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } catch (ExecutionException e) {
	            e.printStackTrace();
	        }
	          
	        System.out.println("��������ִ�����");
	    }
	}
	class Task implements Callable<Integer>{
	    public Integer call() throws Exception {
	        System.out.println("���߳��ڽ��м���");
	        Thread.sleep(3000);
	        int sum = 0;
	        for(int i=0;i<100;i++)
	            sum += i;
	        return sum;
	    }

}

