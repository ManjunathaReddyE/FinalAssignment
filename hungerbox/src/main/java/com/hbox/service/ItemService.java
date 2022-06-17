package com.hbox.service;

import java.util.List;

import com.hbox.model.Items;

public interface ItemService {
	
	List<Items> getItemDetailsByName(String itemName);
	
	List<Items> getItemDetailsByType(String itemType);
	
	String updateItemDetails(Items items);
	
	Items updateItemDetailsById(Items items);
	
	List<Items> getItemDetails(int itemId);
	
	List<Items> getAllAvailItems();

}
