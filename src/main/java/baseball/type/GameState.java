package baseball.type;

public enum GameState {
	START(1),
	STOP(2);

	private final int code;

	GameState(int code) {
		this.code = code;
	}
	public static boolean hasCode(String code) {
		return findByCode(code) != null;
	}

	public static GameState findByCode(String code) {
		for (GameState gameState : GameState.values()) {
			if (code.equals(String.valueOf(gameState.code))) {
				return gameState;
			}
		}
		return null;
	}
}
