package baseball.model;

import baseball.type.GameState;

public class BaseBallGame {

	private boolean isSuccess;
	private GameState gameState = GameState.START;
	private User user;
	private Opponent opponent;

	public boolean isContinue() {
		return GameState.START == gameState;
	}

	public void play() {
		reset();

		while (!isSuccess) {
			nextRound();
		}
		System.out.println(BaseBallRules.SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	public void checkContinue() {
		String code = "";
		while (!GameState.hasCode(code)) {
			code = readGameState();
		}
		gameState = GameState.findByCode(code);
	}

	private String readGameState() {
		System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
		return user.readLine();
	}

	private void reset() {
		isSuccess = false;
		gameState = GameState.START;
		user = new User();
		opponent = new Opponent();
	}

	private void nextRound() {
		System.out.print("숫자를 입력해주세요. : ");
		String playerInput = user.readNumber();

		if (!BaseBallRules.validateNumber(playerInput)) {
			return;
		}

		String result = BaseBallRules.compare(opponent.getNumber(), user.getNumber());
		System.out.println(result);

		isSuccess = result.equals(BaseBallRules.SIZE + "스트라이크");
	}
}
