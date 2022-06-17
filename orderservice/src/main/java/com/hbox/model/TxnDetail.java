package com.hbox.model;

public class TxnDetail {
	
	private Long accountId;
	
	private double amount;
		
	private Baccount baccount;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Baccount getBaccount() {
		return baccount;
	}

	public void setBaccount(Baccount baccount) {
		this.baccount = baccount;
	}
	
	
	
}
