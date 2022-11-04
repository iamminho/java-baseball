package baseball.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exception {
	private static final int NUMBER_LENGTH = 3;
	private static final int NUMBER_BOUNDARY_START = 1;
	private static final int NUMBER_BOUNDARY_END = 9;
	private static final String RESTART_NUMBER = "1";
	private static final String EXIT_NUMBER = "2";
	private static final String LIMIT_NUMBER_BOUNDARY = String.format("[ERROR] %d부터 %d까지의 숫자만 입력해 주시기 바랍니다.",
		NUMBER_BOUNDARY_START, NUMBER_BOUNDARY_END);
	private static final String LIMIT_NUMBER_LENGTH = String.format("[ERROR] %d자리의 숫자만 입력해 주시기 바랍니다.", NUMBER_LENGTH);
	private static final String LIMIT_NUMBER_OVERLAP = "[ERROR] 중복되지 않는 숫자만 입력해주시기 바랍니다.";
	private static final String LIMIT_RESTART_NUMBER_BOUNDARY = String.format("[ERROR] %s혹은 %s숫자만 입력해 주시기 바랍니다.",
		RESTART_NUMBER, EXIT_NUMBER);

	public static void validatePlayerNumber(String inputPlayerNumber) {
		try {
			validateOnlyOneToNine(inputPlayerNumber);
			validateNumberLength(inputPlayerNumber);
			validateOverlapNumber(inputPlayerNumber);
		} catch (IllegalArgumentException error) {
			System.out.println(error);
			throw new IllegalArgumentException();
		}
	}

	public static void validateOnlyOneToNine(String inputPlayerNumber) {
		String regExp = String.format("^[%d-%d]+$", NUMBER_BOUNDARY_START, NUMBER_BOUNDARY_END);
		if (!inputPlayerNumber.matches(regExp)) {
			throw new IllegalArgumentException(LIMIT_NUMBER_BOUNDARY);
		}
	}

	public static void validateNumberLength(String inputPlayerNumber) {
		if (inputPlayerNumber.length() != NUMBER_LENGTH) {
			throw new IllegalArgumentException(LIMIT_NUMBER_LENGTH);
		}
	}

	public static void validateOverlapNumber(String inputPlayerNumber) {
		String[] inputPlayerNumbers = inputPlayerNumber.split("");
		Set<String> inputPlayerNumberSet = new HashSet<>();
		inputPlayerNumbersToSet(inputPlayerNumberSet, inputPlayerNumbers);

		if (inputPlayerNumberSet.size() != inputPlayerNumbers.length) {
			throw new IllegalArgumentException(LIMIT_NUMBER_OVERLAP);
		}
	}

	private static void inputPlayerNumbersToSet(Set<String> inputPlayerNumberSet, String[] inputPlayerNumber) {
		Arrays.stream(inputPlayerNumber)
			.forEach(number -> inputPlayerNumberSet.add(number));
	}

	public static void validateRestartNumber(String inputRestartNumber) {
		try {
			Exception.validateRestartOrExitNumber(inputRestartNumber);
		} catch (IllegalArgumentException error) {
			System.out.println(error);
			throw new IllegalArgumentException();
		}
	}

	public static void validateRestartOrExitNumber(String inputRestartNumber) {
		if (!inputRestartNumber.equals(RESTART_NUMBER) && !inputRestartNumber.equals(EXIT_NUMBER)) {
			throw new IllegalArgumentException(LIMIT_RESTART_NUMBER_BOUNDARY);
		}
	}
}
