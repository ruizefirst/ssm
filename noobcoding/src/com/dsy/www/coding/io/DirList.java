package com.dsy.www.coding.io;

import java.io.File;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 11, 2017 9:14:56 AM
 * @version 1.0
 * @Description: TODO ��ȡĿ¼
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
	
	//��ȡ·���������е��ļ����ļ���
	public static void getDirs(String dirname){
		File file = new File(dirname);
		if(file.isDirectory()){
			System.out.println("Ŀ¼��"+dirname);
			String s[] = file.list(); //Ŀ¼�е������ļ����ļ���
			for(int i =0;i<s.length;i++){
				File f = new File(dirname+"/"+s[i]);
				if(f.isDirectory()){
					System.out.println(s[i]+"��һ��Ŀ¼");
					getDirs(dirname+"/"+s[i]);
				}else{
					System.out.println(s[i]+"��һ���ļ�");
				}
			}
		}else{
			System.out.println(dirname+"����һ��Ŀ¼");
		}
	}
}

