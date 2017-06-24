package com.dsy.www.coding.classvar;

public class Variable {
	static int allClicks=0;    // 类变量
	 
    String str="hello world";  // 实例变量   也叫成员变量
 
    public void method(){
    	//局部变量没有默认值，局部变量被声明后，必须经过初始化才能使用
        int i =0;  // 局部变量     访问修饰符不能用于此种变量  ，方法执行完毕，  变量即销毁，局部变量分配在栈上
    }

}
