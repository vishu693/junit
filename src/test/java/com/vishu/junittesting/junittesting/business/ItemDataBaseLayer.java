package com.vishu.junittesting.junittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.vishu.model.Item;
import com.vishu.repository.ItemRepository;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class ItemDataBaseLayer {

	@Autowired
	ItemRepository repository;
	
	@Test
	void testFindAll() {
		List<Item> item=repository.findAll();
		assertEquals(3, item.size());
	}

}
