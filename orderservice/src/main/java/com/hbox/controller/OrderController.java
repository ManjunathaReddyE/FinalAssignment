package com.hbox.controller;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hbox.dto.PlaceOrderDTO;
import com.hbox.model.OrderStatus;
import com.hbox.model.Orders;
import com.hbox.service.OrdersService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrdersService ordersService;
	
	@GetMapping("/lastFiveOrders")
	public List<Orders> getLastFiveOrders()
	{
		List<Orders> listOfOrders=ordersService.getListOfOrders();
		return listOfOrders.stream().sorted(Comparator.comparing(Orders::getDate).reversed()).limit(5).collect(Collectors.toList());
	}
	
	@PutMapping("/createOrder")
	public OrderStatus createOrder(@RequestBody PlaceOrderDTO placeOrder)
	{
		return ordersService.placeOrderSystem(placeOrder);
	}
	
	/*@GetMapping("/recentOrders")
	public List<Orders> getRecentOrdersHistry()
	{
		return ordersService.getRecentFiveOrders();
	}*/
	
	
}
