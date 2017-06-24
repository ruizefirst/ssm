package com.dsy.www.coding.io;

import java.io.File;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 11, 2017 9:06:13 AM
 * @version 1.0
 * @Description: TODO 创建目录  创建文件夹
 * @parameter
 * @since  
 * @return
 * 
 **/
public class MakeDir {
	public static void main(String args[]){
		String dir = "c:/dir";
		File dirFile = new File(dir);
		boolean mkdStatus = dirFile.mkdir();//创建一个文件夹，成功返回true，失败返回false
		System.out.println(mkdStatus);
		
		String dirname ="c:/wang/wang/wang/t"; 
		File file = new File(dirname);
		file.mkdirs();//创建一个文件夹和它的所有父文件夹
	}

}

