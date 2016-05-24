package com.wxy.service;
/**
 * 
 */
import java.util.List;

import com.wxy.bean.OrderForm;

public interface IOrderFormService {
    void addOrderForm(OrderForm orderform);
	List<OrderForm> findAllOrderFroms(int customerId);
}
