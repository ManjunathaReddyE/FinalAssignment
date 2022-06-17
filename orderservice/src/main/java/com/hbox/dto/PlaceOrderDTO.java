package com.hbox.dto;
import com.hbox.model.Baccount;
import com.hbox.model.ItemsDetail;

public class PlaceOrderDTO {
	
	private Long fromAcc;
	private Baccount baccount;
	
	private ItemsDetail item;
	
	public Long getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(Long fromAcc) {
		this.fromAcc = fromAcc;
	}
	
	public ItemsDetail getItem() {
		return item;
	}
	public void setItem(ItemsDetail item) {
		this.item = item;
	}
	public Baccount getBaccount() {
		return baccount;
	}
	public void setBaccount(Baccount baccount) {
		this.baccount = baccount;
	}
	
}
