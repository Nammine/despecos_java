package com.briup.service.impl;

import com.briup.bean.Customer;
import com.briup.dao.CustomerDao;
import com.briup.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{
	/**
	 * 登录
	 * */
	@Override
	public Customer login(String name, String password) {
		//实例化dao对象
		CustomerDao customerDao = new CustomerDao();
		Customer customer = 
				customerDao.findCustomer(name, password);
		return customer;
	}
	
}
