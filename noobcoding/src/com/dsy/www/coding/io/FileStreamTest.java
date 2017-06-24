package com.dsy.www.coding.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 10, 2017 11:55:23 AM
 * @version 1.0
 * @Description: TODO OutputStream InputStream FileOutputStream FileInputStream  读写文件
 * @parameter
 * @since  
 * @return
 * 此方法写入文件出现乱码(主要原因是：此方式主要是以二进制的方式向文件中写入数据)
 **/
public class FileStreamTest {
	public static void main(String args[]){
	    try{
	      byte bWrite [] = {11,21,3,40,5};
	      OutputStream os = new FileOutputStream("test.txt");
	      for(int x=0; x < bWrite.length ; x++){
	      os.write( bWrite[x] ); // writes the bytes
	    }
	    os.close();
	 
	    InputStream is = new FileInputStream("test.txt");
	    int size = is.available();
	 
	    for(int i=0; i< size; i++){
	      System.out.print((char)is.read() + "  ");
	    }
	      is.close();
	    }catch(IOException e){
	      System.out.print("Exception");
	    }  
	  }

}

