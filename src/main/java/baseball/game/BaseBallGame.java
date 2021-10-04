package baseball.game;

import baseball.player.Opponent;
import baseball.player.User;

public class BaseBallGame {

	private User user;
	private Opponent opponent;

	static final int START_GAME_CODE = 1;

	static int gameState = START_GAME_CODE;
	static boolean isCorrect = false;

	public void run() {
		while (gameState == START_GAME_CODE) {
			isCorrect = false;
			gameState = START_GAME_CODE;
			user = new User();
			opponent = new Opponent();
			playGame();
		}
	}

	private void playGame() {
		while (!isCorrect) {
			nextRound();
		}
		System.out.println(BaseBallRules.SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝");

		gameState = isContinue();
	}

	private int isContinue() {
		String input = "";
		while (!input.equals("1") && !input.equals("2")) {
			System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
			input = user.readLine();
		}
		return Integer.parseInt(input);
	}

	private void nextRound() {
		System.out.print("숫자를 입력해주세요. : ");
		String playerInput = user.getReadNumber();

		if (!BaseBallRules.validateNumber(playerInput)) {
			return;
		}

		String result = BaseBallRules.compare(opponent.getNumber(), user.getNumber());
		System.out.println(result);

		isCorrect = result.equals(BaseBallRules.SIZE + "스트라이크");
	}
}
