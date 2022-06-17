package com.hbox.service.exeptions;

public class OrderHistoryNotFoundException extends Exception {

	public OrderHistoryNotFoundException() {
		super();
	}

	public OrderHistoryNotFoundException(String message) {
		super(message);
		System.out.println("Exception: "+message);
	}

	public OrderHistoryNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
