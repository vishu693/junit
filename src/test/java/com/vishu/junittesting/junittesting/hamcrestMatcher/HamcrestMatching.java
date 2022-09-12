package com.vishu.junittesting.junittesting.hamcrestMatcher;


import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;

class HamcrestMatching {

	@Test
	void test() {
		
		List<Integer> number=Arrays.asList(12,15,17);
		
		assertThat(number,hasSize(3));
		assertThat(number,hasItem(15));
		
		assertThat(number,everyItem(greaterThan(10)));
		assertThat(number,everyItem(lessThan(20)));
		assertThat("Vist",containsString("st"));
		assertThat("Vist",startsWith("Vi"));
		assertThat("Vist",endsWith("st"));
	}

}
