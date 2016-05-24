package com.briup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.briup.bean.Orderline;
import com.briup.common.ConnectionFactory;

public class OrderLineDao {
	public void saveOrderLine(Orderline orderline) {
		//获取到连接
		Connection conn = ConnectionFactory.getConnection();
		String sql = "insert into orderline values(?,?,?,?,?,?)";
		try {
			//获取到preparedStatement
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//替换占位符
			pstmt.setInt(1, orderline.getId());
			pstmt.setInt(2, orderline.getNum());
			pstmt.setInt(3, orderline.getOrderFromId());
			pstmt.setString(4, orderline.getBookName());
			pstmt.setFloat(5, orderline.getBookPrice());
			pstmt.setFloat(6, orderline.getTotal());
			//执行sql语句
			pstmt.executeUpdate();
			//释放资源
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据订单的id,来查看所有属于该订单的订单项
	 * */
	public List<Orderline> findAllOrderLines(int orderFromId){
		List<Orderline> orderlines = new ArrayList<Orderline>();
		//获取连接
		Connection conn = ConnectionFactory.getConnection();
		//获取prepareStatement
		String sql = "select * from orderline where orderFromId = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//替换占位符
			pstmt.setInt(1, orderFromId);
			//执行查询操作，并且获取到结果集
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				//创建一个对象
				Orderline orderline = new Orderline();
				//获取字段
				int id = rs.getInt("id");
				int num = rs.getInt("num");
				String bookName = rs.getString("bookName");
				float bookPrice = rs.getFloat("bookPrice");
				float total = rs.getFloat("total");
				//进行封装
				orderline.setId(id);
				orderline.setNum(num);
				orderline.setBookName(bookName);
				orderline.setBookPrice(bookPrice);
				orderline.setTotal(total);
				orderline.setOrderFromId(orderFromId);
				//添加到集合中
				orderlines.add(orderline);
			}
			//释放资源
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return orderlines;
	}
}
