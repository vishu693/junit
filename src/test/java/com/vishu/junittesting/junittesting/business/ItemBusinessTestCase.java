package com.vishu.junittesting.junittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vishu.model.Item;
import com.vishu.repository.ItemRepository;
import com.vishu.service.ItemService;

@ExtendWith(MockitoExtension.class)
class ItemBusinessTestCase {
	
	@InjectMocks
	private ItemService itemService;
	
	@Mock
	private ItemRepository itemRepository;

	@Test
	void calculateSumUsingDataService_basic() {
	
		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1,"ball1",10,10),new Item(2,"ball2",20,20)));
		List<Item> list=itemService.retriveElementsfromDB();
		
		assertEquals(100,list.get(0).getValue());
		assertEquals(400,list.get(1).getValue());
	}

}
