package com.briup.dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.briup.bean.Customer;
import com.briup.common.ConnectionFactory;

public class CustomerDao {
	/**
	 * 根据用户名，密码找出一个用户
	 * */
	public Customer findCustomer(String name,String password){
		//声明一个顾客
		Customer customer = null;
		//获取数据库的连接
		Connection conn = ConnectionFactory.getConnection();
		//获取PreparedStatement
		String sql = "select * from customer where name=? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				customer = new Customer();
				int id = rs.getInt("id");
				String customer_name = rs.getString("name");
				String customer_password = rs.getString("password");
				String zip = rs.getString("zip");
				String address = rs.getString("address");
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				customer.setId(id);
				customer.setName(customer_name);
				customer.setPassword(customer_password);
				customer.setZip(zip);
				customer.setAddress(address);
				customer.setTelephone(telephone);
				customer.setEmail(email);
			}
			//释放资源
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
