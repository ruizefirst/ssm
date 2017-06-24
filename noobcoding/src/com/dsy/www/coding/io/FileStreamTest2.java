package com.dsy.www.coding.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 10, 2017 6:11:33 PM
 * @version 1.0
 * @Description: TODO 写入文件   并读出
 * @parameter
 * @since  
 * @return
 * 
 **/
public class FileStreamTest2 {
	public static void main(String args[]) throws IOException{
		File f = new File("a.txt");
		FileOutputStream fos = new FileOutputStream(f);
		//构建FileOutputStream 对象，文件不存在会自动创建
		
		OutputStreamWriter writer = new OutputStreamWriter(fos,"UTF-8");
		//构建OutputStreamWriter 对象，参数可以指定编码，默认为操作系统默认编码，windows上是gbk
		writer .append("中文输入");
		//写入到缓存区
		writer.append("\r\n");
		//换行
		writer.append("English");
		//刷新缓存冲，写入到文件，如果下面已经没有写入的内容了，直接close也会写入
		writer.close();
		//关闭写入流，同时会把缓冲区内容写入文件，所以上面的注释掉
		fos.close();
		//关闭输出流，释放系统资源
		
		FileInputStream fip = new FileInputStream(f);
		//构建FileInputStream对象
		
		InputStreamReader reader = new InputStreamReader(fip,"UTF-8");
		//构建InputStreamReader对象，编码与写入相同
		
		StringBuffer sb = new StringBuffer();
		while(reader.ready()){
			sb.append((char)reader.read());
			//转成char加到StringBuffer对象中
		}
		System.out.println(sb.toString());
		reader.close();
		//关闭读取流
		fip.close();
		//关闭输入流，释放系统资源
		
		
		
	}

}

