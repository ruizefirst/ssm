package com.dsy.www.coding.senior.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 14, 2017 10:11:38 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @parameter
 * @since  
 * @return
 * 使用Callable+Future获取执行结果
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
	          
	        System.out.println("主线程在执行任务");
	          
	        try {
	            System.out.println("task运行结果"+result.get());
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } catch (ExecutionException e) {
	            e.printStackTrace();
	        }
	          
	        System.out.println("所有任务执行完毕");
	    }
	}
	class Task implements Callable<Integer>{
	    public Integer call() throws Exception {
	        System.out.println("子线程在进行计算");
	        Thread.sleep(3000);
	        int sum = 0;
	        for(int i=0;i<100;i++)
	            sum += i;
	        return sum;
	    }

}

