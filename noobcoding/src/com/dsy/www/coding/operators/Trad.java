package com.dsy.www.coding.operators;
/***
 *打印乘法口诀表
 * */
public class Trad {
	public static void main(String args[]) {
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+i*j+" ");
			}
			System.out.println();
		}
	}

}
