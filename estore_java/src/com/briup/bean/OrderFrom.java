package com.briup.bean;

import java.util.Date;

public class OrderFrom {
	private int id;
	private float cost;
	private Date orderdate;
	private int customerid;
	
	public OrderFrom(){
		
	}
	public OrderFrom(int id, float cost, Date orderdate, int customerid) {
		super();
		this.id = id;
		this.cost = cost;
		this.orderdate = orderdate;
		this.customerid = customerid;
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
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "OrderFrom [id=" + id + ", cost=" + cost + ", orderdate="
				+ orderdate + ", customerid=" + customerid + "]";
	}
}
