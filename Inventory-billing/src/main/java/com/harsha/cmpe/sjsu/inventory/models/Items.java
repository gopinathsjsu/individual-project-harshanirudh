package com.harsha.cmpe.sjsu.inventory.models;

public class Items {
	private String category;
	private String item;
	private int quantity;
	private double price;
	
	public Items(String category, String item, int quantity, double price) {
		super();
		this.category = category;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Items [category=" + category + ", item=" + item + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	
}
