package com.dsy.www.coding.array;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 8, 2017 8:43:56 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @parameter
 * @since  
 * @return
 * 
 **/
public class MultiArray {
	/***多维数组声明和初始化*/
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
	System.out.println("----------我是分割线--------------");
	
	//java.util.Arrays
	
	/***
	 *1、给数组赋值用fill方法
	 *2、对数组排序：通过sort方法，按升序
	 *3、比较数组：通过equals方法比较数组中元素值是否相等
	 *4、查找数组元素：通过binarySearch方法能对排序好的数组能进行二分查找法操作
	 * 
	 * */
	//顺序输出数组
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
	//数组元素翻转
		public static int[] reverse(int[] arr){
		
		    int[] resoult = new int[arr.length];
		
		    for (int i = 0,j=resoult.length-1; i < arr.length; i++,j--) {
		        resoult[j] = arr[i];
		    }
		    return resoult;
		}
}

