package com.hbox.util;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;
@Component
public class GenerateOrderSequance {
	Long id=100023L;
	final AtomicLong orderIdGenerator = new AtomicLong(0);
	public Long generateOrderId()
	{
		id=id+orderIdGenerator.incrementAndGet();
		//System.out.println("sr=="+orderIdGenerator.incrementAndGet());
		return id;
	}
	
}
