package com.dsy.www.coding.stringbuffer;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 8, 2017 2:09:10 PM
 * @version 1.0
 * @Description: 当对字符串进行修改的时候，需要使用StringBuffer和StringBuilder
 * @parameter
 * @since  
 * @return
 * 
 **/
public class StringBufferDemo {
	
	public void stringBufferMethods(){
		StringBuffer st = new StringBuffer("StringBuffer的所有方法：");
		st.append("\n换行效果");
		System.out.println(st);
		
		StringBuffer st1 = new StringBuffer("family全家");
		st1.reverse();//字符串反转的好方法
		System.out.println(st1);
		
		st1.delete(1,2); //索引从零开始  删除索引位置在1和2之间的字符
		System.out.println(st1);
		
		st1.insert(1, 2);
		System.out.println(st1);
		
		st1.replace(2, 3, "123");
		System.out.println(st1);
		
		System.out.println("--------------分割线-------------");
		
		int k = st1.capacity();
		System.out.println("当前容量："+k);
		
		char c = st1.charAt(2);
		System.out.println("返回索引位置为2的字符"+c);
		
		st1.ensureCapacity(Integer.MIN_VALUE);//确保容量至少等于指定的最小值
		char[] cha = new char[6];
		st1.getChars(0,5,cha, 0);
		System.out.println(cha.toString());
		
		st1.setCharAt(2,'2');
		System.out.println("将2放置在字符串你的第二位："+st1);
		
		st1.setLength(3);
		System.out.println("设置StringBuffer的长度后："+st1);
		
		String sst = st1.substring(2);
		System.out.println("从第二位开始返回子串："+sst);
		
		String stt = st1.substring(2, 3);
		System.out.println("截取子串："+stt);
		
		
		String stbStr = st1.toString();
		System.out.println("转换为字符串"+stbStr);
		
		
		
	}
	
	public static void main(String args[]){
		StringBuffer stb = new StringBuffer("菜鸟教程官网：");
		stb.append("www");
		stb.append(".runoob");
		stb.append(".com");
		System.out.println(stb);
		System.out.println("------------------分割-----------------");
		new StringBufferDemo().stringBufferMethods();
	}

}

