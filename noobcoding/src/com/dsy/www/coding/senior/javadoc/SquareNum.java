package com.dsy.www.coding.senior.javadoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 14, 2017 10:21:46 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  注释及javadoc工具的使用   
 * @parameter
 * @since  
 * @return
 * 使用此工具前，必须先了解javadoc的标签含义：http://www.runoob.com/java/java-documentation.html
 **/
public class SquareNum {
	 /**
	   * This method returns the square of num.
	   * This is a multiline description. You can use
	   * as many lines as you like.
	   * @param num The value to be squared.
	   * @return num squared.
	   */
	   public double square(double num) {
	      return num * num;
	   }
	   /**
	   * This method inputs a number from the user.
	   * @return The value input as a double.
	   * @exception IOException On input error.
	   * @see IOException
	   */
	   public double getNumber() throws IOException {
	      InputStreamReader isr = new InputStreamReader(System.in);
	      BufferedReader inData = new BufferedReader(isr);
	      String str;
	      str = inData.readLine();
	      return (new Double(str)).doubleValue();
	   }
	   /**
	   * This method demonstrates square().
	   * @param args Unused.
	   * @return Nothing.
	   * @exception IOException On input error.
	   * @see IOException
	   */
	   public static void main(String args[]) throws IOException
	   {
	      SquareNum ob = new SquareNum();
	      double val;
	      System.out.println("Enter value to be squared: ");
	      val = ob.getNumber();
	      val = ob.square(val);
	      System.out.println("Squared value is " + val);
	   }
}

