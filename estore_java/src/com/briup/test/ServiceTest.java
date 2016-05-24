package com.briup.test;

import com.briup.bean.Customer;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

public class ServiceTest {
	public static void main(String[] args) {
		ICustomerService customerService = new CustomerServiceImpl();
		
		Customer customer = customerService.login("briup", "briup");
		
		System.out.println(customer);
	}
}
