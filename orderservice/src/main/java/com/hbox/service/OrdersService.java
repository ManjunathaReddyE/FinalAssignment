package com.hbox.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.hbox.dto.PlaceOrderDTO;
import com.hbox.model.OrderStatus;
import com.hbox.model.Orders;

@Service
public interface OrdersService {
	
	public List<Orders> getListOfOrders();
	
	//public List<Orders> getRecentFiveOrders();
	
	public OrderStatus placeOrderSystem(PlaceOrderDTO placeOrder);

}
