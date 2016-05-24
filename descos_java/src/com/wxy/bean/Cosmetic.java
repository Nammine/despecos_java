package com.wxy.bean;
/**
 * 
 * @author wxywxy
 * 
 */
public class Cosmetic {
	private int id;
	private String name;
	private String description;
	private float price;
	public Cosmetic(){
		
	}
	public Cosmetic(int id, String name, String description, float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
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
		return "Cosmetic [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + "]";
	}
}
