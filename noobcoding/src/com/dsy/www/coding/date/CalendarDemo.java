package com.dsy.www.coding.date;

import java.util.Calendar;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 9, 2017 1:38:46 AM
 * @version 1.0
 * @Description: TODO Calendar类：我们如何才能设置和获取日期数据的特定部分呢，比如说小时，日，或者分钟? 我们又如何在日期的这些部分加上或者减去值呢? 答案是使用Calendar 类
 * @parameter
 * @since  
 * @return
 * 
 **/
public class CalendarDemo {
	
	public static void main(String args[]){
		Calendar c = Calendar.getInstance();
		//创建一个代表2009年6月12日的Calendar对象
		c.set(2009, 6 - 1, 12);
		
		
		
		System.out.println("---------------分割线---------------");
		Calendar c1 = Calendar.getInstance();
		// 获得年份
		int year = c1.get(Calendar.YEAR);
		// 获得月份
		int month = c1.get(Calendar.MONTH) + 1;
		// 获得日期
		int date = c1.get(Calendar.DATE);
		// 获得小时
		int hour = c1.get(Calendar.HOUR_OF_DAY);
		// 获得分钟
		int minute = c1.get(Calendar.MINUTE);
		// 获得秒
		int second = c1.get(Calendar.SECOND);
		// 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
		int day = c1.get(Calendar.DAY_OF_WEEK);
		
	}

}

