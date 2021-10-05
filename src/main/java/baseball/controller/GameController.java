package baseball.controller;

import baseball.model.BaseBallGame;

public class GameController {

	private final BaseBallGame baseBallGame;

	public GameController(BaseBallGame baseBallGame) {
		this.baseBallGame = baseBallGame;
	}

	public void run() {
		while (baseBallGame.isContinue()) {
			baseBallGame.play();
			baseBallGame.checkContinue();
		}
	}
}
