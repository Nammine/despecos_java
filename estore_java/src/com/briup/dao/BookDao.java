package com.briup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.briup.bean.Book;
import com.briup.common.ConnectionFactory;

public class BookDao {
	/**
	 * 根据id查找书
	 * */
	public Book findBookById(int bookId) {
		Book book = null;
		//获取连接
		Connection conn = ConnectionFactory.getConnection();
		//获取prepareStatement
		String sql = "select * from book where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			//执行sql语句,并且获取结果集
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				book = new Book();
				//接受查到的数据的每一个字段对应的值
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				float price = rs.getFloat("price");
				//将获取到的值进行封装
				book.setId(id);
				book.setDescription(description);
				book.setName(name);
				book.setPrice(price);
			}
			//释放资源
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return book;
	}
	/**
	 * 查找数据库中，书，表中的所有数据
	 * */
	public List<Book> findAllBooks() {
		//获取连接
		Connection conn = ConnectionFactory.getConnection();
		List<Book> books = new ArrayList<>();
		try {
			//获取statement
			Statement stms = conn.createStatement();
			//执行sql语句
			String sql = "select * from book";
			//获取结果集
			ResultSet rs = stms.executeQuery(sql);
			//遍历结果集
			int flag = 0;
			//声明一个集合
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
				//将书放入集合中
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
}
