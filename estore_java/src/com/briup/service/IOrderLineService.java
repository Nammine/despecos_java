package com.briup.service;

import java.util.List;

import com.briup.bean.Orderline;

public interface IOrderLineService {
	/**
	 * 插入一条订单项信息
	 * */
	void addOrderLine(Orderline orderline);
	/**
	 * 根据订单的Id来查找所有属于该订单的订单项
	 * */
	List<Orderline> findAllOrderlines(int orderFromId);
}
