package com.vishu.junittesting.junittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vishu.controller.HelloController;


@WebMvcTest(HelloController.class)
class HelloControllerTestCase {
	
	@Autowired
	private MockMvc mocMvc;

	@Test
	public void helloWord_basic() throws Exception {
		
		//call /helloworld
		RequestBuilder request=MockMvcRequestBuilders.get("/helloworld").accept(MediaType.APPLICATION_JSON); 
		MvcResult result = mocMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("helloworld"))
				.andReturn();
		
	//verify
	//	assertEquals("helloworld",result.getResponse().getContentAsString());
	
	}

}
