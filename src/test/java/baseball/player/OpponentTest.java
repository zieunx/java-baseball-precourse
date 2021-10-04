package baseball.player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.game.BaseBallRules;

public class OpponentTest {

	@DisplayName("상대(컴퓨터) 난수생성이 조건에 맞는지 확인하기")
	@Test
	public void generateOpponent() {
		Opponent opponent = new Opponent();

		assertThat(BaseBallRules.validateNumber(opponent.getNumber())).isTrue();
	}

}
