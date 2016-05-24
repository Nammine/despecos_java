package com.briup.service;

import com.briup.bean.Customer;

public interface ICustomerService {
	/**
	 * 登录
	 * */
	Customer login(String name,String password);
}
