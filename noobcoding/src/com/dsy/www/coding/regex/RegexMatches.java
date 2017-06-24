package com.dsy.www.coding.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 9, 2017 3:10:06 PM
 * @version 1.0
 * @Description: TODO正则表达式这部分   没太深入了解
 * @parameter
 * @since  
 * @return
 *深入了解 Pattern 和  Matcher  :http://www.runoob.com/java/java-regular-expressions.html
 **/
public class RegexMatches {
	public static void main(String args[]){
		//按照指定模式在字符串中查找
		String line = "This order was placed for QT3000! ok?";
		String pattern = "(\\D*)(\\d+(.*))";
		//创建Pattern 对象
		Pattern r = Pattern.compile(pattern);
		//现在创建matcher对象
		Matcher m = r.matcher(line);
			if(m.find()){
				System.out.println("Found value:"+m.group(0));
				System.out.println("Found value:"+m.group(1));
				System.out.println("Found value:"+m.group(2));
				System.out.println("Found value:"+m.group(3));
			}else{
				System.out.println("NO MATCH");
			}
		}

}

