package com.wxy.service;
/**
 * 
 */
import com.wxy.bean.Customer;

public interface ICustomerService {
	Customer login(String name,String password);
	boolean addCustomer(String name, String password, String zip,
			String address, String telephone, String email);
}
