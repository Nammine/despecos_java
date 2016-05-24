package com.briup.bean;
/**
 * @author licy
 * */
public class Book {
	/*
	 * 
	 * */
	//属性
	private int id;
	private String name;
	private String description;
	private float price;
	//无参构造器
	public Book(){
		
	}
	//有参构造器
	public Book(int id, String name, String description, float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	//setter getter方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + "]";
	}
}
