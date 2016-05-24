package com.briup.test;

import java.util.List;

import com.briup.bean.Orderline;
import com.briup.dao.OrderLineDao;



public class DaoTest {
	public static void main(String[] args) {
		OrderLineDao orderLineDao = new OrderLineDao();
		Orderline orderline = new Orderline();
		orderline.setId(1);
		orderline.setBookName("java核心技术");
		orderline.setBookPrice(123);
		orderline.setNum(3);
		orderline.setOrderFromId(1);
		orderLineDao.saveOrderLine(orderline);
		
		List<Orderline> orderlines = orderLineDao.findAllOrderLines(1);
		for(int i=0;i<orderlines.size();i++){
			System.out.println(orderlines.get(i));
		}
		
	}
}
