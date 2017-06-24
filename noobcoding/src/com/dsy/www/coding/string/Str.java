package com.dsy.www.coding.string;

import java.io.UnsupportedEncodingException;

/**
 * @author Apollo
 * @date 20170607
 * @description:String
 ***/
public class Str {
	public static void main(String args[]) throws UnsupportedEncodingException{
		String str = "abcder";
		String strObj = new String("abcder");
		char c = str.charAt(2);
		int i = str.compareTo(strObj);
		int j = str.compareTo("abcder");
		int k = str.compareToIgnoreCase("Abcder");
		String concatStr = str.concat("s");
		StringBuffer sb = new StringBuffer("abcder");
		boolean flag = str.contentEquals(sb);
		char[] cc = {'a','b','c','d'};
		String s = str.copyValueOf(cc);
		String ss = str.copyValueOf(cc,1, 3);
		boolean flagOne = str.endsWith("er");
		boolean flagTwo = str.equals(strObj);
		boolean flagThree = str.equalsIgnoreCase("ABcder");
		byte[] bt = str.getBytes();
		byte[] bts = str.getBytes(str);
		char[] dst={'1','2','3','4'};
		str.getChars(1,2, dst, 1);
		int kk = str.hashCode();
		int kkk = str.indexOf("ac");
		int len = str.length();
		String newStr = str.replace("d", "c");
		String nStr = newStr.replace("o","d");
		//太多 不罗列了  参考网址：http://www.runoob.com/java/java-string.html
		
		
	}
}
