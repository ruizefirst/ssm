package com.dsy.www.coding.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 9, 2017 3:10:06 PM
 * @version 1.0
 * @Description: TODO������ʽ�ⲿ��   û̫�����˽�
 * @parameter
 * @since  
 * @return
 *�����˽� Pattern ��  Matcher  :http://www.runoob.com/java/java-regular-expressions.html
 **/
public class RegexMatches {
	public static void main(String args[]){
		//����ָ��ģʽ���ַ����в���
		String line = "This order was placed for QT3000! ok?";
		String pattern = "(\\D*)(\\d+(.*))";
		//����Pattern ����
		Pattern r = Pattern.compile(pattern);
		//���ڴ���matcher����
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

