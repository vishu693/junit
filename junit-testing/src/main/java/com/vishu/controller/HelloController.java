package com.vishu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/helloworld")
	public String getHello()
	{
		return "helloworld";
	}

}
