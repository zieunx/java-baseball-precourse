package baseball.model;

import nextstep.utils.Randoms;

public class Opponent {

	private final String number;

	public Opponent() {
		this.number = createNumber();
	}

	public String getNumber() {
		return this.number;
	}

	private String createNumber() {
		StringBuilder stringBuilder = new StringBuilder();

		while (stringBuilder.length() != BaseBallRules.SIZE) {
			stringBuilder.append(makeRandomNumber());
		}

		return stringBuilder.toString();
	}

	private String makeRandomNumber() {
		int numberInRange = Randoms.pickNumberInRange(BaseBallRules.MIN, BaseBallRules.MAX);

		if (number != null && number.contains(String.valueOf(numberInRange))) {
			return makeRandomNumber();
		}

		return String.valueOf(numberInRange);
	}
}
