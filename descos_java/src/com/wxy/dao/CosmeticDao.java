package com.wxy.dao;
/**
 * 
 * @author wxywxy
 * 通过cosmetic找到化妆品/找到所有存在的化妆品
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wxy.bean.Cosmetic;
import com.wxy.common.ConnectionFactory;

public class CosmeticDao {
	/**
	 * 找到化妆品
	 * @param cosmeticId
	 * @return
	 */
	public Cosmetic findCosmeticById(int cosmeticId){
		Cosmetic cosmetic =null;
		Connection conn=ConnectionFactory.getConnection();
		String sql="select * from cosmetic where id = ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cosmeticId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				cosmetic = new Cosmetic();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				float price = rs.getFloat("price");
				cosmetic.setId(id);
				cosmetic.setName(name);
				cosmetic.setDescription(description);
				cosmetic.setPrice(price);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cosmetic;
		
	}
	/**
	 * 找到所有的化妆品
	 * @return
	 */
	public List<Cosmetic> findAllCosmetics() {
		Connection conn = ConnectionFactory.getConnection();
		List<Cosmetic> cosmetics = new ArrayList<>();
		try {
			Statement stms = conn.createStatement();
			String sql = "select * from cosmetic";
			ResultSet rs = stms.executeQuery(sql);
			int flag = 0;
			while(rs.next()){
				Cosmetic cosmetic=new Cosmetic();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				float price = rs.getFloat("price");
				cosmetic.setId(id);
				cosmetic.setName(name);
				cosmetic.setDescription(description);
				cosmetic.setPrice(price);
				cosmetics.add(cosmetic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cosmetics;
	}
}
