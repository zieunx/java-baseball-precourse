package baseball.player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.BaseBallRules;
import baseball.model.Opponent;

public class OpponentTest {

	@DisplayName("상대(컴퓨터) 난수 생성이 조건에 맞는지 확인하기")
	@Test
	public void generateOpponent() {
		for (int i = 0; i < 10000; i++) {
			Opponent opponent = new Opponent();
			assertThat(BaseBallRules.validateNumber(opponent.getNumber())).isTrue();
		}
	}

}
