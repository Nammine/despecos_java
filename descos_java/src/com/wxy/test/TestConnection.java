package com.wxy.test;

import java.sql.Connection;

import com.wxy.common.ConnectionFactory;

public class TestConnection {
   public static void main(String[] args){
	   Connection conn=ConnectionFactory.getConnection();
	   if(conn==null){System.out.println("���Ӵ���");}
	   else{System.out.println("lianjiezhengque");}
   }
}
