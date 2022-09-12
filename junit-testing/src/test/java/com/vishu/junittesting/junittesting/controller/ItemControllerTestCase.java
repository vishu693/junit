package com.vishu.junittesting.junittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vishu.controller.ItemController;
import com.vishu.model.Item;
import com.vishu.service.ItemService;


@WebMvcTest(ItemController.class)
class ItemControllerTestCase {
	
	@Autowired
	private MockMvc mocMvc;
	
	@MockBean
	private ItemService itemService;

	@Test
	public void item_basic() throws Exception {
		
		
		RequestBuilder request=MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON); 
		MvcResult result = mocMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":1,\"name\":\"ball\",\"quantity\":10,\"price\":1000,\"value\":0}"))
				.andReturn();
	
	}
	
	@Test
	public void item_service() throws Exception {
		
		when(itemService.retriveElements()).thenReturn( new Item(1, "ball", 10, 10));
		
		
		RequestBuilder request=MockMvcRequestBuilders.get("/item-from-service").accept(MediaType.APPLICATION_JSON); 
		MvcResult result = mocMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("{\"id\":1,\"name\":\"ball\",\"quantity\":10,\"price\":10,\"value\":0}"))
				.andReturn();
	
	}
	
	@Test
	public void item_service_database() throws Exception {
		
		//Arrays.asList(new Item(1,"bag1",100,1000));
		
		when(itemService.retriveElementsfromDB()).thenReturn(Arrays.asList(new Item(1,"ball",10,10)));
		
		
		RequestBuilder request=MockMvcRequestBuilders.get("/item-from-service-database").accept(MediaType.APPLICATION_JSON); 
		MvcResult result = mocMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("[{\"id\":1,\"name\":\"ball\",\"quantity\":10,\"price\":10,\"value\":0}]"))
				.andReturn();
	
	}
	

}
