package com.vishu.junittesting.junittesting.jsonAssert;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertCase {
	
	String actual="{\"id\":1,\"name\":\"ball\",\"quantity\":10,\"price\":1000}";

	@Test
	public void jsonAssert_strickt_true_Exact_match_expected_spaces() throws JSONException {
		
		String expected="{\"id\":1,\"name\":\"ball\",\"quantity\":10,\"price\":1000}";
		JSONAssert.assertEquals(expected,actual,true);
	}

	
	@Test
	public void jsonAssert_strickt_false() throws JSONException {
		
		String expected="{\"id\":1,\"name\":\"ball\",\"quantity\":10,\"price\":1000}";
		JSONAssert.assertEquals(expected,actual,false);
	}

	
	@Test
	public void jsonAssert_strickt_false_withoutescape() throws JSONException {
		
		String expected="{id:1,name:ball,quantity:10,price:1000}";
		JSONAssert.assertEquals(expected,actual,false);
	}
	
	
	@Test
	public void jsonAssert_strickt_true_withoutescape() throws JSONException {
		
		String expected="{id:1,name:ball,quantity:10,price:1000}";
		JSONAssert.assertEquals(expected,actual,false);
	}
	
	
	

}
