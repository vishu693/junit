package com.vishu.junittesting.junittesting.jsonPath;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

class JsonPathTestCase {

	@Test
	void test() {

	String expectedJson="[{\"id\":1,\"name\":\"vishal\",\"quantity\":10},{\"id\":2,\"name\":\"vishal1\",\"quantity\":100},{\"id\":3,\"name\":\"vishal2\",\"quantity\":1000}]";	
	
	DocumentContext context=JsonPath.parse(expectedJson);
	
	int length=context.read("$.length()");
	System.out.println("length="+length);
	//assertThat(length).isEqualTo(3);
	
	List<Integer> ids=context.read("$..id");
	System.out.println("ids="+ids);
	//assertThat(ids).containsExactly(10,100);
	
	System.out.println(context.read("$.[1]").toString());
	System.out.println(context.read("$.[0:1]").toString());
	
	
	}

}
