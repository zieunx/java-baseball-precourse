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
			makeRandomNumber(stringBuilder);
		}

		return stringBuilder.toString();
	}

	private void makeRandomNumber(StringBuilder stringBuilder) {
		int numberInRange = Randoms.pickNumberInRange(BaseBallRules.MIN, BaseBallRules.MAX);

		if (stringBuilder.toString().contains(String.valueOf(numberInRange))) {
			return;
		}

		stringBuilder.append(numberInRange);
	}
}
