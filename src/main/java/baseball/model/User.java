package baseball.model;

import nextstep.utils.Console;

public class User {

	private String number;

	public String getNumber() {
		return number;
	}

	public String readLine() {
		return Console.readLine();
	}

	public String getReadNumber() {
		number = Console.readLine();
		return getNumber();
	}
}
