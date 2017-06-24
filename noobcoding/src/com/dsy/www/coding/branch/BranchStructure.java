package com.dsy.www.coding.branch;
/**
 * ��֧�ṹ��
 * if
 * if...else
 * if...else if...else
 * switch
 * 
 * Ƕ��if....else�ǺϷ���
 * �ص����switch,��ʹ�ù�������:
 * 1��switch ����еı������Ϳ����ǣ� byte��short��int ���� char���� Java SE 7 ��ʼ��switch ֧���ַ��������ˣ�ͬʱ case ��ǩ����Ϊ�ַ�����������������
 * 2��switch ������ӵ�ж�� case ��䡣ÿ�� case �����һ��Ҫ�Ƚϵ�ֵ��ð�š�
 * 3��case ����е�ֵ���������ͱ��������������������ͬ������ֻ���ǳ����������泣����
 * 4����������ֵ�� case ����ֵ���ʱ����ô case ���֮�����俪ʼִ�У�ֱ�� break �����ֲŻ����� switch ��䡣 
 * 5�������� break ���ʱ��switch �����ֹ��������ת�� switch ����������ִ�С�case ��䲻����Ҫ���� break ��䡣���û�� break �����֣���������ִ����һ�� case ��䣬ֱ������ break ��䡣
 * 6��switch �����԰���һ�� default ��֧���÷�֧������ switch �������һ����֧��default ��û�� case ����ֵ�ͱ���ֵ��ȵ�ʱ��ִ�С�default ��֧����Ҫ break ��䡣
 * */
public class BranchStructure {
	public static void main(String args[]){
	      //char grade = args[0].charAt(0);
	      char grade = 'C';
	 
	      switch(grade)
	      {
	         case 'A' :
	            System.out.println("����"); 
	            break;
	         case 'B' :
	         case 'C' :
	            System.out.println("����");
	            break;
	         case 'D' :
	            System.out.println("����");
	         case 'F' :
	            System.out.println("����Ҫ��Ŭ��Ŭ��");
	            break;
	         default :
	            System.out.println("δ֪�ȼ�");
	      }
	      System.out.println("��ĵȼ��� " + grade);
	   }
}
