package com.dsy.www.coding.io;

import java.io.File;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 11, 2017 9:14:56 AM
 * @version 1.0
 * @Description: TODO 读取目录
 * @parameter
 * @since  
 * @return
 * 
 **/
public class DirList {
	
	public static void main(String args[]){
		String dirname = "c:/APICloud";
		getDirs(dirname);
	}
	
	//获取路径中所还有的文件及文件夹
	public static void getDirs(String dirname){
		File file = new File(dirname);
		if(file.isDirectory()){
			System.out.println("目录："+dirname);
			String s[] = file.list(); //目录中的所有文件及文件夹
			for(int i =0;i<s.length;i++){
				File f = new File(dirname+"/"+s[i]);
				if(f.isDirectory()){
					System.out.println(s[i]+"是一个目录");
					getDirs(dirname+"/"+s[i]);
				}else{
					System.out.println(s[i]+"是一个文件");
				}
			}
		}else{
			System.out.println(dirname+"不是一个目录");
		}
	}
}

