package com.vishu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishu.model.Item;
import com.vishu.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item retriveElements() {
		// TODO Auto-generated method stub
		return new Item(1, "ball", 10, 1000);
	}

	
	public List<Item> retriveElementsfromDB() {
		// TODO Auto-generated method stub
		List<Item> itemList=itemRepository.findAll();
		for(Item item:itemList)
		{
		item.setValue(item.getPrice()*item.getQuantity());
		}
		return itemList;
		
	}

}
