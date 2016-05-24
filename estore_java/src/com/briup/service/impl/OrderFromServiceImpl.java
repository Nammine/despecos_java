package com.briup.service.impl;

import java.util.List;

import com.briup.bean.OrderFrom;
import com.briup.dao.OrderFromDao;
import com.briup.service.IOrderFromService;

public class OrderFromServiceImpl implements IOrderFromService{
	/**
	 * 添加订单
	 * */
	@Override
	public void addOrderFrom(OrderFrom orderFrom) {
		OrderFromDao orderFromDao = new OrderFromDao();
		orderFromDao.saveOrderFrom(orderFrom);
	}
	/**
	 *根据顾客的Id来查找属于他的所有订单
	 * */
	@Override
	public List<OrderFrom> findAllOrderFroms(int customerId) {
		OrderFromDao orderFromDao = new OrderFromDao();
		List<OrderFrom> list = orderFromDao.findAllOrderFroms(customerId);
		return list;
	}

}
