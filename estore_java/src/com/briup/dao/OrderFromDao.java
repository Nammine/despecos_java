package com.briup.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.briup.bean.OrderFrom;
import com.briup.common.ConnectionFactory;

public class OrderFromDao {
	/**
	 * 存储一个订单
	 * */
	public void saveOrderFrom(OrderFrom orderFrom){
		//获取连接
		Connection conn = ConnectionFactory.getConnection();
		String sql = "insert into orderform values(?,?,?,?)";
		System.out.println(sql);
		try {
			//获取preparedStatement用来执行sql语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//替换占位符
			pstmt.setInt(1, orderFrom.getId());
			pstmt.setFloat(2, orderFrom.getCost());
			pstmt.setDate(3, new Date(orderFrom.getOrderdate().getTime()));
			pstmt.setInt(4, orderFrom.getCustomerid());
			//执行
			pstmt.executeUpdate();
			//关闭资源
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据用户id来查找所有的属于该用户的订单
	 * */
	public List<OrderFrom> findAllOrderFroms(int customerId) {
		List<OrderFrom> orderFroms = new ArrayList<OrderFrom>();
		//获取连接
		Connection conn = ConnectionFactory.getConnection();
		//获取preparedStatement
		String sql = "select * from orderform where customerid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//替换占位符
			pstmt.setInt(1, customerId);
			//执行sql，并且获取到结果集
			ResultSet rs = pstmt.executeQuery();
			//遍历结果集
			while(rs.next()) {
				//创建一个订单对象
				OrderFrom orderFrom = new OrderFrom();
				//获取数据库里记录里面的每一个字段
				int id = rs.getInt("id");
				float cost = rs.getFloat("cost");
				java.util.Date orderDate = rs.getDate("orderdate");
				orderFrom.setId(id);
				orderFrom.setCost(cost);
				orderFrom.setOrderdate(orderDate);
				orderFrom.setCustomerid(customerId);
				orderFroms.add(orderFrom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return orderFroms;
	}
}










