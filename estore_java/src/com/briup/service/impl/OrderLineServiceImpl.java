package com.briup.service.impl;

import java.util.List;

import com.briup.bean.Orderline;
import com.briup.dao.OrderLineDao;
import com.briup.service.IOrderLineService;

public class OrderLineServiceImpl implements IOrderLineService{
	/**
	 * 添加订单项
	 * */
	@Override
	public void addOrderLine(Orderline orderline) {
		OrderLineDao orderLineDao = new OrderLineDao();
		orderLineDao.saveOrderLine(orderline);
	}
	/**
	 * 查询订单项
	 * */
	@Override
	public List<Orderline> findAllOrderlines(int orderFromId) {
		OrderLineDao orderLineDao = new OrderLineDao();
		return orderLineDao.findAllOrderLines(orderFromId);
	}

}
