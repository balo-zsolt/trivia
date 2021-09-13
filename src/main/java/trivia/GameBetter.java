package trivia;

import java.util.ArrayList;
import java.util.List;

import static trivia.Console.*;

public class GameBetter implements IGame {

	private static final int MAX_NR_PLAYER = 6;
	private static final int FIRST = 0;
	private final List<Player> players = new ArrayList<>(MAX_NR_PLAYER);
	private final Question question = new Question();
	private int currentPlayer = 0;

	public void add(String playerName) {
		players.add(new Player(playerName));
		printAddPlayer(playerName, players.size());
	}

	public void roll(final int roll) {
		printRoll(currentPlayer().getName(), roll);
		handleGettingOutOfPenaltyBox(roll);
		handleAdvancePlayer(roll);
	}

	private void handleGettingOutOfPenaltyBox(final int roll) {
		if (currentPlayer().isInPenaltyBox()) {
			final boolean isRollOdd = roll % 2 != 0;
			currentPlayer().setGettingOutOfPenaltyBox(isRollOdd);
			printGettingOutOfPenaltyBox(currentPlayer().getName(), isRollOdd);
		}
	}

	private void handleAdvancePlayer(int roll) {
		if (currentPlayer().isAbleToAdvance(roll)) {
			advancePlayer(roll);
		}
	}

	private void advancePlayer(int roll) {
		currentPlayer().movePlayer(roll);
		printAdvancePlayer(currentPlayer().getName(), currentPlayer().getPlace(), question.currentCategory(currentPlayer().getPlace()).getLabel(), question.askQuestion(question.currentCategory(currentPlayer().getPlace())));
	}

	public boolean wasCorrectlyAnswered() {
		if (currentPlayer().isNotPunished()) {
			winCoins();
		}
		boolean winner = currentPlayer().didPlayerWin();
		changeToNextPlayer();
		return winner;
	}

	private void winCoins() {
		currentPlayer().addCoins();
		printTurn(currentPlayer().getName(), currentPlayer().getCoins());
	}

	public boolean wrongAnswer() {
		printWrongAnswer(currentPlayer().getName());
		currentPlayer().putInPenaltyBox();
		changeToNextPlayer();
		return true;
	}

	private void changeToNextPlayer() {
		currentPlayer++;
		if (currentPlayer == players.size()) {
			currentPlayer = FIRST;
		}
	}

	private Player currentPlayer() {
		return players.get(currentPlayer);
	}

}
