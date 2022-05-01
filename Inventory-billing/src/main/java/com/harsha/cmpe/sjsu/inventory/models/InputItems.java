package com.harsha.cmpe.sjsu.inventory.models;

public class InputItems extends Items {
	private String cardNumber;
	public InputItems(String category, String item, int quantity, double price,String cardNumber) {
		super(category, item, quantity, price);
		this.cardNumber=cardNumber;
		// TODO Auto-generated constructor stub
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	@Override
	public String toString() {
		return "InputItems [cardNumber=" + cardNumber + ", Category()=" + getCategory() + ", Item()=" + getItem()
				+ ", Quantity()=" + getQuantity() + ", Price()=" + getPrice() + "]";
	}
	

}
