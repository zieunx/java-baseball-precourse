package baseball.game;

import java.util.HashSet;
import java.util.Set;

public class BaseBallRules {

	public static final int MIN = 1;
	public static final int MAX = 9;
	public static final int SIZE = 3;

	public static boolean validateNumber(String number) {
		if (number.length() != SIZE) {
			System.out.println("[ERROR] 길이는 " + SIZE + "이어야 합니다.");
			return false;
		}

		try {
			Integer.parseInt(number);
		} catch (NumberFormatException | NullPointerException e) {
			System.out.println("[ERROR] 숫자만 입력 가능합니다.(" + MIN + "~" + MAX + "사이의 숫자만 가능)");
			return false;
		}

		if (number.contains("0")) {
			System.out.println("[ERROR] 0은 입력할 수 없습니다.(" + MIN + "~" + MAX + "사이의 숫자만 가능)");
			return false;
		}

		if (isDuplicateNumber(number)) {
			System.out.println("[ERROR] 세 숫자가 중복되지 않게 입력해주세요.");
			return false;
		}

		return true;
	}

	public static String compare(String opponentNumber, String userNumber) {
		return getResult(opponentNumber, userNumber);
	}

	private static String getResult(String opponentNumber, String userNumber) {
		int ball = countBall(opponentNumber, userNumber);
		int strike = countStrike(opponentNumber, userNumber);

		if (ball == 0 && strike == 0) {
			return "낫싱";
		}

		return (makeResult(strike, "스트라이크 ") + makeResult(ball, "볼")).trim();
	}

	private static String makeResult(int count, String unit) {
		if (count == 0) {
			return "";
		}
		return count + unit;
	}

	private static int countBall(String opponentNumber, String userNumber) {
		int count = 0;
		for (int idx = 0; idx < opponentNumber.length(); idx++) {
			count += checkContainAndOtherLocation(opponentNumber, userNumber.charAt(idx), idx);
		}
		return count;
	}

	private static int countStrike(String opponentNumber, String userNumber) {
		int count = 0;
		for (int idx = 0; idx < opponentNumber.length(); idx++) {
			count += checkSameLocation(opponentNumber.charAt(idx), userNumber.charAt(idx));
		}
		return count;
	}

	private static int checkContainAndOtherLocation(String opponentNumber, char number, int idx) {
		return opponentNumber.charAt(idx) != number && opponentNumber.contains(String.valueOf(number)) ? 1 : 0;
	}

	private static int checkSameLocation(char opponentNumber, char number) {
		return opponentNumber == number ? 1 : 0;
	}

	private static boolean isDuplicateNumber(String number) {
		Set<Integer> numbers = new HashSet<>();
		for (int i = 0; i < number.length(); i++) {
			numbers.add(Character.getNumericValue(number.charAt(i)));
		}
		return numbers.size() != SIZE;
	}
}
