package com.briup.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.bean.Book;

public class ConnectionFactory {
	//数据库驱动
	private static String driver;
	//数据库地址
	private static String url;
	//用户名
	private static String user;
	//密码
	private static String password;
	
	static{
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@localhost:1521:XE";
		user = "estore";
		password = "estore";
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//注册驱动
			Class.forName(driver);
			//获取连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/*public static void main(String[] args) {
		//调用获取连接数据库的方法，
		Connection conn = getConnection();
//		System.out.println(conn);
		try {
			//获取statement
			Statement stms = conn.createStatement();
			//执行sql语句
			String sql = "select * from book";
			//获取结果集
			ResultSet rs = stms.executeQuery(sql);
			//遍历结果集
			int flag = 0;
			while(rs.next()){
				Book book = new Book();
				//获取参数,将参数进行封装
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				float price = rs.getFloat("price");
				book.setId(id);
				book.setName(name);
				book.setDescription(description);
				book.setPrice(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}*/
}
