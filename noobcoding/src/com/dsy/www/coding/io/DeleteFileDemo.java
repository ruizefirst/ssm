package com.dsy.www.coding.io;

import java.io.File;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 11, 2017 9:29:13 AM
 * @version 1.0
 * @Description: TODO  ɾ��Ŀ¼���ļ�
 * @parameter
 * @since  
 * @return
 * 
 **/
public class DeleteFileDemo {
	
	public static void main(String args[]){
		//�����޸�Ϊ�Լ��Ĳ���Ŀ¼
		File folder = new File("c:/wang"); 
		deleteFolder(folder);//ɾ����Ŀ¼�µ������ļ����ļ���
	}
	
	//ɾ���ļ���Ŀ¼
	public static void deleteFolder(File folder){
		File[] files = folder.listFiles();//��Ŀ¼�µ������ļ�
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

