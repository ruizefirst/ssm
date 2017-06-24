package com.dsy.www.coding.senior.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
 * @author ���� :Apollo
 * @date ����ʱ�䣺Jun 14, 2017 10:42:16 AM
 * @version 1.0
 * @Description: TODO(������һ�仰��������������)  ����Mysql���ݿ�ʾ��
 * @parameter
 * @since  
 * @return
 * �������ݿ�����Ҫ�Ĳ�����
 * 
 * 1��JDBC����
 * 2�����ݿ�URL
 * 3���û���
 * 4������
 * �������ݿ�����Ҫ�Ĳ��裺
 * 1��Class.forName();ע��JDBC����
 * 2��DriverManager.getConnection();���������ĸ�������ȡ���ݿ�����Connection����
 * 3��conn.createStatement() ����Connection���󴴽� Statement
 * 4��stmt.executeQuery(sql) ����Statement����ִ��sql
 * 5������ResultSet���������ִ��SQL��Ľ��
 * 6��ѭ�����������
 * 7���ر���Դ����������رգ� 
 **/
public class MysqlDemo {
	//JDBC���������ݿ�URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
	//���ݿ���û���������
	static final String USER = "root";
	static final String PASS = "root";
	
	public static void main(String args[]){
		Connection conn = null;
		java.sql.Statement stmt = null;
		try{
		//ע��JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		//������
		System.out.println("�������ݿ�...");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		//ִ�в�ѯ
		System.out.println("ʵ����Statement��...");
		stmt = conn.createStatement();
		String sql;
		sql = "SELECT id ,name ,url FROM websites";
		ResultSet rs = stmt.executeQuery(sql);
		
		//չ����������ݿ�
		while(rs.next()){
			//ͨ���ֶμ���
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String url = rs.getString("url");
			
			//�������
			System.out.print("ID:"+id);
			System.out.print(",վ�����ƣ�"+name);
			System.out.print(",վ��URL��"+url);
			System.out.println("\n");
		}
		rs.close();
		stmt.close();
		conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
					if(stmt!=null){
						stmt.close();
					}
			  }catch(SQLException se2){
				  
			  }
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}
}

