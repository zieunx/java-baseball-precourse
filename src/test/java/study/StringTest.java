package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	// 요구사항 1
	@Test
	public void splitTest() {

		// https://assertj.github.io/doc/#assertj-core-group-contains
		// contains(...): 순서에 관계 없이 값을 포함하고 있는지 확인
		assertThat("1,2".split(",")).containsExactly("1", "2");
		// containsExactly(...): 순서대로 다른것이 없는지 확인
		assertThat("1".split(",")).contains("1");
	}

	// 요구사항 2
	@Test
	public void removeParenthesesTest() {
		String value = "(1,2)";
		assertThat(value.substring(1, value.length() - 1)).isEqualTo("1,2");
	}

	// 요구사항 3
	@DisplayName("String의 charAt()로 특정 문자 가져오기")
	@Test
	public void charAtTest() {
		String value = "abc";

		assertThat(value.charAt(2)).isEqualTo('c');
		assertThatThrownBy(() -> value.charAt(3))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range:");

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> value.charAt(3))
			.withMessageMatching("String index out of range: \\d");
	}
}
