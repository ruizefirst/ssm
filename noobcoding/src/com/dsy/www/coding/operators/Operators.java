package com.dsy.www.coding.operators;
/***
 * 算术、关系、逻辑、赋值、位、其他(?:、instanceof)
 * 
 * */
public class Operators {
   /**短路运算符 &&**/
	public static void main(String args[]){
		int t = 5;
		boolean f = (t<4)&&(t++<10);
		System.out.println("使用短路逻辑运算符的结果为："+f);
		System.out.println("a结果为："+t);
		
		
		 int a = 10;
	     int b = 20;
	     int c = 0;
	     c = a + b;
	     System.out.println("c = a + b = " + c );
	     c += a ;
	     System.out.println("c += a  = " + c );
	     c -= a ;
	     System.out.println("c -= a = " + c );
	     c *= a ;
	     System.out.println("c *= a = " + c );
	     a = 10;
	     c = 15;
	     c /= a ;
	     System.out.println("c /= a = " + c );
	     a = 10;
	     c = 15;
	     c %= a ;
	     System.out.println("c %= a  = " + c );
	     c <<= 2 ;
	     System.out.println("c <<= 2 = " + c );
	     c >>= 2 ;
	     System.out.println("c >>= 2 = " + c );
	     c >>= 2 ;
	     System.out.println("c >>= a = " + c );
	     c &= a ;
	     System.out.println("c &= 2  = " + c );
	     c ^= a ;
	     System.out.println("c ^= a   = " + c );
	     c |= a ;
	     System.out.println("c |= a   = " + c );

	     /***
	      * ( Object reference variable ) instanceof  (class/interface type)
	      * 如果被比较的对象兼容于右侧类型,该运算符仍然返回true
	      * */
	     String name = "James";
	     boolean result = name instanceof String; // 由于 name 是 String 类型，所以返回真
	     
	     
/***运算符的优先级**/
/***
类别                     操作符                                                                                                                关联性 

后缀                   () [] . (点操作符)                           左到右 
一元                  + + - ！〜                                                                                                      从右到左 
乘性                   * /％                                                                                                                  左到右 
加性                   + -                                       左到右 
移位                   >> >>>  <<                                左到右 
关系                   >> = << =                                 左到右 
相等                   ==  !=                                    左到右 
按位与                  ＆                                                                                                                       左到右 
按位异或                  ^                                       左到右 
按位或                  |                                        左到右 
逻辑与                  &&                                       左到右 
逻辑或                  ||                                       左到右 
条件        ？：                                                                                                                                 从右到左 
赋值                   = + = - = * = / =％= >> = << =＆= ^ = | =  从右到左 
逗号                   ，                                                                                                                          左到右 
   
   */
 }

}
