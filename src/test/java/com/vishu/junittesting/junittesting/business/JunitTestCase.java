package com.vishu.junittesting.junittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.vishu.business.BusinessLogic;
import com.vishu.data.SomeDataService;


class SomeDataServiceStub implements SomeDataService
{

	@Override
	public Integer[] retriveData() {
		// TODO Auto-generated method stub
		return new Integer[] {1,2,3} ;
	}
	
}

class SomeDataServiceEmptyStub implements SomeDataService
{

	@Override
	public Integer[] retriveData() {
		// TODO Auto-generated method stub
		return new Integer[] {} ;
	}
	
}

class SomeDataServiceOneStub implements SomeDataService
{

	@Override
	public Integer[] retriveData() {
		// TODO Auto-generated method stub
		return new Integer[] {5} ;
	}
	
}



class JunitTestCase {

	@Test
	void addition_basic() {
		BusinessLogic obj=new BusinessLogic();
		int actualResult=obj.addition(new Integer[] {1,2,3});
		int expectedResult=6;
		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	void addition_zero() {
		BusinessLogic obj=new BusinessLogic();
		int actualResult=obj.addition(new Integer[] {});
		int expectedResult=0;
		assertEquals(expectedResult,actualResult);
	}
	
	
	@Test
	void addition_DataService() {
		BusinessLogic obj=new BusinessLogic();
		obj.setDataService(new SomeDataServiceStub());
		int actualResult=obj.addition_DataService();
		int expectedResult=6;
		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	void addition_DataServiceEmpty() {
		BusinessLogic obj=new BusinessLogic();
		obj.setDataService(new SomeDataServiceEmptyStub());
		int actualResult=obj.addition_DataService();
		int expectedResult=0;
		assertEquals(expectedResult,actualResult);
	}

	@Test
	void addition_DataServiceWithOneElement() {
		BusinessLogic obj=new BusinessLogic();
		obj.setDataService(new SomeDataServiceOneStub());
		int actualResult=obj.addition_DataService();
		int expectedResult=5;
		assertEquals(expectedResult,actualResult);
	}
}
