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
import java.util.ArrayList;
import java.util.List;

import com.wxy.bean.OrderLine;
import com.wxy.common.ConnectionFactory;

public class OrderLineDao {
	public void saveOrderLine(OrderLine orderline){
		Connection conn=ConnectionFactory.getConnection();
		String sql="insert into orderline values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, orderline.getId());
			pstmt.setInt(2, orderline.getNum());
			pstmt.setInt(3, orderline.getOrderFormId());
			pstmt.setString(4, orderline.getCosmeticName());
			pstmt.setFloat(5, orderline.getCosmeticPrice());
			pstmt.setFloat(6, orderline.getTotal());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<OrderLine> findAllOrderLines(int orderFormId){
		List<OrderLine> orderLines=new ArrayList<OrderLine>();
		Connection conn=ConnectionFactory.getConnection();
		String sql="Select * from orderline where orderFormId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, orderFormId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				OrderLine orderline=new OrderLine();
				int id=rs.getInt("id");
				int num=rs.getInt("num");
				String cosmeticName=rs.getString("cosmeticName");
				float cosmeticPrice=rs.getFloat("cosmeticPrice");
				float total=rs.getFloat("total");
				orderline.setId(id);
				orderline.setNum(num);
				orderline.setCosmeticName(cosmeticName);
				orderline.setCosmeticPrice(cosmeticPrice);
				orderline.setTotal(total);
				orderline.setOrderFormId(orderFormId);
				orderLines.add(orderline);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderLines;
	}
}
