package com.dsy.www.coding.characters;
/**
 * @author Apollo
 * @date 20170607
 * @description Character����
 * */
public class Characters {
	char c = 'c';
	Character ch = 'd';//���ַ�dװ�䵽Character���� ch��
	Character cc = new Character('a');
	char[] charArray = {'a','b','c','d','e'};
	
	/**java�е�ת���ַ���
	 *   \t   tab��
	 *   \b   ���˼�
	 *   \n   ����
	 *   \r   �س� 
	 *   \f   ��ҳ��
	 *   \'   ������
	 *   \"   ˫����
	 *   \\   ��б��
	 **/
    public static void main(String args[]){
    	//����˫���Ų����
    	System.out.println("����\"����̳̣�\"");
    	System.out.println("************Character����*************");
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
