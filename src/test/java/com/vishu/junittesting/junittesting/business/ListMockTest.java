package com.vishu.junittesting.junittesting.business;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ListMockTest {
	
	List<String> mock=mock(List.class);

	@Test
	void size_basic() {
	
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	
	@Test
	void size_diffirent() {
		
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10,mock.size());
	}
	
	@Test
	void size_return() {
		
		when(mock.get(anyInt())).thenReturn("Vishal");
		assertEquals("Vishal",mock.get(0));
		assertEquals("Vishal",mock.get(1));
		assertEquals("Vishal",mock.get(2));
		
	}
	
	
	@Test
	void verificatonBasic() {
		
		String value1=mock.get(0);
		String value2=mock.get(1);
		
		verify(mock).get(0);
		verify(mock,times(2)).get(anyInt());
		verify(mock,atLeast(1)).get(anyInt());
		verify(mock,atMost(2)).get(anyInt());
		verify(mock,never()).get(2);
		
		
		
	}
	
	@Test
	void argumentCapture() {
		
	mock.add("Vishal Arora");
	ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
	verify(mock).add(captor.capture());
	assertEquals("Vishal Arora",captor.getValue());
		
	}
		
	 
	
	@Test
	void argumentMultipleCapture() {
		
	mock.add("Vishal Arora");
	mock.add("Vishal Arora1");
	ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
	verify(mock,times(2)).add(captor.capture());
	
	List<String> values=captor.getAllValues();
	assertEquals("Vishal Arora",values.get(0));
	assertEquals("Vishal Arora1",values.get(1));
		
	}
	
	
	@Test
	void spying() {
		
	ArrayList arrayList=mock(ArrayList.class);
	System.out.println(arrayList.get(0));//null
	System.out.println(arrayList.size());//0
	arrayList.add("Vishal");
	arrayList.add(1);
	System.out.println(arrayList.size()); //0
	
	
	when(arrayList.size()).thenReturn(5	);
	System.out.println(arrayList.size());//5
	
		
	}
	

	@Test
	void spyingActual() {
		
	ArrayList arrayList=spy(ArrayList.class);
	arrayList.add("lavya");
	System.out.println(arrayList.get(0));//Lavya
	System.out.println(arrayList.size());//1
	arrayList.add("Vishal");
	arrayList.add(1);
	System.out.println(arrayList.size()); //3
	
	
	when(arrayList.size()).thenReturn(5	);
	System.out.println(arrayList.size());//5
	
	arrayList.add(2);
	System.out.println(arrayList.size());//5
	
	
	arrayList.add(3);
	verify(arrayList).add(3);
		
	}

	public List<String> getMock() {
		return mock;
	}

	public void setMock(List<String> mock) {
		this.mock = mock;
	}
		
	 

}
