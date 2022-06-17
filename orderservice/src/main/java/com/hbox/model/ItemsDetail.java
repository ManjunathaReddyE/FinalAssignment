package com.hbox.model;

public class ItemsDetail {

	private Integer itemId;
	private String itemName;
	private String itemType;
	private double price;
	private Integer quantity;
	
	public ItemsDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemsDetail(Integer itemId, String itemName, String itemType, double price, Integer quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.price = price;
		this.quantity = quantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
