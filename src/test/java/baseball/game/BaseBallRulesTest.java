package baseball.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.BaseBallRules;

public class BaseBallRulesTest {

	@DisplayName("validateNumber 검증하기")
	@ParameterizedTest
	@CsvSource(value = {"158:true", "967:true", "9236:false", "406:false", "554:false", "797:false", "abc:false", "123A:false"}, delimiter = ':')
	public void validateNumberTest(String number, boolean expected) {
		boolean result = BaseBallRules.validateNumber(number);
		assertEquals(expected, result);
	}

	@DisplayName("두 값에 대한 결과 출력하기")

	@ParameterizedTest
	@CsvSource(value = {"158:1볼", "692:1스트라이크", "167:낫싱", "523:1스트라이크 2볼", "123:2볼", "532:3스트라이크"}, delimiter = ':')
	public void compareTest(String userNumber, String expected) {
		String opponentNumber = "532";

		String result = BaseBallRules.compare(opponentNumber, userNumber);
		assertEquals(expected, result);
	}
}
