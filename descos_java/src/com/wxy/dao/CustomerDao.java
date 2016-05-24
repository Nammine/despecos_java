package com.wxy.dao;
/**
 * 
 * @author wxywxy
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wxy.bean.Customer;
import com.wxy.common.ConnectionFactory;
import com.wxy.common.HL;

/**
 * 
 * @author wxywxy
 * ��֤�û��Ƿ����
 */

public class CustomerDao {
	public Customer findCustomer(String name,String password){
		Customer customer=null;
		Connection conn=ConnectionFactory.getConnection();
		String sql="select * from customer where name=? and password=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
			    customer=new Customer();
				int id=rs.getInt("id");
				String customer_name=rs.getString("name");
				String customer_password=rs.getString("password");
				String zip=rs.getString("zip");
				String address=rs.getString("address");
				String telephone=rs.getString("telephone");
				String email=rs.getString("email");
				customer.setId(id);
				customer.setName(customer_name);
				customer.setPassword(customer_password);
				customer.setZip(zip);
				customer.setAddress(address);
				customer.setTelephone(telephone);
				customer.setEmail(email);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
	public boolean addCustomer(String name, String password, String zip,
			String address, String telephone, String email)
	{   
		Connection conn=ConnectionFactory.getConnection();
		String sql="insert into customer values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,HL.getId());
			pstmt.setString(2,name);
			pstmt.setString(3,password);
			pstmt.setString(4,zip);
			pstmt.setString(5,address);
			pstmt.setString(6,telephone);
			pstmt.setString(7,email);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}