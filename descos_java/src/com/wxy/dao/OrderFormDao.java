package com.wxy.dao;
/**
 * 
 * @author wxywxy
 *
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxy.bean.OrderForm;
import com.wxy.common.ConnectionFactory;

public class OrderFormDao {
    /**
     * 
     * @param orderform
     */
	public void saveOrderForm(OrderForm orderform){
			Connection conn=ConnectionFactory.getConnection();
			String sql="insert into orderform values(?,?,?,?)";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, orderform.getId());
				pstmt.setFloat(2, orderform.getCost());
				pstmt.setDate(3, new Date(orderform.getOrderDate().getTime()));
				pstmt.setInt(4, orderform.getCustomerId());
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public List<OrderForm> findAllOrderForms(int customerId){
			List<OrderForm> orderforms=new ArrayList<OrderForm>();
			Connection conn=ConnectionFactory.getConnection();
			String sql="select * from orderform where customerid=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, customerId);
				ResultSet rs= pstmt.executeQuery();
				while(rs.next()){
					OrderForm orderform=new OrderForm();
					int id=rs.getInt("id");
					float cost=rs.getFloat("cost");
					java.util.Date orderDate=rs.getDate("Orderdate");
					orderform.setId(id);
					orderform.setCost(cost);
					orderform.setOrderDate(orderDate);
					orderform.setCustomerId(customerId);
					orderforms.add(orderform);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return orderforms;
		}
		

}