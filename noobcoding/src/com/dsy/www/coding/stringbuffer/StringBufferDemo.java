package com.dsy.www.coding.stringbuffer;
/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 8, 2017 2:09:10 PM
 * @version 1.0
 * @Description: �����ַ��������޸ĵ�ʱ����Ҫʹ��StringBuffer��StringBuilder
 * @parameter
 * @since  
 * @return
 * 
 **/
public class StringBufferDemo {
	
	public void stringBufferMethods(){
		StringBuffer st = new StringBuffer("StringBuffer�����з�����");
		st.append("\n����Ч��");
		System.out.println(st);
		
		StringBuffer st1 = new StringBuffer("familyȫ��");
		st1.reverse();//�ַ�����ת�ĺ÷���
		System.out.println(st1);
		
		st1.delete(1,2); //�������㿪ʼ  ɾ������λ����1��2֮����ַ�
		System.out.println(st1);
		
		st1.insert(1, 2);
		System.out.println(st1);
		
		st1.replace(2, 3, "123");
		System.out.println(st1);
		
		System.out.println("--------------�ָ���-------------");
		
		int k = st1.capacity();
		System.out.println("��ǰ������"+k);
		
		char c = st1.charAt(2);
		System.out.println("��������λ��Ϊ2���ַ�"+c);
		
		st1.ensureCapacity(Integer.MIN_VALUE);//ȷ���������ٵ���ָ������Сֵ
		char[] cha = new char[6];
		st1.getChars(0,5,cha, 0);
		System.out.println(cha.toString());
		
		st1.setCharAt(2,'2');
		System.out.println("��2�������ַ�����ĵڶ�λ��"+st1);
		
		st1.setLength(3);
		System.out.println("����StringBuffer�ĳ��Ⱥ�"+st1);
		
		String sst = st1.substring(2);
		System.out.println("�ӵڶ�λ��ʼ�����Ӵ���"+sst);
		
		String stt = st1.substring(2, 3);
		System.out.println("��ȡ�Ӵ���"+stt);
		
		
		String stbStr = st1.toString();
		System.out.println("ת��Ϊ�ַ���"+stbStr);
		
		
		
	}
	
	public static void main(String args[]){
		StringBuffer stb = new StringBuffer("����̳̹�����");
		stb.append("www");
		stb.append(".runoob");
		stb.append(".com");
		System.out.println(stb);
		System.out.println("------------------�ָ�-----------------");
		new StringBufferDemo().stringBufferMethods();
	}

}

