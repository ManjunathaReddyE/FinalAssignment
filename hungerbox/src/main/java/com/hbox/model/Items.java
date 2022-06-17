package com.hbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "category_items")
public class Items {
	
	@Id
	@Column(name = "itemId")
	private Integer itemId;
	@Column(name = "itemName")
	private String itemName;
	@Column(name = "itemType")
	private String itemType;
	@Column(name = "price")
	private double price;
	
	@Column(name = "quantity")
	 private Integer quantity;
	
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Items(Integer itemId, String itemName, String itemType, double price, Integer quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.price = price;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	

}
