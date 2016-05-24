package com.wxy.common;
/**
 * 
 * @author wxywxy
 *
 */
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class HL {
	private static int high;
	private static int low = 1;
	
	/*select high------>update high*/
	synchronized private static void bisic(){
		Connection conn = ConnectionFactory.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String query = "select high from HL";
			rs = stmt.executeQuery(query);
			while(rs.next()){
				high = rs.getInt(1);
			}
			String update = "update HL set high="+(high+1);
			System.out.println(update);
			stmt.executeUpdate(update);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**/
	public static int getId(){
		int id = 0;
		if(high==0){
			bisic();
		}
		id = Integer.parseInt(high+""+(low++));
		return id;
	}
/*	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(getId());
		}
	}*/
}
