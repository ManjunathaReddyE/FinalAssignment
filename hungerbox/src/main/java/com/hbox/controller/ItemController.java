package com.hbox.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hbox.model.Items;
import com.hbox.service.ItemService;

@RestController
@RequestMapping("/dish")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	
	@GetMapping("/dishitems")
	public List<Items> getAllAvailItems() {
		System.out.println("itemcontroller======");
		return itemService.getAllAvailItems();
	}
	
	@GetMapping("/{itemId}")
	public List<Items> getItemDetails(@PathVariable int itemId) {
		return itemService.getItemDetails(itemId);
	}
	
	@GetMapping("/item/{itemName}")
	public List<Items> getItemDetailsByName(@PathVariable String itemName) {
		System.out.println("controller==="+itemName);
		return itemService.getItemDetailsByName(itemName);
	}
	
	@GetMapping("/itemType/{itemType}")
	public List<Items> getItemDetailsByType(@PathVariable String itemType) {
		System.out.println("controller==="+itemType);
		return itemService.getItemDetailsByType(itemType);
	}
	
	@PutMapping("/updateItems")
	public String updateItemDetails(@RequestBody Items items) {
		return itemService.updateItemDetails(items);
	}
	
	@PutMapping("/updateItems/{itemId}")
	public Items updateItemDetailsById(@RequestBody Items items) {
		return itemService.updateItemDetailsById(items);
	}
}
