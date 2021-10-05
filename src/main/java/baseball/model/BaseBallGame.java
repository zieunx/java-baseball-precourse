package baseball.model;

public class BaseBallGame {

	static final int START_GAME_CODE = 1;

	private boolean isSuccess;
	private int gameState = START_GAME_CODE;
	private User user;
	private Opponent opponent;

	public boolean isContinue() {
		return START_GAME_CODE == gameState;
	}

	public void play() {
		reset();

		while (!isSuccess) {
			nextRound();
		}
		System.out.println(BaseBallRules.SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	public void checkContinue() {
		String input = "";
		while (!input.equals("1") && !input.equals("2")) {
			System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
			input = user.readLine();
		}
		gameState = Integer.parseInt(input);
	}

	private void reset() {
		isSuccess = false;
		gameState = START_GAME_CODE;
		user = new User();
		opponent = new Opponent();
	}

	private void nextRound() {
		System.out.print("숫자를 입력해주세요. : ");
		String playerInput = user.getReadNumber();

		if (!BaseBallRules.validateNumber(playerInput)) {
			return;
		}

		String result = BaseBallRules.compare(opponent.getNumber(), user.getNumber());
		System.out.println(result);

		isSuccess = result.equals(BaseBallRules.SIZE + "스트라이크");
	}
}
