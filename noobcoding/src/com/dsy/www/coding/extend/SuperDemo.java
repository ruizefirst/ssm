package com.dsy.www.coding.extend;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 12, 2017 3:00:14 PM
 * @version 1.0
 * @Description: TODO  super 与 this关键字
 * @parameter
 * @since  
 * @return
 * 
 **/
public class SuperDemo {
	public static void main(String args[]){
		new SubClass().showMessage();
	}

}

class SuperClass{
	int i = 50;
}

class SubClass extends SuperClass{
	int i = 100;
	public void showMessage(){
		System.out.printf("super.i = %d,this.i = %d\n",super.i,this.i);
	}
}

