package com.vishu.junittesting.junittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vishu.business.BusinessLogic;
import com.vishu.data.SomeDataService;




@ExtendWith(MockitoExtension.class)
class JunitTestCaseMock {

	@InjectMocks
	BusinessLogic business=new BusinessLogic();
	
	@Mock
	SomeDataService someDataServiceMock=mock(SomeDataService.class);
	
	/*
	 * @BeforeEach public void before() {
	 * business.setDataService(someDataServiceMock); }
	 */
	
	@Test
	void addition_DataService() {
		
		when(someDataServiceMock.retriveData()).thenReturn(new Integer[] {1,2,3});
		int actualResult=business.addition_DataService();
		int expectedResult=6;
		assertEquals(expectedResult,actualResult);
	}
	
	@Test
	void addition_DataServiceEmpty() {
		
		when(someDataServiceMock.retriveData()).thenReturn(new Integer[] {});
		int actualResult=business.addition_DataService();
		int expectedResult=0;
		assertEquals(expectedResult,actualResult);
	}

	@Test
	void addition_DataServiceWithOneElement() {
		
		when(someDataServiceMock.retriveData()).thenReturn(new Integer[] {5});
		int actualResult=business.addition_DataService();
		int expectedResult=5;
		assertEquals(expectedResult,actualResult);
	}
}
