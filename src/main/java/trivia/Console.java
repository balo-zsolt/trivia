package trivia;

import static java.lang.System.out;

public class Console {

    private Console() {}

    static void printAddPlayer(final String playerName, final int nrOfPlayers) {
        out.println(playerName + " was added");
        out.println("They are player number " + nrOfPlayers);
    }

    static void printRoll(final String playerName, final int roll) {
        out.println(playerName + " is the current player");
        out.println("They have rolled a " + roll);
    }

    static void printGettingOutOfPenaltyBox(final String playerName, final boolean isGettingOutOfPenaltyBox) {
        out.println(playerName + " is " + (isGettingOutOfPenaltyBox ? "" : "not ")
                + "getting out of the penalty box");
    }

    static void printAdvancePlayer(final String playerName, final int place, final String category, final String question) {
        out.println(playerName + "'s new location is " + place);
        out.println("The category is " + category);
        out.println(question);
    }

    static void printTurn(final String playerName, final int coins) {
        out.printf("Answer was correct!!!!%s%s now has %d Gold Coins.%n", System
                .lineSeparator(), playerName, coins);
    }

    static void printWrongAnswer(final String playerName) {
        out.println("Question was incorrectly answered");
        out.println(playerName + " was sent to the penalty box");
    }
}
