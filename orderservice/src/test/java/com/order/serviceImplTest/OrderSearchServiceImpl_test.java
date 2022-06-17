package com.order.serviceImplTest;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hbox.dto.PlaceOrderDTO;
import com.hbox.model.Baccount;
import com.hbox.model.ItemsDetail;
import com.hbox.model.OrderStatus;
import com.hbox.repository.OrdersRepository;
import com.hbox.service.impl.OrdersServiceImpl;


@RunWith(MockitoJUnitRunner.class)
 class OrderSearchServiceImpl_test {

	@InjectMocks
	OrdersServiceImpl ordersServiceImpl;
	
	@Mock
	OrdersRepository orderRepo;
	
	@Test
	public void placeOrderSystemTestP() 
	{
		PlaceOrderDTO placeOrderDTO=new PlaceOrderDTO();
		ItemsDetail item=new ItemsDetail(1,"idle", "dosa",35.00, 3);
		Baccount baccount=new Baccount();
		baccount.setAccountId(21313l);
		placeOrderDTO.setFromAcc(32423l);
		placeOrderDTO.setItem(item);
		placeOrderDTO.setBaccount(baccount);
		OrderStatus orderStatus=new OrderStatus();
		orderStatus.setOrderId(12345l);
		orderStatus.setStatus("success");
		try {
		when(ordersServiceImpl.placeOrderSystem(placeOrderDTO)).thenReturn(orderStatus);
		
		Assertions.assertNotNull(orderStatus);
		
		Assertions.assertTrue(orderStatus.getOrderId()!=0);
		}catch(Exception e)
		{
			Assertions.fail();
		}
	}
	@Test
	public void placeOrderSystemTestN() 
	{
		PlaceOrderDTO placeOrderDTO=new PlaceOrderDTO();
		ItemsDetail item=new ItemsDetail(1,"idle", "dosa",35.00, 3);
		Baccount baccount=new Baccount();
		baccount.setAccountId(21313l);
		placeOrderDTO.setFromAcc(32423l);
		placeOrderDTO.setItem(item);
		placeOrderDTO.setBaccount(baccount);
		OrderStatus orderStatus=new OrderStatus();
		orderStatus.setOrderId(12345l);
		orderStatus.setStatus("success");
		try {
		when(ordersServiceImpl.placeOrderSystem(placeOrderDTO)).thenReturn(orderStatus);
		
		Assertions.assertNotNull(orderStatus);
		
		Assertions.assertTrue(orderStatus.getOrderId()==0);
		}catch(Exception e)
		{
			Assertions.fail();
		}
	}
}
