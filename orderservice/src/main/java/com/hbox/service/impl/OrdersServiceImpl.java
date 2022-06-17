package com.hbox.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hbox.account.feignclient.FundTransferClient;
import com.hbox.dto.PlaceOrderDTO;
import com.hbox.item.feignclient.UpdateItemClient;
import com.hbox.model.Baccount;
import com.hbox.model.ItemsDetail;
import com.hbox.model.OrderStatus;
import com.hbox.model.Orders;
import com.hbox.model.TxnDetail;
import com.hbox.repository.OrdersRepository;
import com.hbox.service.OrdersService;
import com.hbox.util.GenerateOrderSequance;
@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository ordersRepo;
	
	@Autowired
	FundTransferClient fundTransferClient;
	
	//@Autowired
	//BenficiaryAccClient BenficAccClient;
	
	@Autowired
	UpdateItemClient itemClient;
	
	@Autowired
	GenerateOrderSequance geneOrderSeq;

	@Override
	public List<Orders> getListOfOrders() {
		return ordersRepo.findAll();
	}

	@Override
	public OrderStatus placeOrderSystem(PlaceOrderDTO placeOrder) {

		java.util.Date date = new java.util.Date();
		Orders orders=new Orders();
		OrderStatus os=new OrderStatus();
		ItemsDetail item=placeOrder.getItem();
		Long fromaccno=placeOrder.getFromAcc();
		Baccount bacc=placeOrder.getBaccount();
		int iqty=item.getQuantity();
		double iprice=item.getPrice();
		double orderPrice=iqty*iprice;
		TxnDetail txnDetail=new TxnDetail();
		txnDetail.setAccountId(fromaccno);
		txnDetail.setBaccount(bacc);
		//BenficAccClient.getBeneficearyAccountByAccNo(accountNumber)
		//System.out.println("==fundtranser start:::");
		ResponseEntity<String> res1=fundTransferClient.fundTransfer(txnDetail);
		System.out.println("Fund Transfer: res1 "+res1.getBody());
		List<ItemsDetail> iteml=itemClient.getItemDetails(item.getItemId());
		ItemsDetail it1=iteml.get(iteml.size()-1);
		int uqty=it1.getQuantity()-iqty;
		it1.setQuantity(uqty);
		String res3=itemClient.updateItemDetails(it1);
		System.out.println("Update item quantity res3="+res3);
		
		if(res1.getBody().contains("Success") && res3.equals("Success"))
		{
		Long oid=geneOrderSeq.generateOrderId();
		System.out.println("::Generating order::");
		orders.setOrderId(oid);
		orders.setAccno(fromaccno);
		orders.setOrderName(placeOrder.getItem().getItemType());
		orders.setOrderPrice(orderPrice);
		orders.setOrderType(placeOrder.getItem().getItemType());
		orders.setQuantity(placeOrder.getItem().getQuantity());
		//System.out.println("date=="+Date.valueOf(LocalDate.now()));
		orders.setDate(date);
		System.out.println("Generated order : "+oid);
		ordersRepo.save(orders);
		os.setStatus("Order Created Successfully..");
		os.setOrderId(oid);
		return os;
		}
		return os;
	}
}
	
	
	
	

