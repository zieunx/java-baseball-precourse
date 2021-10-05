package baseball;

import baseball.controller.GameController;
import baseball.model.BaseBallGame;

public class Application {
	public static void main(String[] args) {
		GameController gameController = new GameController(new BaseBallGame());
		gameController.run();
	}
}
