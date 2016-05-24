package com.briup.bean;

public class Orderline {
	private int id;
	private int num;
	private int orderFromId;
	private String bookName;
	private float bookPrice;
	private float total;
	
	public Orderline(){}
	public Orderline(int id, int num, int orderFromId, String bookName,
			float bookPrice, float total) {
		super();
		this.id = id;
		this.num = num;
		this.orderFromId = orderFromId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
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
	public int getOrderFromId() {
		return orderFromId;
	}
	public void setOrderFromId(int orderFromId) {
		this.orderFromId = orderFromId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Orderline [id=" + id + ", num=" + num + ", orderFromId="
				+ orderFromId + ", bookName=" + bookName + ", bookPrice="
				+ bookPrice + ", total=" + total + "]";
	}
}
