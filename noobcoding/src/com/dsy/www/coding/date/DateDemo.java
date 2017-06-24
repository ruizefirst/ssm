package com.dsy.www.coding.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 8, 2017 9:06:46 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @parameter
 * @since  
 * @return
 * 
 **/
public class DateDemo {
	public static void main(String args[]){
		Date d = new Date();
		Date t = (Date) d.clone();
		System.out.println(t);
		
		int bo  = d.compareTo(t);
		boolean bt = d.after(t);
		boolean bb = d.before(t);
		Long lon =t.getTime();
		int ct = d.hashCode();
		String stt = d.toString();
		System.out.println(d+"---"+t+"---");
		System.out.println(bo+"--"+bt+"--"+bb+"--"+lon+"--"+ct+"--"+stt+"--");
		
		//比较两个日期  三种方法
		//使用getTime()方法获取两个日期(自1970年1月1日经历的毫秒数值),然后比较这两个值
		//使用方法before(),after()和equals()。例如：一个月的12号比18号早，则new Date(99,2,12).before(new Date(99,2,18))返回true
		//使用compareTo()方法，它是由Comparable接口定义的，Date类实现了这个接口
		
		
		//SimpleDateFormat 允许你选择任何用户定义的日期格式来运行。
		Date dNow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("Current Date:"+sdf.format(dNow));
		
		System.out.println("--------------我是分割线-----------------");
		
		 // 初始化 Date 对象
	     Date date = new Date();
	     //c的使用  
	    System.out.printf("全部日期和时间信息：%tc%n",date);          
	    //f的使用  
	    System.out.printf("年-月-日格式：%tF%n",date);  
	    //d的使用  
	    System.out.printf("月/日/年格式：%tD%n",date);  
	    //r的使用  
	    System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);  
	    //t的使用  
	    System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);  
	    //R的使用  
	    System.out.printf("HH:MM格式（24时制）：%tR",date);  
	    
	    System.out.println("-----------------我是分割线-------------------");
	    Date dateD=new Date();                                      
        //b的使用，月份简称  
        String str=String.format(Locale.US,"英文月份简称：%tb",dateD);       
        System.out.println(str);                                                                              
        System.out.printf("本地月份简称：%tb%n",dateD);  
        //B的使用，月份全称  
        str=String.format(Locale.US,"英文月份全称：%tB",dateD);  
        System.out.println(str);  
        System.out.printf("本地月份全称：%tB%n",dateD);  
        //a的使用，星期简称  
        str=String.format(Locale.US,"英文星期的简称：%ta",dateD);  
        System.out.println(str);  
        //A的使用，星期全称  
        System.out.printf("本地星期的简称：%tA%n",dateD);  
        //C的使用，年前两位  
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",dateD);  
        //y的使用，年后两位  
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",dateD);  
        //j的使用，一年的天数  
        System.out.printf("一年中的天数（即年的第几天）：%tj%n",dateD);  
        //m的使用，月份  
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",dateD);  
        //d的使用，日（二位，不够补零）  
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n",dateD);  
        //e的使用，日（一位不补零）  
        System.out.printf("月份的日（前面不补0）：%te",dateD);  

		
	    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	    String input = args.length==0?"1818-11-11":args[0];
	    System.out.println(input+"Parses as ");
	    Date dd;
	    try{
	    	dd = sd.parse(input);
	    	System.out.println(dd);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    
	}

}

