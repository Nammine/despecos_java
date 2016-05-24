package com.wxy.bean;
/**
 * 
 * @author wxywxy
 *
 */
public class OrderLine {
	private int id;
	private int num;
	private int orderFormId;
	private String cosmeticName;
	private float cosmeticPrice;
	private float total;
	public OrderLine(){}
	public OrderLine(int id, int num, int orderFormId, String cosmeticName,
			float cosmeticPrice, float total) {
		super();
		this.id = id;
		this.num = num;
		this.orderFormId = orderFormId;
		this.cosmeticName = cosmeticName;
		this.cosmeticPrice = cosmeticPrice;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getOrderFormId() {
		return orderFormId;
	}
	public void setOrderFormId(int OrderFormId) {
		this.orderFormId = OrderFormId;
	}
	public String getCosmeticName() {
		return cosmeticName;
	}
	public void setCosmeticName(String cosmeticName) {
		this.cosmeticName = cosmeticName;
	}
	public float getCosmeticPrice() {
		return cosmeticPrice;
	}
	public void setCosmeticPrice(float cosmeticPrice) {
		this.cosmeticPrice = cosmeticPrice;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
