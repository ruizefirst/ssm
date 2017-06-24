package com.dsy.www.coding.array;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 8, 2017 4:47:17 PM
 * @version 1.0
 * @Description: java数组的声明、创建、初始化
 * @parameter
 * @since  
 * @return
 * 
 **/
public class ArrayDemo {
	/***声明数组 开始**/
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
	/***声明数组 结束**/
	
	/**以上首选方法推荐使用，其他方法不推荐使用，但使用了不会报错*/
	
	/***声明、创建数组 开始**/
	int[] arrayRefVar1 = new int[10];
	String[] arrayStringVar1 = new String[20];
	/***声明、创建数组 结束**/
	static int[] kt = {1,2,3,5,6,7,8,9};
	//数组翻转
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

