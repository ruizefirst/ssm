package com.dsy.www.coding.method;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 9, 2017 10:11:53 PM
 * @version 1.0
 * @Description: TODOֵ����
 * @parameter
 * @since  
 * @return
 * 
 **/
public class TestPassByValue {
	public static void main(String args[]){
		int num1 = 1;
		int num2 = 2;
		System.out.println("����ǰnum1��ֵΪ��"+num1+",num2��ֵΪ��"+num2);
		// ����swap����
	    swap(num1, num2);
	    System.out.println("������ num1 ��ֵΪ��" +
	                       num1 + " ��num2 ��ֵΪ��" + num2);
	}
	/** �������������ķ��� */
	  public static void swap(int n1, int n2) {
	    System.out.println("\t���� swap ����");
	    System.out.println("\t\t����ǰ n1 ��ֵΪ��" + n1
	                         + "��n2 ��ֵ��" + n2);
	    // ���� n1 �� n2��ֵ
	    int temp = n1;
	    n1 = n2;
	    n2 = temp;
	 
	    System.out.println("\t\t������ n1 ��ֵΪ " + n1
	                         + "��n2 ��ֵ��" + n2);
	  }

	
}

