package com.wxy.bean;
/**
 * 
 * @author wxywxy
 *
 */
import java.util.Date;

public class OrderForm {
	private int id;
	private float cost;
	private Date orderDate;
	private int customerId;
	public OrderForm(){}
	public OrderForm(int id, float cost, Date orderDate, int customerId) {
		super();
		this.id = id;
		this.cost = cost;
		this.orderDate = orderDate;
		this.customerId = customerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
}
