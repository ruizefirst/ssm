package com.dsy.www.coding.senior.generics;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 13, 2017 2:07:06 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)
 * @parameter
 * @since  
 * @return
 * �н�����Ͳ���: ������ʱ�������������Щ�������ݵ�һ�����Ͳ������������෶Χ��
 * ���磬һ���������ֵķ�������ֻϣ������Number����Number�����ʵ����������н����Ͳ�����Ŀ�ġ� 
 * Ҫ����һ���н�����Ͳ����������г����Ͳ��������ƣ����extends�ؼ��֣������������Ͻ硣
 *
 *
 *
 *
 *---------------------------
 * Java�����еı�Ƿ����壺 
 * E - Element (�ڼ�����ʹ�ã���Ϊ�����д�ŵ���Ԫ��)
 * T - Type��Java �ࣩ
 * K - Key������
 * V - Value��ֵ��
 * N - Number����ֵ���ͣ�
 * �� -  ��ʾ��ȷ����java����
 * S��U��V  - 2nd��3rd��4th types
 *	Object����Щ��Ƿ������java������ɶ�����أ�  
 *	Object��������ĸ��࣬�κ���Ķ��󶼿������ø���Object���ñ�����ʹ�õ�ʱ�������Ҫ����ǿ��ת����
 *  ������ʹ���˷���T��E����Щ��ʶ������ʵ����֮ǰ���;��Ѿ�ȷ���ˣ�����Ҫ�ٽ�������ǿ��ת����
 *
 **/
public class MaximumTest {
	public static <T extends Comparable<T>> T maximum(T x,T y,T z){
		T max = x;//����x�ǳ�ʼ���ֵ
		if(y.compareTo(max)>0){
			max = y;
		}
		if(z.compareTo(max)>0){
			max = z;
		}
		return max;//����������
	}
	 
	public static void main(String args[]){
		System.out.printf("%d,%d��%d��������Ϊ��%d\n\n",3,4,5,maximum(3,4,5));
		System.out.printf("%.1f,%.1f��%.1f��������Ϊ��%.1f\n\n",6.6,8.8,7.7,maximum(6.6,8.8,7.7));
		System.out.printf("%s,%s��%s��������Ϊ %s\n","pear","apple","orange",maximum("pear","apple","orange"));
	}
	
}

