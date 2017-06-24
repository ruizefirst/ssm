package com.dsy.www.coding.senior.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 13, 2017 3:08:19 PM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  序列化
 * @parameter
 * @since  
 * @return
 * 当序列化一个对象到文件时， 按照 Java 的标准约定是给文件一个 .ser 扩展名。
 * 一个类的对象要想序列化成功，必须满足两个条件：
 * 1、该类必须实现java.io.Serializable接口
 * 2、该类所有属性必须是可序列化的，如果有一个属性不可序列化，则该属性必须注明是（transient）短暂的(变量声明为private不会报错，但是也无法进行序列化)
 * 
 * 
 * 检查一个类是否可序列化，看该类是否实现java.io.Serializable接口
 * 
 * 
 * 
 * 类ObjectInputStream 和ObjectOutputStream是高层次的数据流，他们包含序列化和反序列化的方法
 * 	1、ObjectOutputStream包含很多写方法来写各种数据类型，但有一个特别 的方法列外：
 * 		public final void writeObject(Object x) throws IOException
 * 		此方法序列化一个对象，并将它发送到输出流。
 *  2、ObjectInputStream 包含如下反序列化一个对象的方法：
 *  	public final void readObject() throws IOException,ClassNotFoundException
 *      该方法从流中取出一个对象，并将对象反序列化。它返回值是Object,因此你需要将它转换成合适数据类型。
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
		
	}//这个main方法必须有，SerializableDemo类中的main方法才能执行

}

//执行序列化对象操作
class SerializableDemo {
	public static void main(String args[]){
		Employee e = new Employee();
		e.name = "wang sheng gang";
		e.address = "若水路一号";
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
//执行反序列化对象操作
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
		}catch(ClassNotFoundException c){//反序列化必须要找到字节码的类，否则会抛出ClassNotFoundException
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

