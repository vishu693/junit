package com.vishu.junittesting.junittesting.assertJ;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AsserJTestCase {

	@Test
	void test() {
		List<Integer> number=Arrays.asList(12,15,17);
		
		
		assertThat(number).hasSize(3).contains(12,15).allMatch(x -> x > 10).noneMatch(x -> x < 0);
		assertThat("").isEmpty();
		assertThat("abc").startsWith("ab");
	}

}
