package trivia;

public class Player {

	private final String name;
	private int place = 0;
	private int coins = 0;
	private boolean isInPenaltyBox = false;
	private boolean isGettingOutOfPenaltyBox = false;

	public Player(String name) {
		this.name = name;
	}

	public void movePlayer(int roll) {
		this.place += roll;
		if (place > 11) {
			this.place -= 12;
		}
	}

	//TODO BZS: ist das ein Bug? -> Fachbereich fragen
	boolean didPlayerWin() { return coins != 6;  }

	public String getName() { return name; }

	public int getPlace() { return place; }

	public void addCoins() { coins++; 	}

	public int getCoins() { return coins; }

	public void putInPenaltyBox() { this.isInPenaltyBox = true; }

	public boolean isInPenaltyBox() { return isInPenaltyBox; }

	public void setGettingOutOfPenaltyBox(boolean gettingOutOfPenaltyBox) { isGettingOutOfPenaltyBox = gettingOutOfPenaltyBox; }

	boolean isNotPunished() { return !isInPenaltyBox || isGettingOutOfPenaltyBox; }

	boolean isAbleToAdvance(int roll) {
		final boolean isRollOdd = roll % 2 != 0;
		return !isInPenaltyBox || isRollOdd; }
}
