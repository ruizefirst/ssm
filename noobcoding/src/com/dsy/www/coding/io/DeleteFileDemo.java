package com.dsy.www.coding.io;

import java.io.File;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 11, 2017 9:29:13 AM
 * @version 1.0
 * @Description: TODO  删除目录或文件
 * @parameter
 * @since  
 * @return
 * 
 **/
public class DeleteFileDemo {
	
	public static void main(String args[]){
		//这里修改为自己的测试目录
		File folder = new File("c:/wang"); 
		deleteFolder(folder);//删除该目录下的所有文件及文件夹
	}
	
	//删除文件及目录
	public static void deleteFolder(File folder){
		File[] files = folder.listFiles();//该目录下的所有文件
		if(files!=null){
			for(File f:files){
				if(f.isDirectory()){
					deleteFolder(f);
				}else{
					f.delete();
				}
			}
		}
		folder.delete();
	}

}

