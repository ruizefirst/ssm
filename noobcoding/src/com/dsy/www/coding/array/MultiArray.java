package com.dsy.www.coding.array;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 8, 2017 8:43:56 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)
 * @parameter
 * @since  
 * @return
 * 
 **/
public class MultiArray {
	/***��ά���������ͳ�ʼ��*/
	public static void main(String args[]){
	String[][] strArr = new String[3][4];
	
	String s[][] = new String[2][];
	s[0] = new String[2];
	s[1] = new String[3];
	s[0][0] = new String("Good");
	s[0][1] = new String("Luck");
	s[1][0] = new String("to");
	s[1][1] = new String("you");
	s[1][2] = new String("!");
	for(int i = 0 ;i <s.length;i++){
		for(int j=0;j<s[i].length;j++){
			System.out.print(s[i][j]+"   ");
		}
	}
	System.out.println("----------���Ƿָ���--------------");
	
	//java.util.Arrays
	
	/***
	 *1�������鸳ֵ��fill����
	 *2������������ͨ��sort������������
	 *3���Ƚ����飺ͨ��equals�����Ƚ�������Ԫ��ֵ�Ƿ����
	 *4����������Ԫ�أ�ͨ��binarySearch�����ܶ�����õ������ܽ��ж��ֲ��ҷ�����
	 * 
	 * */
	//˳���������
		int[] test= {1,2,4,5,7};
	    for (int i : test) {
	        System.out.print(i+" ");
	    }
	    System.out.println("\n");
	    test = MultiArray.reverse(test);
	    for (int i : test) {
	        System.out.print(i+" ");
	    }
	}
	//����Ԫ�ط�ת
		public static int[] reverse(int[] arr){
		
		    int[] resoult = new int[arr.length];
		
		    for (int i = 0,j=resoult.length-1; i < arr.length; i++,j--) {
		        resoult[j] = arr[i];
		    }
		    return resoult;
		}
}

