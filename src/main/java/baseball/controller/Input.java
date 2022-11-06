package baseball.controller;

import baseball.exception.PlayerNumberException;
import baseball.exception.RestartNumberException;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
	public static List<Integer> getPlayerNumbers() {
		String inputPlayerNumber = getInput();
		PlayerNumberException.validatePlayerNumber(inputPlayerNumber);
		return stringToList(inputPlayerNumber);
	}

	private static List<Integer> stringToList(String inputPlayerNumber) {
		String[] inputPlayerNumberArray = inputPlayerNumber.split("");
		return Arrays.stream(inputPlayerNumberArray)
			.map(playerNumber -> Integer.parseInt(playerNumber))
			.collect(Collectors.toList());
	}

	public static int getRestartNumber(int restartNumber, int exitNumber) {
		String inputRestartNumber = getInput();
		RestartNumberException.validateRestartNumber(inputRestartNumber, restartNumber, exitNumber);
		return Integer.parseInt(inputRestartNumber);
	}

	private static String getInput() {
		InputView.printInputNumber();
		return Console.readLine();
	}
}
