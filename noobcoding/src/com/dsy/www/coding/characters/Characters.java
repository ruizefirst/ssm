package com.dsy.www.coding.characters;
/**
 * @author Apollo
 * @date 20170607
 * @description Character讲解
 * */
public class Characters {
	char c = 'c';
	Character ch = 'd';//将字符d装箱到Character对象 ch中
	Character cc = new Character('a');
	char[] charArray = {'a','b','c','d','e'};
	
	/**java中的转义字符：
	 *   \t   tab键
	 *   \b   后退键
	 *   \n   换行
	 *   \r   回车 
	 *   \f   换页符
	 *   \'   单引号
	 *   \"   双引号
	 *   \\   反斜杠
	 **/
    public static void main(String args[]){
    	//意义双引号并输出
    	System.out.println("访问\"菜鸟教程！\"");
    	System.out.println("************Character方法*************");
    	boolean isChar = Character.isLetter('c');
    	boolean isDigChar = Character.isDigit('2');
    	boolean isBlankOne = Character.isWhitespace(' ');
    	boolean isBlankTwo = Character.isWhitespace(32);
    	boolean isUpperOne = Character.isUpperCase('A');
    	boolean isUpperTwo = Character.isUpperCase(65);
    	boolean isLowerOne = Character.isLowerCase('a');
    	boolean isLowerTwo = Character.isLowerCase(97);
    	String str = Character.toString('a');
    	int len = str.length();
    	System.out.println("isChar:"+isChar+"\n"+"isDigChar:"+isDigChar+"\n"+"isBlankOne:"+isBlankOne+"\n"+"" +
    			"isBlankTwo:" +isBlankTwo+"\n"+
    			"isUpperOne:" +isUpperOne+"\n"+
    			"isUpperTwo:"+isUpperTwo+"\n"+
    			"isLowerOne:"+isLowerOne+"\n"+
    			"isLowerTwo:"+isLowerTwo+"\n"+
                "str:"+str+"\n"+"len:"+len);
    }
}
