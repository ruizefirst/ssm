package com.dsy.www.coding.senior.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 13, 2017 3:08:19 PM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  ���л�
 * @parameter
 * @since  
 * @return
 * �����л�һ�������ļ�ʱ�� ���� Java �ı�׼Լ���Ǹ��ļ�һ�� .ser ��չ����
 * һ����Ķ���Ҫ�����л��ɹ���������������������
 * 1���������ʵ��java.io.Serializable�ӿ�
 * 2�������������Ա����ǿ����л��ģ������һ�����Բ������л���������Ա���ע���ǣ�transient�����ݵ�(��������Ϊprivate���ᱨ������Ҳ�޷��������л�)
 * 
 * 
 * ���һ�����Ƿ�����л����������Ƿ�ʵ��java.io.Serializable�ӿ�
 * 
 * 
 * 
 * ��ObjectInputStream ��ObjectOutputStream�Ǹ߲�ε������������ǰ������л��ͷ����л��ķ���
 * 	1��ObjectOutputStream�����ܶ�д������д�����������ͣ�����һ���ر� �ķ������⣺
 * 		public final void writeObject(Object x) throws IOException
 * 		�˷������л�һ�����󣬲��������͵��������
 *  2��ObjectInputStream �������·����л�һ������ķ�����
 *  	public final void readObject() throws IOException,ClassNotFoundException
 *      �÷���������ȡ��һ�����󣬲����������л���������ֵ��Object,�������Ҫ����ת���ɺ����������͡�
 *  
 * 
 **/
public class Employee implements java.io.Serializable{
	public String name;
	private String kk;
	public String address;
	public transient int SSN;
	public int number;
	public void mailCheck(){
		System.out.println("Mailing a check to "+name +" "+address);
	}
	public static void main(String args[]){
		
	}//���main���������У�SerializableDemo���е�main��������ִ��

}

//ִ�����л��������
class SerializableDemo {
	public static void main(String args[]){
		Employee e = new Employee();
		e.name = "wang sheng gang";
		e.address = "��ˮ·һ��";
		e.SSN = 111222333;
		e.number = 101;
		try{
			FileOutputStream fileOut = new FileOutputStream("C:/Users/Apollo/Desktop/employee.ser");
			
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serializable data is saved in C:/Users/Apollo/Desktop/employee.ser");
			
		}catch(IOException  error){
			error.printStackTrace();
		}
	}

}
//ִ�з����л��������
class Deserializable{
	public static void main(String args[]){
		Employee e = null;
		try{
			
			FileInputStream fileIn = new FileInputStream("C:/Users/Apollo/Desktop/employee.ser");
			
			ObjectInputStream in = new ObjectInputStream(fileIn); 
			
			e = (Employee)in.readObject();
			
			in.close();
			fileIn.close();	
			
		}catch(IOException i){
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c){//�����л�����Ҫ�ҵ��ֽ�����࣬������׳�ClassNotFoundException
			System.out.println("Employee class  not found");
			c.printStackTrace();
			return;
		}
		
		System.out.println("Dserializable Employee...");
		System.out.println("Name:"+e.name);
		System.out.println("Address:"+e.address);
		System.out.println("SSN"+e.SSN);
		System.out.println("Number:"+e.number);
	}
}

