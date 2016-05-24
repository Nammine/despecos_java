package com.wxy.service.impl;
/**
 * 
 */
import com.wxy.bean.Customer;
import com.wxy.dao.CustomerDao;
import com.wxy.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{

	@Override
	public Customer login(String name, String password) {
		// TODO Auto-generated method stub
			CustomerDao customerDao=new CustomerDao();
			Customer customer=customerDao.findCustomer(name, password);
			return customer;
	}

	@Override
	public boolean addCustomer(String name, String password, String zip,
			String address, String telephone, String email) {
		// TODO Auto-generated method stub
		CustomerDao customerDao=new CustomerDao();
		boolean i=customerDao.addCustomer(name,password,zip,
				address, telephone, email);
		return i;
	}

}
