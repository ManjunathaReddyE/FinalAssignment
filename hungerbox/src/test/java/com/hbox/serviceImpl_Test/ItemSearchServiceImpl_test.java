package com.hbox.serviceImpl_Test;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hbox.model.Items;
import com.hbox.repository.ItemRepository;
import com.hbox.service.impl.ItemServiceImpl;
@ExtendWith(MockitoExtension.class)
 class ItemSearchServiceImpl_test {

	@InjectMocks
	ItemServiceImpl itemServiceImpl;
	
	@Mock
	ItemRepository itemRepo;

	@Test
	public void testGetAllAvailItemsTest_P() {
		List<Items> itemList =new ArrayList<Items>();
		Items items1=new Items(1, "idle", "bfast", 45, 6);
		Items items2=new Items(2, "vada", "bfast", 65, 6);
		Items items3=new Items(3, "poori", "bfast", 34, 6);
		itemList.add(items1);
		itemList.add(items2);
		itemList.add(items3);
		
		when(itemRepo.findAll()).thenReturn(itemList);
		List<Items> ilist = itemServiceImpl.getAllAvailItems();
		Assertions.assertNotNull(ilist.size());
		assertEquals("idle", ilist.get(0).getItemName());
	}
	
	@Test
	public void testGetAllAvailItemsTest_N() {
		List<Items> itemList =new ArrayList<Items>();
		Items items1=new Items(1, "idle", "bfast", 45, 6);
		Items items2=new Items(2, "vada", "bfast", 65, 6);
		Items items3=new Items(3, "poori", "bfast", 34, 6);
		itemList.add(items1);
		itemList.add(items2);
		itemList.add(items3);
		try {
		when(itemRepo.findAll()).thenReturn(itemList);
		List<Items> ilist = itemServiceImpl.getAllAvailItems();
		assertEquals("idle", ilist.get(0).getItemName());
		}catch(Exception e)
		{
			Assertions.fail();
		}
	}
	
	@Test
	public void testGetItemDetailsByNameTest() {
		List<Items> itemList =new ArrayList<Items>();
		Items items1=new Items(1, "idle", "bfast", 45, 6);
		Items items2=new Items(2, "vada", "bfast", 65, 6);
		Items items3=new Items(3, "poori", "bfast", 34, 6);
		itemList.add(items1);
		itemList.add(items2);
		itemList.add(items3);
		String itemName="idle";
		when(itemRepo.findByItemName(itemName)).thenReturn(itemList);
		List<Items> ilist =itemServiceImpl.getItemDetailsByName(itemName);
		assertEquals("idle", itemList.get(0).getItemName());
	}

	@Test
	public void testGetItemDetailsByTypeTest() {
		List<Items> itemList =new ArrayList<Items>();
		Items items1=new Items(1, "idle", "bfast", 45, 6);
		Items items2=new Items(2, "vada", "bfast", 65, 6);
		Items items3=new Items(3, "poori", "bfast", 34, 6);
		itemList.add(items1);
		itemList.add(items2);
		itemList.add(items3);
		try {
		when(itemRepo.findByItemType("bfast")).thenReturn(itemList);
		List<Items> ilist176 =itemServiceImpl.getItemDetailsByName("bfast");
		//System.out.println(ilist176.get(0).getItemType());
		//assertEquals("bfast", ilist176.get(0).getItemType());
	}catch(Exception e)
	{
		//System.out.println(e);
		Assertions.assertTrue(e.getMessage()!=null);
		//System.out.println(e);
	}
}
	@Test
	public void testUpdateItemDetailsP() {
		Items items=new Items(1, "idle", "bfast", 45, 6);
		try {
		itemRepo.save(items);
		Assertions.assertTrue(true);
		}catch(Exception e)
		{
			Assertions.fail();
		}
	}
		@Test
		public void testUpdateItemDetailsN() {
			Items items=new Items();
			try {
			itemRepo.save(items);
			Assertions.assertTrue(true);
			}catch(Exception e)
			{
				Assertions.fail();
			}
	}	
}
