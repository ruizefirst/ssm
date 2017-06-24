package com.dsy.www.coding.scanner;

import java.util.Scanner;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 11, 2017 9:48:07 AM
 * @version 1.0
 * @Description: TODO Scanner 类的用法
 * @parameter
 * @since  
 * @return
 * 
 * next与nextLine的区别：
 * next()
 * 1、一定要读取到有效字符后才可以结束输入
 * 2、对输入有效字符之前遇到的空白，next()会将其自动去掉
 * 3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符
 * 4、next()不能得到带有空格的字符串
 * nextLine()
 * 1、以Enter为结束符，也就是说nextLine()返回的是输入回车之前的所有字符
 * 2、可以获得空白
 * 
 **/
public class ScannerDemo {
	
	public static void main(String args[]){
		
		/**--------------------------------------------*/
/*		Scanner s = new Scanner(System.in);
		//从键盘接收数据
		
		//next方式接收字符串
		System.out.println("next 方式接收：");
		//判断是否还有输入
		if(s.hasNext()){
			String str1 = s.next();
			System.out.println("输入数据为："+str1);
		}*/
		/**--------------------------------------------*/
		
		/**--------------------------------------------*/
		//nextLine方式接收字符串
	/*	System.out.println("newLine方式接收字符串：");
		//判断是否还有输入
		if(s.hasNextLine()){
			String st2 = s.nextLine();
			System.out.println("输入数据为："+st2);
		}*/
		/**--------------------------------------------*/
		
		//如果要输入 int 或 float 类型的数据，在 Scanner 类中也有支持，但是在输入之前最好先使用 hasNextXxx() 方法进行验证，再使用 nextXxx() 来读取
		/**--------------------------------------------*/
		// 从键盘接收数据  
   /*     int i = 0 ;  
        float f = 0.0f ;  
        System.out.print("输入整数：");  
        if(s.hasNextInt()){                 
      // 判断输入的是否是整数  
            i = s.nextInt() ;                
      // 接收整数  
            System.out.println("整数数据：" + i) ;  
        }else{                                 
      // 输入错误的信息  
            System.out.println("输入的不是整数！") ;  
        }  
        System.out.print("输入小数：");  
        if(s.hasNextFloat()){              
      // 判断输入的是否是小数  
            f = s.nextFloat() ;             
      // 接收小数  
            System.out.println("小数数据：" + f) ;  
        }else{                                
      // 输入错误的信息  
            System.out.println("输入的不是小数！") ;  
        }  */
        /**--------------------------------------------*/
        
        //输入多个数字，并求其总和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果
        /**--------------------------------------------*/
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        int m = 0;
        while(scan.hasNextDouble()){
        	double x = scan.nextDouble();
        	m = m + 1;
        	sum = sum + x;
        }
        System.out.println(m+"个数的和："+sum);
        System.out.println(m+"个数的平均值："+(sum/m));
        /**--------------------------------------------*/ 
	}

}

