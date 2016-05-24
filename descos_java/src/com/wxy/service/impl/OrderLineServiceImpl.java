package com.wxy.service.impl;

import java.util.List;

import com.wxy.bean.OrderLine;
import com.wxy.dao.OrderLineDao;
import com.wxy.service.IOrderLineService;

public class OrderLineServiceImpl implements IOrderLineService{

	@Override
	public void addOrderLine(OrderLine orderline) {
		// TODO Auto-generated method stub
		OrderLineDao orderLineDao=new OrderLineDao();
		orderLineDao.saveOrderLine(orderline);
	}

	@Override
	public List<OrderLine> findAllOrderlines(int orderFormId) {
		// TODO Auto-generated method stub
        OrderLineDao orderLineDao=new OrderLineDao();
		return orderLineDao.findAllOrderLines(orderFormId);
	}

}
