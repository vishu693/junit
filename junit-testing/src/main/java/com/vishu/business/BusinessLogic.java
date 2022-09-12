package com.vishu.business;

import java.util.Arrays;

import com.vishu.data.SomeDataService;

public class BusinessLogic {
	
	
	private SomeDataService dataService;
	
	
	public Integer addition(Integer [] data)
	{
		return Arrays.asList(data).stream().mapToInt(Integer::intValue).sum();
	}
	
	public Integer addition_DataService()
	{
		//System.out.println(dataService.retriveData().toString());
		return Arrays.asList(dataService.retriveData()).stream().mapToInt(Integer::intValue).sum();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public SomeDataService getDataService() {
		return dataService;
	}

	public void setDataService(SomeDataService dataService) {
		this.dataService = dataService;
	}
	
	
	

}
