package com.dsy.www.coding.senior.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
 * @author 作者 :Apollo
 * @date 创建时间：Jun 14, 2017 10:42:16 AM
 * @version 1.0
 * @Description: TODO(这里用一句话描述这个类的作用)  连接Mysql数据库示例
 * @parameter
 * @since  
 * @return
 * 连接数据库所需要的参数：
 * 
 * 1、JDBC驱动
 * 2、数据库URL
 * 3、用户名
 * 4、密码
 * 连接数据库所需要的步骤：
 * 1、Class.forName();注册JDBC驱动
 * 2、DriverManager.getConnection();利用以上四个参数获取数据库连接Connection对象
 * 3、conn.createStatement() 利用Connection对象创建 Statement
 * 4、stmt.executeQuery(sql) 利用Statement对象执行sql
 * 5、创建ResultSet结果集接收执行SQL后的结果
 * 6、循环遍历结果接
 * 7、关闭资源（由内向外关闭） 
 **/
public class MysqlDemo {
	//JDBC驱动及数据库URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
	//数据库的用户名和密码
	static final String USER = "root";
	static final String PASS = "root";
	
	public static void main(String args[]){
		Connection conn = null;
		java.sql.Statement stmt = null;
		try{
		//注册JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		//打开链接
		System.out.println("连接数据库...");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
		//执行查询
		System.out.println("实例化Statement对...");
		stmt = conn.createStatement();
		String sql;
		sql = "SELECT id ,name ,url FROM websites";
		ResultSet rs = stmt.executeQuery(sql);
		
		//展开结果集数据库
		while(rs.next()){
			//通过字段检索
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String url = rs.getString("url");
			
			//输出数据
			System.out.print("ID:"+id);
			System.out.print(",站点名称："+name);
			System.out.print(",站点URL："+url);
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

