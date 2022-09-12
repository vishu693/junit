package com.vishu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishu.model.Item;
import com.vishu.service.ItemService;
@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item")
	public Item getItem()
	{
		return new Item(1, "ball", 10, 1000);
	}
	
	
	@GetMapping("/item-from-service")
	public Item getItemfromService()
	{
		return itemService.retriveElements();
			
	}
	
	@GetMapping("/item-from-service-database")
	public List<Item> getItemfromServicefromDatabase()
	{
		return itemService.retriveElementsfromDB();
			
	}

}
