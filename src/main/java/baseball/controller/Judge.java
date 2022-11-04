package baseball.controller;

import baseball.Player;
import baseball.view.OutputView;

public class Judge {
	public static void getGameResult(Player player) {
		int ballCount = player.getBall();
		int strikeCount = player.getStrike();
		judgeStrike(ballCount, strikeCount);
		judgeBall(ballCount, strikeCount);
		judgeNothing(ballCount, strikeCount);
		judgeBallAndStrike(ballCount, strikeCount);
	}

	public static void judgeStrike(int ballCount, int strikeCount) {
		if (strikeCount > 0 && ballCount == 0) {
			OutputView.printStrikeCount(strikeCount);
		}
	}

	public static void judgeBall(int ballCount, int strikeCount) {
		if (strikeCount == 0 && ballCount > 0) {
			OutputView.printBallCount(ballCount);
		}
	}

	public static void judgeNothing(int ballCount, int strikeCount) {
		if (strikeCount == 0 && ballCount == 0) {
			OutputView.printNothing();
		}
	}

	public static void judgeBallAndStrike(int ballCount, int strikeCount) {
		if (strikeCount > 0 && ballCount > 0) {
			OutputView.printBallAndStrikeCount(ballCount, strikeCount);
		}
	}
}
