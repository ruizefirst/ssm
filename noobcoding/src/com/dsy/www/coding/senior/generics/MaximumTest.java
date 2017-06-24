package com.dsy.www.coding.senior.generics;
/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 2:07:06 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @parameter
 * @since  
 * @return
 * 有界的类型参数: 可能有时候，你会想限制那些被允许传递到一个类型参数的类型种类范围。
 * 例如，一个操作数字的方法可能只希望接受Number或者Number子类的实例。这就是有界类型参数的目的。 
 * 要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
 *
 *
 *
 *
 *---------------------------
 * Java泛型中的标记符含义： 
 * E - Element (在集合中使用，因为集合中存放的是元素)
 * T - Type（Java 类）
 * K - Key（键）
 * V - Value（值）
 * N - Number（数值类型）
 * ？ -  表示不确定的java类型
 * S、U、V  - 2nd、3rd、4th types
 *	Object跟这些标记符代表的java类型有啥区别呢？  
 *	Object是所有类的根类，任何类的对象都可以设置给该Object引用变量，使用的时候可能需要类型强制转换，
 *  但是用使用了泛型T、E等这些标识符后，在实际用之前类型就已经确定了，不需要再进行类型强制转换。
 *
 **/
public class MaximumTest {
	public static <T extends Comparable<T>> T maximum(T x,T y,T z){
		T max = x;//假设x是初始最大值
		if(y.compareTo(max)>0){
			max = y;
		}
		if(z.compareTo(max)>0){
			max = z;
		}
		return max;//返回最大对象
	}
	 
	public static void main(String args[]){
		System.out.printf("%d,%d和%d中最大的数为：%d\n\n",3,4,5,maximum(3,4,5));
		System.out.printf("%.1f,%.1f和%.1f中最大的数为：%.1f\n\n",6.6,8.8,7.7,maximum(6.6,8.8,7.7));
		System.out.printf("%s,%s和%s中最大的数为 %s\n","pear","apple","orange",maximum("pear","apple","orange"));
	}
	
}

