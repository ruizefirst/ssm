package com.dsy.www.coding.io;

import java.io.File;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 11, 2017 9:06:13 AM
 * @version 1.0
 * @Description: TODO ����Ŀ¼  �����ļ���
 * @parameter
 * @since  
 * @return
 * 
 **/
public class MakeDir {
	public static void main(String args[]){
		String dir = "c:/dir";
		File dirFile = new File(dir);
		boolean mkdStatus = dirFile.mkdir();//����һ���ļ��У��ɹ�����true��ʧ�ܷ���false
		System.out.println(mkdStatus);
		
		String dirname ="c:/wang/wang/wang/t"; 
		File file = new File(dirname);
		file.mkdirs();//����һ���ļ��к��������и��ļ���
	}

}

