package com.wxy.service.impl;

import java.util.List;

import com.wxy.bean.OrderForm;
import com.wxy.dao.OrderFormDao;
import com.wxy.service.IOrderFormService;

public class OrderFormServiceImpl implements IOrderFormService{

	@Override
	public void addOrderForm(OrderForm orderform) {
		// TODO Auto-generated method stub
		OrderFormDao orderformdao=new OrderFormDao();
		orderformdao.saveOrderForm(orderform);
	}

	@Override
	public List<OrderForm> findAllOrderFroms(int customerId) {
		// TODO Auto-generated method stub
		OrderFormDao orderformdao=new OrderFormDao();
		List<OrderForm> list =orderformdao.findAllOrderForms(customerId);
		return list;
	}

}
