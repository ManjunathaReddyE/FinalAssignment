package com.hbox.model;

public class OrderStatus {
	
	private Long orderId;
	private String status;
	//private Date orderDate;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	

}
