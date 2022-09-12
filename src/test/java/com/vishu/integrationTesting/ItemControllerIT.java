package com.vishu.integrationTesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemControllerIT {
	
	@Autowired
	private TestRestTemplate restTemplate;
	

	@Test
	void contextLods_Ids() throws JSONException {
	String response=this.restTemplate.getForObject("/item-from-service-database", String.class);
	JSONAssert.assertEquals("[{id:1},{id:2},{id:3}]", response, false);
	}
	
	
	@Test
	void contextLods_name() throws JSONException {
	String response=this.restTemplate.getForObject("/item-from-service-database", String.class);
	JSONAssert.assertEquals("[{name:bag1},{name:bag2},{name:bag3}]", response, false);
	}


}
