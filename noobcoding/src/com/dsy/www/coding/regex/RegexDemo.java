package com.dsy.www.coding.regex;

import java.util.regex.Pattern;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 9, 2017 7:57:12 AM
 * @version 1.0
 * @Description: TODO  ������ʽ���÷�
 * @parameter
 * @since  
 * @return
 * Pattern �ࣺpattern ������һ��������ʽ�ı����ʾ��Pattern ��û�й������췽����Ҫ����һ�� Pattern ������������ȵ����乫����̬���뷽����������һ�� Pattern ���󡣸÷�������һ��������ʽ��Ϊ���ĵ�һ��������
 * Matcher �ࣺMatcher �����Ƕ������ַ������н��ͺ�ƥ����������档��Pattern ��һ����Matcher Ҳû�й������췽��������Ҫ���� Pattern ����� matcher ���������һ�� Matcher ����
 * PatternSyntaxException��PatternSyntaxException ��һ����ǿ���쳣�࣬����ʾһ��������ʽģʽ�е��﷨����
 **/
public class RegexDemo {
	public static void main(String args[]){
		String content = "I am noob "+"from runoob.com.";
		String pattern = ".*runoob.*";
		boolean isMatch = Pattern.matches(pattern,content);
		System.out.println("�ַ������Ƿ������ 'runoob' ���ַ�����"+isMatch);
	}

}

