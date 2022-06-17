package com.hbox.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hbox.model.Items;
import com.hbox.model.OrderStatus;
import com.hbox.repository.ItemRepository;
import com.hbox.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<Items> getAllAvailItems() {
		try {
			//System.out.println("service==="+itemRepository.findAll());
			return itemRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Items> getItemDetailsByName(String itemName) {
		//System.out.println("==serviceImpl==:"+itemName);
		return itemRepository.findByItemName(itemName);
	}
	
	public List<Items> getItemDetailsByType(String itemType) {
		//System.out.println("==serviceImpl==:"+itemType);
		return itemRepository.findByItemType(itemType);
	}
	
	public List<Items> getItemDetails(int itemId) {
		List<Items> list=new ArrayList<Items>(); 
		Optional<Items> itemObj = itemRepository.findById(itemId); 
		if(itemObj.isPresent()) 
		{
			list.add(itemObj.get());
			return list;
		} 
		return null;
	}
	
	public String updateItemDetails(Items items) {
		try {
			itemRepository.save(items);
			return "Success";
		} catch (Exception e) {
			return "Failed...!";
		}
	}
	
	
	public Items updateItemDetailsById(Items items) {
		try {
			return itemRepository.save(items);
		} catch (Exception e) {
			return items;
		}
	}
	
	public Items getItemDetail(int itemId) {
		
		Optional<Items> itemObj = itemRepository.findById(itemId);
		if (itemObj.isPresent()) {
			return itemObj.get();
		}
		return null;
	}
	
		public Items updateItemQty(int itemId,int qty) {
		Items items=new Items();
		try {
			items=getItemDetail(itemId);
			items.setQuantity(qty);
			return itemRepository.save(items);
		} catch (Exception e) {
			return items;
		}
		
	}
	
}
