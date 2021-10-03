package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	// 요구사항 1
	@DisplayName("Set의 size()메소드로 Set의 크기 확인하기")
	@Test
	void setSizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	// 요구사항 2
	@DisplayName("ParameterizedTest의 ValueSource 활용하기")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void setContains_ValueSourceTest(int number) {
		assertTrue(numbers.contains(number));
	}

	// 요구사항 3
	@DisplayName("ParameterizedTest의 CsvSource 활용하기")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void setContains_CsvSourceTest(int number, boolean expected) {
		boolean result = numbers.contains(number);
		assertEquals(expected, result);
	}
}
