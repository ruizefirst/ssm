package com.dsy.www.coding.array;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 8, 2017 4:47:17 PM
 * @version 1.0
 * @Description: java�������������������ʼ��
 * @parameter
 * @since  
 * @return
 * 
 **/
public class ArrayDemo {
	/***�������� ��ʼ**/
	int[] arrayRefVar; 
	String[] arrayStringVar;
	
	int arrayRef[];
	String arrayString[];

	int[][] array2D;
	int[] arrayD[];
	int array2[][];
	
	String[][][] string3D;
	String[][] string3[];
	String[]  stringD[][];
	/***�������� ����**/
	
	/**������ѡ�����Ƽ�ʹ�ã������������Ƽ�ʹ�ã���ʹ���˲��ᱨ��*/
	
	/***�������������� ��ʼ**/
	int[] arrayRefVar1 = new int[10];
	String[] arrayStringVar1 = new String[20];
	/***�������������� ����**/
	static int[] kt = {1,2,3,5,6,7,8,9};
	//���鷭ת
	public static int[] reverse(int[] list){
		int[] result = new int[list.length];
		for(int i = 0,j = result.length-1;i<list.length;i++,j--){
			result[j] = list[i];
		}
		return result;
	}
	
	public static void main(String args[]){
		int[] tu = reverse(kt);
		for(int j = 0;j<tu.length;j++){
			System.out.print(tu[j]);
	    }
	}
}

