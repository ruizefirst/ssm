package com.dsy.www.coding.senior.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;



/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 14, 2017 9:48:13 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)
 * @parameter
 * @since  
 * @return
 * 
 **/
/*1. ���� Callable �ӿڵ�ʵ���࣬��ʵ�� call() �������� call() ��������Ϊ�߳�ִ���壬�����з���ֵ��


2. ���� Callable ʵ�����ʵ����ʹ�� FutureTask ������װ Callable ���󣬸� FutureTask �����װ�˸� Callable ����� call() �����ķ���ֵ��


3. ʹ�� FutureTask ������Ϊ Thread ����� target �������������̡߳�


4. ���� FutureTask ����� get() ������������߳�ִ�н�����ķ���ֵ��*/


public class CallableThreadTest implements Callable<Integer>{
	 public static void main(String[] args)  
	    {  
	        CallableThreadTest ctt = new CallableThreadTest();  
	        FutureTask<Integer> ft = new FutureTask<Integer>(ctt);  
	        for(int i = 0;i < 100;i++)  
	        {  
	            System.out.println(Thread.currentThread().getName()+" ��ѭ������i��ֵ"+i);  
	            if(i==20)  
	            {  
	                new Thread(ft,"�з���ֵ���߳�").start();  
	            }  
	        }  
	        try  
	        {  
	            System.out.println("���̵߳ķ���ֵ��"+ft.get());  
	        } catch (InterruptedException e)  
	        {  
	            e.printStackTrace();  
	        } catch (ExecutionException e)  
	        {  
	            e.printStackTrace();  
	        }  
	  
	    }
	    public Integer call() throws Exception  
	    {  
	        int i = 0;  
	        for(;i<100;i++)  
	        {  
	            System.out.println(Thread.currentThread().getName()+" "+i);  
	        }  
	        return i;  
	    }  

}

