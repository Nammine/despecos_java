package com.briup.service;

import java.util.List;

import com.briup.bean.OrderFrom;

public interface IOrderFromService {
	/**
	 * 添加一个orderFrom
	 * */
	void addOrderFrom(OrderFrom orderFrom);
	/**
	 * 根据用户Id来查找该用户所用有的orderFrom
	 * */
	List<OrderFrom> findAllOrderFroms(int customerId);
}
